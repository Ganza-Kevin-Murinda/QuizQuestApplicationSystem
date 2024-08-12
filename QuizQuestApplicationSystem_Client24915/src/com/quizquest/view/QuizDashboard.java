/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.view;

import com.quizquest.model.Course;
import com.quizquest.service.CourseService;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JOptionPane;

/**
 *
 * @author Mulinda Kevin
 */
public class QuizDashboard extends javax.swing.JFrame {

    /**
     * Creates new form UserDashboard
     */
    String fname,crsId,email,userId;
    private Map<String, String> courseMap = new HashMap<>();
    
    public QuizDashboard(String Id, String name,String email) {
        initComponents();
        addItemToCombo();
        
        quizBtn.setEnabled(false); 
        this.userId = Id;
        this.fname = name;
        this.email = email;
        userNameTxt.setText(fname);
        userNameTxt.setEditable(false);
        
        setExtendedState(MAXIMIZED_BOTH);
         
    }
    
    private void addItemToCombo(){
        try{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
            CourseService service = (CourseService)registry.lookup("Course");
            List<Course> Courses = service.retrieveAllCourse();
            
            // Clear existing items and map entries to prevent duplicates
            courseCB.removeAllItems();
            courseMap.clear();
            courseCB.addItem("Select Course");
            for(Course theCourse : Courses){
                courseCB.addItem(theCourse.getCourseName());
                courseMap.put(theCourse.getCourseName(), theCourse.getCourseId()); // Store the mapping
                
            }
            
            courseCB.addActionListener(e -> {
            String selectedCourseName = (String) courseCB.getSelectedItem();
            if (courseMap.containsKey(selectedCourseName)) {
                crsId = courseMap.get(selectedCourseName);
                //System.out.println("Selected Course ID: " + crsId);
            }
        });
            
        }catch(NotBoundException | RemoteException ex){
            ex.printStackTrace();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        dashboardLabel = new javax.swing.JLabel();
        quizBtn = new javax.swing.JButton();
        courseBtn = new javax.swing.JButton();
        profilesBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        achievementBtn = new javax.swing.JButton();
        fbBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        courseCB = new javax.swing.JComboBox<>();
        RulestBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        userNameTxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("UserDashboard");
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setLocation(new java.awt.Point(0, 0));
        setPreferredSize(new java.awt.Dimension(1370, 725));

        jPanel2.setBackground(new java.awt.Color(83, 83, 198));

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

        quizBtn.setBackground(new java.awt.Color(255, 255, 255));
        quizBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        quizBtn.setText("Start Quiz");
        quizBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                quizBtnActionPerformed(evt);
            }
        });

        courseBtn.setBackground(new java.awt.Color(255, 255, 255));
        courseBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        courseBtn.setText("Available Course");
        courseBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseBtnActionPerformed(evt);
            }
        });

        profilesBtn.setBackground(new java.awt.Color(255, 255, 255));
        profilesBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        profilesBtn.setText("Profiles");
        profilesBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                profilesBtnActionPerformed(evt);
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

        achievementBtn.setBackground(new java.awt.Color(255, 255, 255));
        achievementBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        achievementBtn.setText("Performance");
        achievementBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        achievementBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                achievementBtnActionPerformed(evt);
            }
        });

        fbBtn.setBackground(new java.awt.Color(255, 255, 255));
        fbBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        fbBtn.setText("Contact Us");
        fbBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fbBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dashboardLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(courseBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(quizBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(profilesBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(achievementBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(fbBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(dashboardLabel)
                .addGap(71, 71, 71)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(profilesBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addComponent(achievementBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(courseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(fbBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(55, 55, 55)
                .addComponent(quizBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(81, 81, 81))
        );

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1370, 725));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(51, 0, 204));
        jLabel2.setText("    Quiz Quest Application System");

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("User Name");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Course");

        courseCB.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        courseCB.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select Course", "Java Programming", "Linux Administration", "Object Oriented Programming" }));

        RulestBtn.setBackground(new java.awt.Color(51, 0, 204));
        RulestBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        RulestBtn.setForeground(new java.awt.Color(255, 255, 255));
        RulestBtn.setText("Rules");
        RulestBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        RulestBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RulestBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(51, 0, 204));
        backBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        userNameTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(102, 102, 102)
                .addComponent(RulestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(287, 287, 287))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseCB, javax.swing.GroupLayout.PREFERRED_SIZE, 264, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(249, 249, 249))
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(151, 151, 151)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 539, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(userNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(63, 63, 63)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(courseCB, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(62, 62, 62)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(RulestBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(111, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(435, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(100, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1400, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void profilesBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_profilesBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new UserProfilesDashboard(userId,fname,email).setVisible(true);
    }//GEN-LAST:event_profilesBtnActionPerformed

    private void courseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new UserCourseDashboard(userId,fname,email).setVisible(true);
    }//GEN-LAST:event_courseBtnActionPerformed

    private void quizBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_quizBtnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_quizBtnActionPerformed

    private void logoutBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new Login().setVisible(true); 
    }//GEN-LAST:event_logoutBtnActionPerformed

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new UserDashboard(userId,fname,email).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void RulestBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RulestBtnActionPerformed
        // TODO add your handling code here:
         if (courseCB.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(this, "Please select a course.", "Validation Error", JOptionPane.ERROR_MESSAGE);
            courseCB.requestFocusInWindow(); // Set focus back to the JComboBox
        }else{
              // Add ActionListener to handle item selection
              
        dispose();
        new RulesDashboard(userId,fname,crsId,email).setVisible(true); 
        }
    }//GEN-LAST:event_RulestBtnActionPerformed

    private void achievementBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_achievementBtnActionPerformed
        // TODO add your handling code here:
         dispose();
        //new ResultDashboard(fname,email).setVisible(true);
    }//GEN-LAST:event_achievementBtnActionPerformed

    private void dashboardLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardLabelMouseClicked
        // TODO add your handling code here:
        dispose();
        new UserDashboard(userId,fname, email).setVisible(true);
    }//GEN-LAST:event_dashboardLabelMouseClicked

    private void fbBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fbBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new ContactUsDashboard(userId, fname, email).setVisible(true);
    }//GEN-LAST:event_fbBtnActionPerformed

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
            java.util.logging.Logger.getLogger(QuizDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuizDashboard("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton RulestBtn;
    private javax.swing.JButton achievementBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JButton courseBtn;
    private javax.swing.JComboBox<String> courseCB;
    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JButton fbBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton profilesBtn;
    private javax.swing.JButton quizBtn;
    private javax.swing.JTextField userNameTxt;
    // End of variables declaration//GEN-END:variables
}
