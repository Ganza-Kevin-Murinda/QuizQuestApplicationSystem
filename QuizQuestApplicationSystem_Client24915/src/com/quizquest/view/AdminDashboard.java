/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.view;

//import com.quizquest.Dao.MessageDao;
import com.quizquest.model.Feedback;
import com.quizquest.service.FeedBackService;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.*;


/**
 *
 * @author Mulinda Kevin
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form UserDashboard
     */
    String fname,email,adminId;
    JLabel messageCountLabel;
    long unreadCount;

    public AdminDashboard(String Id, String name,String email) {
//        unreadCount = dao.countUnReadMessages();
        initComponents();
        this.adminId = Id;
        this.fname = name;
        this.email = email;
       
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
            FeedBackService service = (FeedBackService)registry.lookup("Feedback");
            
            unreadCount =  service.countUnReadMessages();
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
        
        // Initialize and add the landing text message
       
               landingTxt.setText(
                "<html>"+ 
                    "Welcome, " + fname + "!" + "<br><br>" +    
                    "Greetings, Admin! We're thrilled to have you on board." + "<br><br>" +
                    "Here are some important notifications:" + "<br><br>" +        
                    "- You have <b>" + unreadCount + "</b> pending feedbacks from users." + "<br><br>" +
//                    "- You have pending feedbacks from users." + "<br><br>" +
                    "Feel free to explore the admin dashboard and manage the application with ease." + "<br><br>" + 
                "<html>" 
            );
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        dashboardPanel = new javax.swing.JPanel();
        dashboardLabel = new javax.swing.JLabel();
        userPerformanceBtn = new javax.swing.JButton();
        manageUserBtn = new javax.swing.JButton();
        manageInstructorBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        manageCourseBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        landingTxt = new javax.swing.JLabel();
        viewFeedbackBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN DASHBOARD");
        setExtendedState(MAXIMIZED_BOTH);

        dashboardPanel.setBackground(new java.awt.Color(83, 83, 198));
        dashboardPanel.setForeground(new java.awt.Color(255, 255, 255));

        dashboardLabel.setBackground(new java.awt.Color(255, 255, 255));
        dashboardLabel.setFont(new java.awt.Font("Microsoft Sans Serif", 1, 28)); // NOI18N
        dashboardLabel.setForeground(new java.awt.Color(255, 255, 255));
        dashboardLabel.setText("Dashboard");
        dashboardLabel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dashboardLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dashboardLabelMouseClicked(evt);
            }
        });

        userPerformanceBtn.setBackground(new java.awt.Color(255, 255, 255));
        userPerformanceBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        userPerformanceBtn.setText("User Performance");
        userPerformanceBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                userPerformanceBtnActionPerformed(evt);
            }
        });

        manageUserBtn.setBackground(new java.awt.Color(255, 255, 255));
        manageUserBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        manageUserBtn.setText("Manage User");
        manageUserBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        manageUserBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageUserBtnActionPerformed(evt);
            }
        });

        manageInstructorBtn.setBackground(new java.awt.Color(255, 255, 255));
        manageInstructorBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        manageInstructorBtn.setText("Manage Instructor");
        manageInstructorBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageInstructorBtnActionPerformed(evt);
            }
        });

        logoutBtn.setBackground(new java.awt.Color(255, 255, 255));
        logoutBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        logoutBtn.setText("Logout");
        logoutBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutBtnActionPerformed(evt);
            }
        });

        manageCourseBtn.setBackground(new java.awt.Color(255, 255, 255));
        manageCourseBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        manageCourseBtn.setText("Manage Course");
        manageCourseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manageCourseBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout dashboardPanelLayout = new javax.swing.GroupLayout(dashboardPanel);
        dashboardPanel.setLayout(dashboardPanelLayout);
        dashboardPanelLayout.setHorizontalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(dashboardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(58, 58, 58))
                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                        .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(manageInstructorBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(manageUserBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userPerformanceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 179, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(manageCourseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        dashboardPanelLayout.setVerticalGroup(
            dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dashboardPanelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(dashboardLabel)
                .addGap(111, 111, 111)
                .addGroup(dashboardPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(dashboardPanelLayout.createSequentialGroup()
                        .addComponent(userPerformanceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addComponent(manageUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(manageInstructorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(manageCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(600, 600));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 26)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("      QUIZQUEST APPLICATION SYSTEM");

        landingTxt.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        landingTxt.setText("text Area");

        viewFeedbackBtn.setBackground(new java.awt.Color(51, 0, 204));
        viewFeedbackBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        viewFeedbackBtn.setForeground(new java.awt.Color(255, 255, 255));
        viewFeedbackBtn.setText("View Feedbacks");
        viewFeedbackBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewFeedbackBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(viewFeedbackBtn)
                .addGap(296, 296, 296))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 506, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addComponent(landingTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39)
                .addComponent(landingTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 260, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(viewFeedbackBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(37, 37, 37))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(dashboardPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(135, 135, 135)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 750, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(141, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(dashboardPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardLabelMouseClicked
        // TODO add your handling code here:
        dispose();
        new AdminDashboard(adminId, fname, email).setVisible(true);
    }//GEN-LAST:event_dashboardLabelMouseClicked

    private void userPerformanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPerformanceBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new UserPerformanceDashboard(adminId,fname,email).setVisible(true);
    }//GEN-LAST:event_userPerformanceBtnActionPerformed

    private void manageUserBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageUserBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new ManageUserDashboard(adminId,fname,email).setVisible(true);
    }//GEN-LAST:event_manageUserBtnActionPerformed

    private void manageInstructorBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageInstructorBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new ManageInstructorDashboard(adminId,fname,email).setVisible(true);
    }//GEN-LAST:event_manageInstructorBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new Login().setVisible(true);
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void viewFeedbackBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewFeedbackBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new MessageDashboard(adminId,fname, email).setVisible(true); 
    }//GEN-LAST:event_viewFeedbackBtnActionPerformed

    private void manageCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCourseBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new ManageCourseDashboard(adminId,fname, email).setVisible(true);
    }//GEN-LAST:event_manageCourseBtnActionPerformed

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
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard("adminId","User","user@gmail").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JPanel dashboardPanel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel landingTxt;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JButton manageCourseBtn;
    private javax.swing.JButton manageInstructorBtn;
    private javax.swing.JButton manageUserBtn;
    private javax.swing.JButton userPerformanceBtn;
    private javax.swing.JButton viewFeedbackBtn;
    // End of variables declaration//GEN-END:variables
}
