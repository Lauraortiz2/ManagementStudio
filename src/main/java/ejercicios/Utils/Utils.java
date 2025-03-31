
package ejercicios.Utils;

import ejercicios.DataAcces.DataAccess;
import ejercicios.dto.Exercici;
import ejercicios.dto.Usuari;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 * Clase de utilidades
 * Proporciona métodos auxiliares para diversas operaciones de la aplicación
 * @author laura
 */
public class Utils {

    /**
     * crear un modelo para un ComboBox de objetos Exercici
     * @return modelo para ComboBox
     */
    public static DefaultComboBoxModel<Exercici> pintarExer() {
        ArrayList<Exercici> exercicis = DataAccess.getAllExercicis();
        DefaultComboBoxModel<Exercici> dfme = new DefaultComboBoxModel<>();
        for (Exercici e : exercicis) {
            dfme.addElement(e);
        }
        return dfme;
    }
    
    /**
     * crear un modelo para un Combobox de objetos Usuari
     * @return modelo para ComboBox
     */
        public static DefaultComboBoxModel<Usuari> pintarUsers() {
        ArrayList<Usuari> users = DataAccess.getAllUsers();
        DefaultComboBoxModel<Usuari> dfmu = new DefaultComboBoxModel<>();
        for (Usuari u : users) {
            dfmu.addElement(u);
        }
        return dfmu;
    }
        
        /**
         * crear un modelo para una lista de objetos Exercici
         * @return modelo para lista
         */
        public static DefaultListModel pintarExers() {
        ArrayList<Exercici> exercicis = DataAccess.getAllExercicis();
        DefaultListModel<Exercici> dfme = new DefaultListModel<>();
        for (Exercici e : exercicis) {
            dfme.addElement(e);
        }
        return dfme;
    }

}
