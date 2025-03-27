
package ejercicios.Utils;

import ejercicios.DataAcces.DataAccess;
import ejercicios.dto.Exercici;
import ejercicios.dto.Usuari;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

/**
 *
 * @author laura
 */
public class Utils {

    public static DefaultComboBoxModel<Exercici> pintarExer() {
        ArrayList<Exercici> exercicis = DataAccess.getAllExercicis();
        DefaultComboBoxModel<Exercici> dfme = new DefaultComboBoxModel<>();
        for (Exercici e : exercicis) {
            dfme.addElement(e);
        }
        return dfme;
    }
    
        public static DefaultComboBoxModel<Usuari> pintarUsers() {
        ArrayList<Usuari> users = DataAccess.getAllUsers();
        DefaultComboBoxModel<Usuari> dfmu = new DefaultComboBoxModel<>();
        for (Usuari u : users) {
            dfmu.addElement(u);
        }
        return dfmu;
    }
        public static DefaultListModel pintarExers() {
        ArrayList<Exercici> exercicis = DataAccess.getAllExercicis();
        DefaultListModel<Exercici> dfme = new DefaultListModel<>();
        for (Exercici e : exercicis) {
            dfme.addElement(e);
        }
        return dfme;
    }

}
