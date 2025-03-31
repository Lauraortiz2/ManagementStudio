
package ejercicios.dto;


/**
 * Clase que representa una workout de la base de datos
 * Contiene información sobre el id, la fecha de la workout, el id de usuario asignado a la workout y comentarios sobre la workout
 * @author laura
 */
public class Workout {
    private int id;
    private String forDate;
    private int idUsuari;
    private String comments;

      /**
     * Constructor por defecto vacio
     */
    public Workout() {
    }

    /**
     * Constructor por defecto con atributos
     * @param id id de la workout
     * @param forDate fecha de la workout
     * @param userId id del usuario asignado a la workout
     * @param comments comentarios de la workout
     */
    public Workout(int id, String forDate, int userId, String comments) {
        this.id = id;
        this.forDate = forDate;
        this.idUsuari = userId;
        this.comments = comments;
    }

    /**
     * Constructor por defecto con algunos atributos
     * @param forDate fecha de la workout
     * @param userId id del usuario asignado a dicha workout
     * @param comments comentarios de la workout
     */
    public Workout(String forDate, int userId, String comments) {
        this.forDate = forDate;
        this.idUsuari = userId;
        this.comments = comments;
    }

    /**
     * Obtiene el id de la workout
     * @return id de la workout
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id de la workout
     * @param id id de la workout
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene la fecha de la workout
     * @return fecha de la workout
     */
    public String getForDate() {
        return forDate;
    }

    /**
     * Establece la fecha de la workout
     * @param forDate fecha de la workout
     */
    public void setForDate(String forDate) {
        this.forDate = forDate;
    }

    /**
     * Obtiene el id del usuario asignado a la workout
     * @return id del usuario asignado a la workout
     */
    public int getIdUsuari() {
        return idUsuari;
    }

    /**
     * Establece el id del usuario asignado a la workout
     * @param userId id del usuario asignado a la workout
     */
    public void setIdUsuari(int userId) {
        this.idUsuari = userId;
    }

    /**
     * Obtiene los comentarios de la workout
     * @return comentarios de la workout
     */
    public String getComments() {
        return comments;
    }

    /**
     * Establece los comentarios de la workout
     * @param comments comentarios de la workout
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    /**
     * Método toString() de la clase Workout
     * @return cadena de texto con los atributos.
     */
    @Override
    public String toString(){
    return id + " " + forDate + " " + idUsuari + " " + comments;
    }    
}
