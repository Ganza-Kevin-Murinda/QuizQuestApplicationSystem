/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.view;

import com.quizquest.model.Course;
import com.quizquest.service.CourseService;
import java.awt.Color;
import java.awt.Font;
import static java.awt.Frame.MAXIMIZED_BOTH;
import java.awt.HeadlessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class CourseCrudOp extends javax.swing.JFrame {

    String fname,email,adminId;
    public CourseCrudOp(String Id,String name,String email) {
        initComponents();
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
        
        tableModel.addColumn("Course ID");
        tableModel.addColumn("Course Name");
        courseRecordTable.setModel(tableModel);
    }
    
    public final void addRowDataToTable(){
        
        tableModel.setRowCount(0);
        
        try {
            
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
            CourseService service = (CourseService)registry.lookup("Course");
            
            List<Course> courseList = service.retrieveAllCourse();
        
            for(Course theCourse : courseList){
                tableModel.addRow(new Object[]{

                    theCourse.getCourseId(),
                    theCourse.getCourseName()
                });
            }
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
        
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseRecordTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        courseIdTxt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        courseNameTxt = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("COURSEMANAGEMENT");
        setExtendedState(MAXIMIZED_BOTH);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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
        courseRecordTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseRecordTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(courseRecordTable);

        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Course ID");

        courseIdTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Course Name");

        updateBtn.setBackground(new java.awt.Color(51, 0, 204));
        updateBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        updateBtn.setForeground(new java.awt.Color(255, 255, 255));
        updateBtn.setText("Update");
        updateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateBtnActionPerformed(evt);
            }
        });

        createBtn.setBackground(new java.awt.Color(51, 0, 204));
        createBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        createBtn.setForeground(new java.awt.Color(255, 255, 255));
        createBtn.setText("Create");
        createBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createBtnActionPerformed(evt);
            }
        });

        backBtn.setBackground(new java.awt.Color(51, 0, 204));
        backBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        backBtn.setForeground(new java.awt.Color(255, 255, 255));
        backBtn.setText("Back");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        refreshBtn.setBackground(new java.awt.Color(51, 0, 204));
        refreshBtn.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        refreshBtn.setForeground(new java.awt.Color(255, 255, 255));
        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        courseNameTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        searchBtn.setBackground(new java.awt.Color(51, 0, 204));
        searchBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 723, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 75, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(68, 68, 68))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(courseIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(courseNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(80, 80, 80))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(refreshBtn)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(183, 183, 183)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(courseNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(334, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        if(courseIdTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The ID is required");
        }else if(courseNameTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select a Course");
        }else{

               try {
                    //creating Object of the model class
                    Course theCourse = new Course();
                    theCourse.setCourseId(courseIdTxt.getText());
                    theCourse.setCourseName(courseNameTxt.getText());                

                    Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                    CourseService service = (CourseService) registry.lookup("Course");
                    Course crsObj = service.updateCourse(theCourse); 

                            if(crsObj != null){
                                JOptionPane.showMessageDialog(this, "Course Update Successful");
                                addRowDataToTable();
                                courseIdTxt.setText("");
                                courseNameTxt.setText("");
                            }else{
                                JOptionPane.showMessageDialog(this, "Course Update Unsuccessful");
                            }
               } catch (Exception e) {
                
               }

        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        // TODO add your handling code here:
        
        if(courseIdTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The ID is required");
        }else if(courseNameTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Please Select a Course");
        }else{

                try {
                    
                    //creating Object of the model class
                        Course theCourse = new Course();
                        theCourse.setCourseId(courseIdTxt.getText());
                        theCourse.setCourseName(courseNameTxt.getText());                

                        Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                        CourseService service = (CourseService) registry.lookup("Course");
                        Course crsObj = service.registerCourse(theCourse);

                        if(crsObj != null){
                            JOptionPane.showMessageDialog(this, "Course Creation Successful");
                            addRowDataToTable();
                            courseIdTxt.setText("");
                            courseNameTxt.setText("");
                        }else{
                            JOptionPane.showMessageDialog(this, "Course Creation Unsuccessful");
                        }
                
                } catch (HeadlessException | NotBoundException | RemoteException e) {
                    e.printStackTrace();
                }

        }
    }//GEN-LAST:event_createBtnActionPerformed

    private void courseRecordTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseRecordTableMouseClicked
        // TODO add your handling code here:
        String tblCourseID = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 0).toString();
        String tblCourseName = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 1).toString();
        
        
        courseIdTxt.setText(tblCourseID);
        courseIdTxt.setEditable(false);
        courseNameTxt.setText(tblCourseName);
    }//GEN-LAST:event_courseRecordTableMouseClicked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false); 
        new ManageCourseDashboard(adminId,fname, email).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
                    courseIdTxt.setText("");
                    courseIdTxt.setEditable(true);
                    courseNameTxt.setText(""); 
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        if(courseIdTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Use Only the course Id to search the course you want!");
        }else{
            try {
                
                Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                CourseService service = (CourseService)registry.lookup("Course");
                
                Course theCourse = new Course();
                theCourse.setCourseId(courseIdTxt.getText());
                
                Course crsObj = service.findCourseById(theCourse);

                if(crsObj != null){
                    JOptionPane.showMessageDialog(this, "Course Found");
                    courseIdTxt.setText(crsObj.getCourseId());
                    courseIdTxt.setEditable(false);
                    courseNameTxt.setText(crsObj.getCourseName()); 
                    
                }else{
                    JOptionPane.showMessageDialog(this, "Course with that ID doesn't exist!");
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_searchBtnActionPerformed

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
            java.util.logging.Logger.getLogger(CourseCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CourseCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CourseCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CourseCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CourseCrudOp("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField courseIdTxt;
    private javax.swing.JTextField courseNameTxt;
    private javax.swing.JTable courseRecordTable;
    private javax.swing.JButton createBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
