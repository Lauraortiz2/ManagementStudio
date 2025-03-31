package ejercicios.dto;

/**
 * Clase que representa un ejercicio de la base de datos Contiene información
 * sobre el id, nombre, descripción y foto de demostración
 *
 * @author laura
 */
public class Exercici {

    private int id;
    private String nomExercici;
    private String descripcio;
    private String demoFoto;

    /**
     * Constructor por defecto vacio
     */
    public Exercici() {
    }

    /**
     * Constructor por defecto con atributos
     *
     * @param id id del ejercicio
     * @param nomExercici nombre del ejercicio
     * @param descripcio descripción del ejercicio
     * @param demoFoto archivo de foto de demostración del ejercicio
     */
    public Exercici(int id, String nomExercici, String descripcio, String demoFoto) {
        this.id = id;
        this.nomExercici = nomExercici;
        this.descripcio = descripcio;
        this.demoFoto = demoFoto;
    }

    /**
     * Obtiene el id del ejercicio
     * @return id del ejercicio
     */
    public int getId() {
        return id;
    }

    /**
     * Establece el id del ejercicio
     * @param id id del ejercicio
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Obtiene el nombre del ejercicio
     * @return nombre del ejercicio
     */
    public String getNomExercici() {
        return nomExercici;
    }

    /**
     * Establece el nombre del ejercicio
     * @param nomExercici nombre del ejercicio
     */
    public void setNomExercici(String nomExercici) {
        this.nomExercici = nomExercici;
    }

    /**
     * Obtiene la descripción del ejercicio
     * @return descripción del ejericicio
     */
    public String getDescripcio() {
        return descripcio;
    }

    /**
     * Establece la descripción del ejercicio
     * @param descripcio
     */
    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    /**
     * Obtiene la imagen de demostración del ejercicio
     * @return imagen de demostración del ejercicio
     */
    public String getDemoFoto() {
        return demoFoto;
    }

    /**
     * Establece la imagen de demostración del ejercicio
     * @param demoFoto imagen de demostración del ejercicio
     */
    public void setDemoFoto(String demoFoto) {
        this.demoFoto = demoFoto;
    }

    /**
     * Método toString() de la clase Exercici
     * @return cadena de texto de los atributos.
     */
    @Override
    public String toString() {
        return "Nombre: "  + nomExercici + "descripción: " + descripcio;
    }

}
