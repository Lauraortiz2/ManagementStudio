package ejercicios.DataAcces;

import ejercicios.dto.Exercici;
import ejercicios.dto.Usuari;
import ejercicios.dto.Workout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author laura
 * Proporciona métodos para interactuar con la base de datos.
 */
public class DataAccess {
    
    /**
     *Obtiene una conexión con la base de datos
     * @return un objteo Connection si se realiza la conexión con éxito, en caso contrario un null.
     */
    public static Connection getConnection() {
        Connection connection = null;
        Properties properties = new Properties();
        try {
            //properties.load(DataAccess.class.getClassLoader().getResourceAsStream("properties/application.properties"));
            //connection = DriverManager.getConnection(properties.getProperty("connectionUrl"));
            String connectionUrl = "jdbc:sqlserver://localhost:1433;database=simulapdb;user=sa;password=pwd1234.;encrypt=false;loginTimeout=10;";
            String connectionUrlAzure = "jdbc:sqlserver://simulapsqlserver.database.windows.net:1433;database=simulapdb25;user=simulapdbadmin@simulapsqlserver;password=Pwd1234.;encrypt=true;trustServerCertificate=false;hostNameInCertificate=*.database.windows.net;loginTimeout=30;";

//            connection = DriverManager.getConnection(connectionUrl);
            connection = DriverManager.getConnection(connectionUrlAzure);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * Recuperar un usuario por su email
     * @param email
     * @return un objeto Usuari si se encuentra o un null en caso contrario.
     */
    public static Usuari getUser(String email) {
        Usuari user = null;
        String sql = "SELECT * FROM Usuaris WHERE Email = ?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setString(1, email);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    /**
     * Recuperar los usuarios que no son instructores
     * @return una lista de objetos Usuari 
     */
    public static ArrayList<Usuari> getAllUsers() {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE Instructor=0";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                usuaris.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuaris;
    }

    /**
     * Recupera los usuarios por instructor
     * @param idInstructor
     * @return una lista de objetos Usuari
     */
    public static ArrayList<Usuari> getAllUsersByInstructor(int idInstructor) {
        ArrayList<Usuari> usuaris = new ArrayList<>();
        String sql = "SELECT * FROM Usuaris WHERE AssignedInstructor=?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, idInstructor);
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Usuari user = new Usuari();
                user.setId(resultSet.getInt("Id"));
                user.setNom(resultSet.getString("Nom"));
                user.setEmail(resultSet.getString("Email"));
                user.setPasswordHash(resultSet.getString("PasswordHash"));
                user.setInstructor(resultSet.getBoolean("Instructor"));
                usuaris.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuaris;
    }

    /**
     * Recupera las workouts por usuario
     * @param user
     * @return una lista de objetos Workout
     */
    public static ArrayList<Workout> getWorkoutsPerUser(Usuari user) {
        ArrayList<Workout> workouts = new ArrayList<>();
        String sql = "SELECT Workouts.Id, Workouts.ForDate, Workouts.UserId, Workouts.Comments"
                + " FROM Workouts"
                + " WHERE Workouts.UserId=?"
                + " ORDER BY Workouts.ForDate";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, user.getId());
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Workout workout = new Workout();
                workout.setId(resultSet.getInt("Id"));
                workout.setForDate(resultSet.getString("ForDate"));
                workout.setIdUsuari(resultSet.getInt("UserId"));
                workout.setComments(resultSet.getString("Comments"));

                workouts.add(workout);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return workouts;

    }

    /**
     * Recupera los ejercicios por workout
     * @param workout
     * @return una lista de objetos Exercici
     */
    public static ArrayList<Exercici> getExercicisPerWorkout(Workout workout) {
        ArrayList<Exercici> exercicis = new ArrayList<>();
        String sql = "SELECT ExercicisWorkouts.IdExercici,"
                + " Exercicis.NomExercici, Exercicis.Descripcio, Exercicis.DemoFoto"
                + " FROM ExercicisWorkouts INNER JOIN Exercicis ON ExercicisWorkouts.IdExercici=Exercicis.Id"
                + " WHERE ExercicisWorkouts.IdWorkout=?";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, workout.getId());
            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Exercici exercici = new Exercici();
                exercici.setId(resultSet.getInt("IdExercici"));
                exercici.setNomExercici(resultSet.getString("NomExercici"));
                exercici.setDescripcio(resultSet.getString("Descripcio"));
                //exercici.setDemoFoto(resultSet.getString("DemoFoto"));

                exercicis.add(exercici);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercicis;
    }

    /**
     * Recupera todos los ejercicios
     * @return una lista de objetos Exercici
     */
    public static ArrayList<Exercici> getAllExercicis() {
        ArrayList<Exercici> exercicis = new ArrayList<>();
        String sql = "SELECT Id, Exercicis.NomExercici, Exercicis.Descripcio, Exercicis.DemoFoto"
                + " FROM Exercicis";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {

            ResultSet resultSet = selectStatement.executeQuery();

            while (resultSet.next()) {
                Exercici exercici = new Exercici();
                exercici.setId(resultSet.getInt("Id"));
                exercici.setNomExercici(resultSet.getString("NomExercici"));
                exercici.setDescripcio(resultSet.getString("Descripcio"));
                //exercici.setDemoFoto(resultSet.getString("DemoFoto"));

                exercicis.add(exercici);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exercicis;
    }

    /**
     * Registra un nuevo usuario en la base de datos
     * @param u objeto Usuari 
     * @param imageFile archivo de imagen del usuario
     * @return id del usuario insertado
     */
    public static int registerUser(Usuari u, File imageFile) {
        String sql = "INSERT INTO dbo.Usuaris (Nom, Email, PasswordHash, Foto, FotoFilename, Instructor)"
                + " VALUES (?,?,?,?,?,?)"
                + " SELECT CAST(SCOPE_IDENTITY() as int)";

        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql)) {
            FileInputStream fis = new FileInputStream(imageFile);
            insertStatement.setString(1, u.getNom());
            insertStatement.setString(2, u.getEmail());
            insertStatement.setString(3, u.getPasswordHash());
            insertStatement.setBinaryStream(4, fis, imageFile.length());
            insertStatement.setString(5, imageFile.getName());
            insertStatement.setBoolean(6, u.isInstructor());

            int newUserId = insertStatement.executeUpdate();
            return newUserId;
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    /**
     * insertar un nuevo workout en la base de datos
     * @param w objeto Workout
     * @param exercicis lista de Exercici asociados a la workout
     */
    public static void insertWorkout(Workout w, ArrayList<Exercici> exercicis) {
        // The following should be done in a SQL transaction
        int newWorkoutId = insertToWorkoutTable(w);
        insertExercisesPerWorkout(newWorkoutId, exercicis);
    }

    /**
     * insertar un workout en la tabla Workouts
     * @param w objeto workout
     * @return id del workout insertado
     */
    private static int insertToWorkoutTable(Workout w) {
        String sql = "INSERT INTO dbo.Workouts (ForDate, UserId, Comments)"
                + " VALUES (?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);) {
            insertStatement.setString(1, w.getForDate());
            insertStatement.setInt(2, w.getIdUsuari());
            insertStatement.setString(3, w.getComments());

            int affectedRows = insertStatement.executeUpdate();

            if (affectedRows > 0) {
                // Retrieve the generated keys (identity value)
                ResultSet resultSet = insertStatement.getGeneratedKeys();

                // Check if a key was generated
                if (resultSet.next()) {
                    // Get the last inserted identity value
                    int lastInsertedId = resultSet.getInt(1);
                    return lastInsertedId;
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * inserta ejercicios por workout
     * @param wId id de una workout
     * @param exercicis lista de ejercicios asociados a la workout
     * @return tamaño de la lista de ejercicios insertada
     */
    private static int insertExercisesPerWorkout(int wId, ArrayList<Exercici> exercicis) {
        for (Exercici e : exercicis) {
            int rowsAffected = insertExerciciPerWorkout(wId, e);
            if (rowsAffected != 1) {
                return 0;
            }
        }
        return exercicis.size();
    }

    /**
     * insertar ejercicios por workout
     * @param wId id de la workout
     * @param e objeto Exercici
     * @return número de filas afectadas
     */
    private static int insertExerciciPerWorkout(int wId, Exercici e) {
        String sql = "INSERT INTO dbo.ExercicisWorkouts (IdWorkout, IdExercici)"
                + " VALUES (?,?)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql)) {
            insertStatement.setInt(1, wId);
            insertStatement.setInt(2, e.getId());
            int rowsAffected = insertStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * actualizar un ejercicio
     * @param exerId id del ejercicio
     * @param field campo a actualizar
     * @param value valor a insertar en el campo
     * @return número de filas afectadas
     */
    public int updateExercici(int exerId, String field, String value) {
        String sql = "UPDATE dbo.Exercicis SET " + field + "= '" + value + "' WHERE Id = " + exerId;
        try (Connection conn = getConnection(); PreparedStatement updateStatement = conn.prepareStatement(sql)) {

            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * insertar un ejercicio en la base de datos
     * @param nom nombre del ejercicio
     * @param descripcion descripción del ejercicio
     * @param demoFoto foto demostración del ejercicio
     * @return número de filas afectadas
     */
    public int insertExercici(String nom, String descripcion, String demoFoto) {
        String sql = "INSERT INTO dbo.Exercicis (NomExercici, Descripcio, DemoFoto)"
                + " VALUES (?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql)) {
            insertStatement.setString(1, nom);
            insertStatement.setString(2, descripcion);
            insertStatement.setString(3, demoFoto);
            int rowsAffected = insertStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * recuperar el número de ejercicios por workout
     * @param exerId id de la workout
     * @return número de veces que se repite un ejercicio en todas las workouts
     */
    public static int getCountExercicisPerWorkout(int exerId) {
        String sql = "SELECT count(IdWorkout) counter"
                + " FROM ExercicisWorkouts "
                + " WHERE ExercicisWorkouts.IdExercici=? group by IdExercici";
        try (Connection connection = getConnection(); PreparedStatement selectStatement = connection.prepareStatement(sql);) {
            selectStatement.setInt(1, exerId);
            ResultSet resultSet = selectStatement.executeQuery();
            while (resultSet.next()) {
                return resultSet.getInt("counter");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * eliminar un ejercicio de la base de datos
     * @param exerId id del ejercicio
     * @return número de filas afectadas
     */
    public int deleteExercici(int exerId) {
        String sql = "DELETE FROM dbo.Exercicis WHERE Id = " + exerId;
        try (Connection conn = getConnection(); PreparedStatement updateStatement = conn.prepareStatement(sql)) {
            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * crear una workout
     * @param date fecha de la workout
     * @param userId id del usuario al que se le asigna la workout
     * @param comments comentarios de la workout
     * @return número de filas afectadas
     */
    public int createWorkout(String date, int userId, String comments) {
        String sql = "INSERT INTO dbo.Workouts (ForDate,UserId, Comments)"
                + " VALUES (?,?,?)";
        try (Connection conn = getConnection(); PreparedStatement insertStatement = conn.prepareStatement(sql)) {
            insertStatement.setString(1, date);
            insertStatement.setInt(2, userId);
            insertStatement.setString(3, comments);
            int rowsAffected = insertStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * Eliminar un usuario de la base de datos
     * @param userId id del usuario
     * @return número de filas afectadas
     */
    public int deleteUser(int userId) {
        String sql = "DELETE FROM dbo.Usuaris WHERE Id = " + userId;
        try (Connection conn = getConnection(); PreparedStatement updateStatement = conn.prepareStatement(sql)) {
            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * actualizar un usuario
     * @param userId id del usuario
     * @param field campo que se quiere actualizar
     * @param value valor para asignar al campo
     * @return número de filas afectadas
     */
    public int updateUser(int userId, String field, String value) {
        String sql = "UPDATE dbo.Usuaris SET " + field + "= '" + value + "' WHERE Id = " + userId;
        try (Connection conn = getConnection(); PreparedStatement updateStatement = conn.prepareStatement(sql)) {
            int rowsAffected = updateStatement.executeUpdate();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     * actualizar al foto de un usuario
     * @param userId id del usuario
     * @param imageFile archivo de imagen del usuario
     * @return número de filas afectadas
     */
    public int updateFotoUser(int userId, File imageFile) {
        String sql = "UPDATE dbo.Usuaris SET Foto =?, FotoFilename = ? WHERE Id = ?";
        try (Connection conn = getConnection(); PreparedStatement updateStatement = conn.prepareStatement(sql)) {
            FileInputStream fis = new FileInputStream(imageFile);
            updateStatement.setBinaryStream(1, fis,(int) imageFile.length());
            updateStatement.setString(2, imageFile.getName());
            updateStatement.setInt(3, userId);
            int rowsAffected = updateStatement.executeUpdate();
            fis.close();
            return rowsAffected;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(DataAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

}
