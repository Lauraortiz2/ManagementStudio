package ejercicios.managementstudio;

import ejercicios.DataAcces.DataAccess;
import ejercicios.dto.Usuari;
import javax.swing.UIManager;

/**
 *
 * @author laura
 */
public class MainFrame extends javax.swing.JFrame {

    DataAccess da = new DataAccess();
    Login login;
    SecondMain secondMain;
    ViewExercises viewExer;
    ModExer modExer;
    AddExer addExer;
    DelExer delExer;
    CreateWorkout createWorkout;
    AddUser addUser;
    ModUser modUser;
    DelUser delUser;
    About about;

    public MainFrame() {
        initComponents();
        setSize(600, 500);
        setLocationRelativeTo(null);
        menuBar.setVisible(false);
        setResizable(false);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        lblLogo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuSignOut = new javax.swing.JMenuItem();
        menuExit = new javax.swing.JMenuItem();
        menuUsers = new javax.swing.JMenu();
        menuAddUser = new javax.swing.JMenuItem();
        menuModUser = new javax.swing.JMenuItem();
        menuDelUser = new javax.swing.JMenuItem();
        menuExercises = new javax.swing.JMenu();
        menuViewExer = new javax.swing.JMenuItem();
        menuModExer = new javax.swing.JMenuItem();
        menuAddExer = new javax.swing.JMenuItem();
        menuDelExer = new javax.swing.JMenuItem();
        menuCreateWorkout = new javax.swing.JMenuItem();
        menuHelp = new javax.swing.JMenu();
        menuAbout = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ManagementStudio");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setFont(new java.awt.Font("Times New Roman", 0, 10)); // NOI18N
        getContentPane().setLayout(null);

        jLabel1.setText("Iniciar sesión");

        lblLogo.setIcon(new javax.swing.ImageIcon("D:\\Github\\ManagementStudio1\\ManagementStudio\\src\\main\\java\\ejercicios\\Resources\\Imagenes\\image.png")); // NOI18N
        lblLogo.setText("jLabel2");

        jLabel3.setText("www.ManagementStudio.com");

        btnLogin.setIcon(new javax.swing.ImageIcon("D:\\Github\\ManagementStudio1\\ManagementStudio\\src\\main\\java\\ejercicios\\Resources\\Imagenes\\login.jpeg")); // NOI18N
        btnLogin.setText("jButton1");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(245, 245, 245))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(168, 168, 168)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(171, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(119, 119, 119))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                        .addComponent(lblLogo)
                        .addGap(279, 279, 279)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(79, 79, 79))
        );

        getContentPane().add(mainPanel);
        mainPanel.setBounds(0, 0, 570, 460);

        menuFile.setText("File");

        menuSignOut.setText("Sign out");
        menuSignOut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSignOutActionPerformed(evt);
            }
        });
        menuFile.add(menuSignOut);

        menuExit.setText("Exit");
        menuExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuExitActionPerformed(evt);
            }
        });
        menuFile.add(menuExit);

        menuBar.add(menuFile);

        menuUsers.setText("Users");

        menuAddUser.setText("Add user");
        menuAddUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddUserActionPerformed(evt);
            }
        });
        menuUsers.add(menuAddUser);

        menuModUser.setText("Modify user");
        menuModUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModUserActionPerformed(evt);
            }
        });
        menuUsers.add(menuModUser);

        menuDelUser.setText("Delete user");
        menuDelUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDelUserActionPerformed(evt);
            }
        });
        menuUsers.add(menuDelUser);

        menuBar.add(menuUsers);

        menuExercises.setText("Exercises");

        menuViewExer.setText("View exercises");
        menuViewExer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuViewExerActionPerformed(evt);
            }
        });
        menuExercises.add(menuViewExer);

        menuModExer.setText("Modify exercise");
        menuModExer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuModExerActionPerformed(evt);
            }
        });
        menuExercises.add(menuModExer);

        menuAddExer.setText("Add exercise");
        menuAddExer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAddExerActionPerformed(evt);
            }
        });
        menuExercises.add(menuAddExer);

        menuDelExer.setText("Delete exercise");
        menuDelExer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuDelExerActionPerformed(evt);
            }
        });
        menuExercises.add(menuDelExer);

        menuCreateWorkout.setText("Create workout");
        menuCreateWorkout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuCreateWorkoutActionPerformed(evt);
            }
        });
        menuExercises.add(menuCreateWorkout);

        menuBar.add(menuExercises);

        menuHelp.setText("Help");

        menuAbout.setText("About");
        menuAbout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuAboutActionPerformed(evt);
            }
        });
        menuHelp.add(menuAbout);

        menuBar.add(menuHelp);

        setJMenuBar(menuBar);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        login = new Login(this, true);
        login.setVisible(true);

        if (login.isAuthenticated()) {
            showSecondMain(login.userConnected);
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void menuAddUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddUserActionPerformed
        addUser = new AddUser(this, true);
        addUser.setVisible(true);
    }//GEN-LAST:event_menuAddUserActionPerformed


    private void menuExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuExitActionPerformed
        this.dispose();
    }//GEN-LAST:event_menuExitActionPerformed

    private void menuViewExerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuViewExerActionPerformed
        viewExer = new ViewExercises(this, true);
        viewExer.setVisible(true);
    }//GEN-LAST:event_menuViewExerActionPerformed

    private void menuModExerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModExerActionPerformed
        modExer = new ModExer(this, true);
        modExer.setVisible(true);
    }//GEN-LAST:event_menuModExerActionPerformed

    private void menuAboutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAboutActionPerformed
        about = new About(this, true);
        about.setVisible(true);
    }//GEN-LAST:event_menuAboutActionPerformed

    private void menuSignOutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSignOutActionPerformed
        secondMain.setVisible(false);
        mainPanel.setVisible(true);
        mainPanel.revalidate();
        mainPanel.repaint();
    }//GEN-LAST:event_menuSignOutActionPerformed

    private void menuAddExerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuAddExerActionPerformed
        addExer = new AddExer(this, true);
        addExer.setVisible(true);
    }//GEN-LAST:event_menuAddExerActionPerformed

    private void menuModUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuModUserActionPerformed
        modUser = new ModUser(this, true);
        modUser.setVisible(true);
    }//GEN-LAST:event_menuModUserActionPerformed

    private void menuDelUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDelUserActionPerformed
        delUser = new DelUser(this, true);
        delUser.setVisible(true);
    }//GEN-LAST:event_menuDelUserActionPerformed

    private void menuDelExerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuDelExerActionPerformed
        delExer = new DelExer(this, true);
        delExer.setVisible(true);
    }//GEN-LAST:event_menuDelExerActionPerformed

    private void menuCreateWorkoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuCreateWorkoutActionPerformed
        createWorkout = new CreateWorkout(this, true);
        createWorkout.setVisible(true);
    }//GEN-LAST:event_menuCreateWorkoutActionPerformed

    /*
    Method to change the main view when someone is logged in the app
     */
    private void showSecondMain(Usuari userConnected) {
        secondMain = new SecondMain(userConnected);
        mainPanel.setVisible(false);
        getContentPane().add(secondMain);
        secondMain.setBounds(0, 0, 570, 460);
        secondMain.setVisible(true);
        menuBar.setVisible(true);
        if (!userConnected.isInstructor()) {
            menuUsers.setVisible(false);
            menuAddExer.setVisible(false);
            menuModExer.setVisible(false);
            menuDelExer.setVisible(false);
            menuCreateWorkout.setVisible(false);
        }
        setResizable(false);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {

                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel lblLogo;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JMenuItem menuAbout;
    private javax.swing.JMenuItem menuAddExer;
    private javax.swing.JMenuItem menuAddUser;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuCreateWorkout;
    private javax.swing.JMenuItem menuDelExer;
    private javax.swing.JMenuItem menuDelUser;
    private javax.swing.JMenu menuExercises;
    private javax.swing.JMenuItem menuExit;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuHelp;
    private javax.swing.JMenuItem menuModExer;
    private javax.swing.JMenuItem menuModUser;
    private javax.swing.JMenuItem menuSignOut;
    private javax.swing.JMenu menuUsers;
    private javax.swing.JMenuItem menuViewExer;
    // End of variables declaration//GEN-END:variables
}
