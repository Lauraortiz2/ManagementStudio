package ejercicios.dto;

/**
 * Clase que representa un usuario de la base de datos. Contiene información
 * sobre el id, nombre, email, contraseña, foto del usuario, si es un instructor
 * o no, instructor asignado.
 *
 * @author laura
 */
public class Usuari {

    private int id;
    private String nom;
    private String email;
    private String passwordHash;
    private String foto;
    private boolean instructor;
    private String assignedInstructor;

    /**
     * Constructor por defecto vacío
     */
    public Usuari() {
    }

    /**
     * Constructor por defecto con atributos
     *
     * @param nom nombre del usuario
     * @param email email del usuario
     * @param passwordHash contraseña del usuario
     * @param foto foto del usuario
     * @param instructor si se trata de un instructor o no
     * @param assignedInstructor instructor que se le ha asignado al usuario
     */
    public Usuari(String nom, String email, String passwordHash, String foto, boolean instructor, String assignedInstructor) {
        this.nom = nom;
        this.email = email;
        this.passwordHash = passwordHash;
        this.foto = foto;
        this.instructor = instructor;
        this.assignedInstructor = assignedInstructor;
    }

    /**
     * Obtiene el id del usuario
     * @return id del usuario
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del usuario
     * @param id id del usuario
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del usuario
     * @return
     */
    public String getNom() {
        return nom;
    }

    /**
     * Establece el nombre del usuario
     * @param nom nombre del usuario
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Obtiene el email del usuario
     * @return email del usuario
     */
    public String getEmail() {
        return email;
    }

    /**
     * Establece el email del usuario
     * @param email email del usuario
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Obtiene la contraseña del usuario
     * @return contraseña del usuario
     */
    public String getPasswordHash() {
        return passwordHash;
    }

    /**
     * Establece la contraseña del usuario
     * @param passwordHash contraseña del usuario
     */
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    /**
     * Obtiene la foto del usuario
     * @return foto del usuario
     */
    public String getFoto() {
        return foto;
    }

    /**
     * Establece la foto del usuario
     * @param foto foto del usuario
     */
    public void setFoto(String foto) {
        this.foto = foto;
    }

    /**
     * Obtiene si el usuario es un instructor
     * @return si el usuario es un instructor o no
     */
    public boolean isInstructor() {
        return instructor;
    }

    /**
     * Establece si el usuario es un instructor
     * @param instructor si el usuario es instructor o no
     */
    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }

    /**
     * Obtiene el instructor que se le ha asignado al usuario
     * @return instructor asignado al usuario
     */
    public String getAssignedInstructor() {
        return assignedInstructor;
    }

    /**
     * Establece el instructor que se le ha asignado al usuario
     * @param assignedInstructor instructor asignado al usuario
     */
    public void setAssignedInstructor(String assignedInstructor) {
        this.assignedInstructor = assignedInstructor;
    }

    /**
     * Método toString() de la clase Usuari
     * @return cadena de texto de los atributos.
     */
    @Override
    public String toString() {
        return nom + " " + email + " " + assignedInstructor;
    }

}
