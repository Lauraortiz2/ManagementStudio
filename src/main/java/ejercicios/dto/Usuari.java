
package ejercicios.dto;

/**
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
    
        @Override
    public String toString(){
    return nom;
    }
    
    public Usuari() {
    }

    public Usuari(String nom, String email, String passwordHash, String foto, boolean instructor, String assignedInstructor) {
        this.nom = nom;
        this.email = email;
        this.passwordHash = passwordHash;
        this.foto = foto;
        this.instructor = instructor;
        this.assignedInstructor = assignedInstructor;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    
    
    public boolean isInstructor() {
        return instructor;
    }

    public void setInstructor(boolean instructor) {
        this.instructor = instructor;
    }

    public String getAssignedInstructor() {
        return assignedInstructor;
    }

    public void setAssignedInstructor(String assignedInstructor) {
        this.assignedInstructor = assignedInstructor;
    }


    
    
}
