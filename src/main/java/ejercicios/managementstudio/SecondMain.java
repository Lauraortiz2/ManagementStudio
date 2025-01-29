
package ejercicios.managementstudio;

import ejercicios.DataAcces.DataAccess;
import ejercicios.dto.Exercici;
import ejercicios.dto.Usuari;
import ejercicios.dto.Workout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import net.imagenes.FilesInfo;
import net.imagenes.NewFileListener;

/**
 *
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
        jPanelImagenes1.addNewFileListener(new NewFileListener(){
            @Override
            public void newFile() {
                jLabelStatusBar.setText("Se ha subido un nuevo archivo " + jPanelImagenes1.getFilesInfo().getLast().getName() + 
                        jPanelImagenes1.getFilesInfo().getLast().getSize() + jPanelImagenes1.getFilesInfo().getLast().getDate());
            }
        
        });
}

    public void pintarUsers() {
        ArrayList<Usuari> users = da.getAllUsersByInstructor(userConnected.getId());
        DefaultListModel<Usuari> dfmu = new DefaultListModel<>();
        dfmu.clear();
        for (Usuari u : users) {
            dfmu.addElement(u);
        }
        lstUsers.setModel(dfmu);
    }

    private void lstUsersValueChanged(javax.swing.event.ListSelectionEvent evt) {
        Usuari userSelected = lstUsers.getSelectedValue();
        pintarWorkouts(userSelected);
    }

    public void pintarWorkouts(Usuari user) {
        ArrayList<Workout> workouts = da.getWorkoutsPerUser(user);
        DefaultComboBoxModel<Workout> dfmw = new DefaultComboBoxModel<>();
        for (Workout w : workouts) {
            dfmw.addElement(w);
        }
        cmbWorkout.setModel(dfmw);
    }

    private void cmbWorkoutsValueChanged(java.awt.event.ActionEvent evt) {
        Workout workout = (Workout)cmbWorkout.getSelectedItem();

    ArrayList<Exercici> exercicis = da.getExercicisPerWorkout(workout);
        DefaultListModel<Exercici> dfme = new DefaultListModel<>();
        for (Exercici e : exercicis) {
            dfme.addElement(e);
        }
        lstWorkoutDetail.setModel(dfme);
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
        jPanelImagenes1 = new net.imagenes.JPanelImagenes();
        jLabelStatusBar = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        setPreferredSize(new java.awt.Dimension(700, 500));

        jLabel1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel1.setText("Users:");

        jLabel2.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel2.setText("Workouts:");

        jLabel3.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jLabel3.setText("Workout details:");

        jPanelImagenes1.setConnectionString("DefaultEndpointsProtocol=https;AccountName=spdviblobserver;AccountKey=WxChLmV+vf9lZYL+o/xsqQz6+NBPFuXJRjtMKiwOM7wn0A11Y/kgeu7MiNVrXuRDuzdH89dZRM61+ASt5UrADg==;EndpointSuffix=core.windows.net");
        jPanelImagenes1.setContainerName("spdviimagenes");
        jPanelImagenes1.setPollingInterval(10);
        jPanelImagenes1.setRunning(true);

        jButton1.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        jButton1.setText("Calendario Workout");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 177, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 434, Short.MAX_VALUE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane4))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanelImagenes1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 249, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabelStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanelImagenes1, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(79, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
    
        WorkoutCalendar workoutCalendar = new WorkoutCalendar();
        workoutCalendar.setBounds(0, 0, 570, 500);
        workoutCalendar.setVisible(true);
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabelStatusBar;
    private net.imagenes.JPanelImagenes jPanelImagenes1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
