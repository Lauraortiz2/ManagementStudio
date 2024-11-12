
package ejercicios.dto;

/**
 *
 * @author laura
 */
public class ExercicisWorkouts {
    private int id;
    private int idWorkout;
    private int idExercici;
    

    public ExercicisWorkouts() {
    }
    
    public ExercicisWorkouts(int id, int idWorkout, int idExercici) {
        this.id = id;
        this.idWorkout = idWorkout;
        this.idExercici = idExercici;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdWorkout() {
        return idWorkout;
    }

    public void setIdWorkout(int idWorkout) {
        this.idWorkout = idWorkout;
    }

    public int getIdExercici() {
        return idExercici;
    }

    public void setIdExercici(int idExercici) {
        this.idExercici = idExercici;
    }
    
    
}
