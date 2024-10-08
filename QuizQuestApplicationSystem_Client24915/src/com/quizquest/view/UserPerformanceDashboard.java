/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.view;

import com.quizquest.model.UserResult;
import com.quizquest.service.UserResultService;
import java.awt.Font;

import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.table.DefaultTableModel;



/**
 *
 * @author Mulinda Kevin
 */
public class UserPerformanceDashboard extends javax.swing.JFrame {

    /**
     * Creates new form UserDashboard
     */

    String fname,email,adminId;
    public UserPerformanceDashboard(String Id, String name,String email) {
        
        initComponents();
        userPerformanceBtn.setEnabled(false); 
        this.adminId = Id;
        this.fname = name;
        this.email = email;
        
        addColumnHeaderName();
        addRowDataToTable();
        setExtendedState(MAXIMIZED_BOTH);
        
        courseRecordTable.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        courseRecordTable.getTableHeader().setOpaque(false);
        courseRecordTable.getTableHeader().setBackground(new Color(51,0,204));;
        courseRecordTable.getTableHeader().setForeground(new Color(255,255,255));
        courseRecordTable.setRowHeight(25); 
    }
    
 DefaultTableModel tableModel = new DefaultTableModel();
    
    public final void addColumnHeaderName(){
        
        tableModel.addColumn("Full Names");
        tableModel.addColumn("Course Name");
        tableModel.addColumn("Score");
        tableModel.addColumn("Date Time");
        courseRecordTable.setModel(tableModel);
    }
    
    public final void addRowDataToTable(){
        
        tableModel.setRowCount(0);
        
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
            UserResultService service = (UserResultService)registry.lookup("Result");
        
            List<UserResult> resultList = service.retrieveAllResult(); 
        
        for(UserResult theResult : resultList){
            tableModel.addRow(new Object[]{
            
                theResult.getTheUser().getFullName(),
                theResult.getTheCourse().getCourseName(),
                theResult.getScore(),
                theResult.getDateTime()
            });
        }
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }
    
        LocalDate currentDate = LocalDate.now();
//        System.out.println("Current Date: " + currentDate);

        // Format the current date
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String formattedDate = currentDate.format(formatter);

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
        userPerformanceBtn = new javax.swing.JButton();
        manageUserBtn = new javax.swing.JButton();
        manageInstructorBtn = new javax.swing.JButton();
        logoutBtn = new javax.swing.JButton();
        manageCourseBtn = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        mainPanel = new javax.swing.JPanel();
        Title = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseRecordTable = new javax.swing.JTable();
        printBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ADMIN DASHBOARD");
        setBackground(new java.awt.Color(204, 204, 204));
        setBounds(new java.awt.Rectangle(0, 0, 0, 0));
        setLocation(new java.awt.Point(0, 0));

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

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(manageInstructorBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE)
                    .addComponent(manageUserBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(userPerformanceBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(logoutBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(dashboardLabel)
                        .addGap(8, 8, 8))
                    .addComponent(manageCourseBtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 179, Short.MAX_VALUE))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(dashboardLabel)
                .addGap(115, 115, 115)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(userPerformanceBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87))
                    .addComponent(manageUserBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(57, 57, 57)
                .addComponent(manageInstructorBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57)
                .addComponent(manageCourseBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(logoutBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(59, 59, 59))
        );

        jPanel1.setPreferredSize(new java.awt.Dimension(1370, 725));

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        Title.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        Title.setForeground(new java.awt.Color(51, 0, 204));
        Title.setText("LIST OF ALL USER RESULT");

        courseRecordTable.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        courseRecordTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        courseRecordTable.setFocusable(false);
        courseRecordTable.setIntercellSpacing(new java.awt.Dimension(0, 0));
        courseRecordTable.setRowHeight(25);
        courseRecordTable.setSelectionBackground(new java.awt.Color(102, 102, 255));
        courseRecordTable.setShowVerticalLines(false);
        courseRecordTable.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(courseRecordTable);

        printBtn.setBackground(new java.awt.Color(51, 0, 204));
        printBtn.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        printBtn.setForeground(new java.awt.Color(255, 255, 255));
        printBtn.setText("Print");
        printBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(273, 273, 273)
                        .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 304, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 800, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, mainPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(printBtn)
                .addGap(51, 51, 51))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(Title, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addComponent(printBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(281, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(106, 106, 106)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(199, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(72, 72, 72)
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(75, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dashboardLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dashboardLabelMouseClicked
        // TODO add your handling code here:
        dispose();
        new AdminDashboard(adminId,fname, email).setVisible(true); 
    }//GEN-LAST:event_dashboardLabelMouseClicked

    private void userPerformanceBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_userPerformanceBtnActionPerformed
        // TODO add your handling code here:
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

    private void manageCourseBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manageCourseBtnActionPerformed
        // TODO add your handling code here:
        dispose();
        new ManageCourseDashboard(adminId,fname, email).setVisible(true);
    }//GEN-LAST:event_manageCourseBtnActionPerformed

    private void printBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printBtnActionPerformed
        // TODO add your handling code here:
            printBtn.setVisible(false); 
        PrinterJob printerJob = PrinterJob.getPrinterJob();
        printerJob.setJobName("Print Report");
        printerJob.setPrintable(new Printable() {
            @Override
            public int print(Graphics grphcs, PageFormat pf, int i) throws PrinterException {
                if (i > 0) {
                    return Printable.NO_SUCH_PAGE;
                }
                Graphics2D graphics2D = (Graphics2D) grphcs;
                    graphics2D.translate(pf.getImageableX()*2, pf.getImageableY()*2);
                    graphics2D.scale(0.5, 0.5);
                    mainPanel.paint(graphics2D);
                   return Printable.PAGE_EXISTS;
                }
        });
        boolean returningResult = printerJob.printDialog();
        
        if (returningResult) {
            try {
                printerJob.print();
            } catch (PrinterException e) {
                JOptionPane.showMessageDialog(this, "Error: " + e.getMessage()); 
            }
        }

    }//GEN-LAST:event_printBtnActionPerformed

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
            java.util.logging.Logger.getLogger(UserPerformanceDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(UserPerformanceDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(UserPerformanceDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(UserPerformanceDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new UserPerformanceDashboard("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Title;
    private javax.swing.JTable courseRecordTable;
    private javax.swing.JLabel dashboardLabel;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton logoutBtn;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JButton manageCourseBtn;
    private javax.swing.JButton manageInstructorBtn;
    private javax.swing.JButton manageUserBtn;
    private javax.swing.JButton printBtn;
    private javax.swing.JButton userPerformanceBtn;
    // End of variables declaration//GEN-END:variables
}
