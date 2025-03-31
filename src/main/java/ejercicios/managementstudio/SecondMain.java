
package ejercicios.managementstudio;

import ejercicios.DataAcces.DataAccess;
import ejercicios.dto.Exercici;
import ejercicios.dto.Usuari;
import ejercicios.dto.Workout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;

/**
 * Panel principal de la aplicación, que se muestra cuando hay un usuario conectado.
 * Muestra los usuarios, entrenamientos y detalles de los workouts.
 * @author laura
 */
public class SecondMain extends javax.swing.JPanel {

    /**
     * Creates new form SecondMain
     */
    private javax.swing.JList<Usuari> lstUsers;
    private javax.swing.JList<Exercici> lstWorkoutDetail;
    private javax.swing.JComboBox<Workout> cmbWorkout;

    private DataAccess da = new DataAccess();
    private Usuari userConnected = new Usuari();

    /**
     * Constructor de la clase SecondMain
     * @param userConnected usuario conectado a la aplicación
     */
    public SecondMain(Usuari userConnected) {
        initComponents();       
        this.userConnected = userConnected;
        lstUsers = new javax.swing.JList<>();
        jScrollPane3.setViewportView(lstUsers);
        pintarUsers();
        lstUsers.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                lstUsersValueChanged(evt);
            }
        });

        cmbWorkout = new JComboBox<>();
        jScrollPane4.setViewportView(cmbWorkout);
        cmbWorkout.addActionListener(new java.awt.event.ActionListener(){
            public void actionPerformed(java.awt.event.ActionEvent evt){
            cmbWorkoutsValueChanged(evt);
            }
        });
           
        lstWorkoutDetail = new javax.swing.JList<>();
        jScrollPane1.setViewportView(lstWorkoutDetail);
}

    /**
     * Método para obtener y mostrar una lista de los usuarios asocioados al instructor conectado.
     */
    public void pintarUsers() {
        ArrayList<Usuari> users = da.getAllUsersByInstructor(userConnected.getId());
        DefaultListModel<Usuari> dfmu = new DefaultListModel<>();
        dfmu.clear();
        for (Usuari u : users) {
            dfmu.addElement(u);
        }
        lstUsers.setModel(dfmu);
        this.revalidate();
        this.repaint();
    }

    /**
     * Método que se ejecuta cuando se selecciona un usuario de la lista.
     * Carga y muestra los entrenamientos de dicho usuario.
     * @param evt 
     */
    private void lstUsersValueChanged(javax.swing.event.ListSelectionEvent evt) {
        Usuari userSelected = lstUsers.getSelectedValue();
        pintarWorkouts(userSelected);
        this.revalidate();
        this.repaint();
    }
    
    /**
     * Método para obtener y mostrar los workouts del usuario seleccionado.
     * @param user usuario seleccionado
     */
    public void pintarWorkouts(Usuari user) {
        ArrayList<Workout> workouts = da.getWorkoutsPerUser(user);
        DefaultComboBoxModel<Workout> dfmw = new DefaultComboBoxModel<>();
        for (Workout w : workouts) {
            dfmw.addElement(w);
        }
        cmbWorkout.setModel(dfmw);
        this.revalidate();
        this.repaint();
    }

    /**
     * Método que se ejecuta cuando se selecciona un workout.
     * Carga y Muestra los ejercicios asociados a dicha workout.
     * @param evt 
     */
    private void cmbWorkoutsValueChanged(java.awt.event.ActionEvent evt) {
        Workout workout = (Workout)cmbWorkout.getSelectedItem();

    ArrayList<Exercici> exercicis = da.getExercicisPerWorkout(workout);
        DefaultListModel<Exercici> dfme = new DefaultListModel<>();
        for (Exercici e : exercicis) {
            dfme.addElement(e);
        }
        lstWorkoutDetail.setModel(dfme);
        this.revalidate();
        this.repaint();
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabelStatusBar = new javax.swing.JLabel();

        setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setText("Users:");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("Workouts:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setText("Workout details:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(132, 132, 132)))
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(357, 357, 357))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGap(311, 311, 311))
                        .addComponent(jScrollPane4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(130, 130, 130)
                        .addComponent(jLabelStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(44, 44, 44))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 45, Short.MAX_VALUE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                        .addGap(14, 14, 14))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 249, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addComponent(jLabelStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(79, 79, 79))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelStatusBar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
