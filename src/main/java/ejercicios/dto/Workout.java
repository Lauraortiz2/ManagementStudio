
package ejercicios.dto;


/**
 *
 * @author laura
 */
public class Workout {
    private int id;
    private String forDate;
    private int idUsuari;
    private String comments;

       @Override
    public String toString(){
    return id + " " + forDate + " " + idUsuari + " " + comments;
    }
    
    public Workout() {
    }

    public Workout(int id, String forDate, int userId, String comments) {
        this.id = id;
        this.forDate = forDate;
        this.idUsuari = userId;
        this.comments = comments;
    }
    public Workout(String forDate, int userId, String comments) {
        this.forDate = forDate;
        this.idUsuari = userId;
        this.comments = comments;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getForDate() {
        return forDate;
    }

    public void setForDate(String forDate) {
        this.forDate = forDate;
    }

    public int getIdUsuari() {
        return idUsuari;
    }

    public void setIdUsuari(int userId) {
        this.idUsuari = userId;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
}
