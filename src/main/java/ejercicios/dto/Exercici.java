
package ejercicios.dto;

/**
 *
 * @author laura
 */
public class Exercici {
   private int id;
   private String nomExercici;
   private String descripcio;
   private String demoFoto;

           @Override
    public String toString(){
    return nomExercici;
    }
    
    public Exercici() {
    }

    public Exercici(int id, String nomExercici, String descripcio, String demoFoto) {
        this.id = id;
        this.nomExercici = nomExercici;
        this.descripcio = descripcio;
        this.demoFoto = demoFoto;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomExercici() {
        return nomExercici;
    }

    public void setNomExercici(String nomExercici) {
        this.nomExercici = nomExercici;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public String getDemoFoto() {
        return demoFoto;
    }

    public void setDemoFoto(String demoFoto) {
        this.demoFoto = demoFoto;
    }
   
   
}
