/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.view;

import com.quizquest.model.Instructor;
import com.quizquest.model.Course;
import com.quizquest.service.InstructorService;
import com.quizquest.service.CourseService;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.table.DefaultTableModel;

public class InstrucorCrudOp extends javax.swing.JFrame {

    String fname,email,adminId,passwd;
    long random;
    
    public InstrucorCrudOp(String Id, String name,String email) {
        initComponents();
        this.fname = name;
        this.email = email;
        
        addColumnHeaderName();
        addRowDataToTable();
        
        addItemToCombo();
        
        //idTxt.setEditable(false); 
        
        courseRecordTable.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        courseRecordTable.getTableHeader().setOpaque(false);
        courseRecordTable.getTableHeader().setBackground(new Color(51,0,204));;
        courseRecordTable.getTableHeader().setForeground(new Color(255,255,255));
        courseRecordTable.setRowHeight(25); 
        
        Random ran = new Random();
        random = Math.abs((ran.nextLong() % 900000L) + 100000L);
    }
    
    DefaultTableModel tableModel = new DefaultTableModel();
    
    public final void addColumnHeaderName(){
        
        tableModel.addColumn("Instructor ID");
        tableModel.addColumn("Full Names");
        tableModel.addColumn("Email");
        tableModel.addColumn("User Type");
        tableModel.addColumn("Status");
        tableModel.addColumn("Course Name");
        tableModel.addColumn("Verification Code");
        courseRecordTable.setModel(tableModel);
    }
    
    public final void addRowDataToTable(){
        
        tableModel.setRowCount(0);
        
        try {
            
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
            InstructorService service = (InstructorService)registry.lookup("Instructor");
            
            List<Instructor> InstructorList = service.adminRetrieveAllInstructor();
        
            for(Instructor theInstructor : InstructorList){
                List<Course> courses = theInstructor.getTheCourse();
                for (Course course : courses){
                tableModel.addRow(new Object[]{

                    theInstructor.getInstructorId(),
                    theInstructor.getFullName(),
                    theInstructor.getEmail(),
                    theInstructor.getUserType(),
                    theInstructor.getStatus(),
                    course.getCourseName(),                    
                    theInstructor.getCode()
                });
                }
            }
            
            } catch (NotBoundException | RemoteException e) {
                e.printStackTrace();
            }
        
    }
    
    private void addItemToCombo(){
        try{
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
            CourseService service = (CourseService)registry.lookup("Course");
            List<Course> Courses = service.retrieveAllCourse();
            courseIDCB.addItem("Select Course");
            for(Course theCourse : Courses){
                courseIDCB.addItem(theCourse.getCourseId());
            }
        }catch(NotBoundException | RemoteException ex){
            ex.printStackTrace();
        }
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseRecordTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        idTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        disActivateBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        fNameTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        userTypeTxt = new javax.swing.JTextField();
        statusTxt = new javax.swing.JTextField();
        verificationCodeTxt = new javax.swing.JTextField();
        activateBtn = new javax.swing.JButton();
        searchBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        courseIDCB = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("INSTRUCTORMANAGEMENT");
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
        jLabel2.setText("Instructor ID");

        idTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Email");

        emailTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Verification Code");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("UserType");

        disActivateBtn.setBackground(new java.awt.Color(51, 0, 204));
        disActivateBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        disActivateBtn.setForeground(new java.awt.Color(255, 255, 255));
        disActivateBtn.setText("Disactivate");
        disActivateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                disActivateBtnActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Full Names");

        fNameTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Status");

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

        userTypeTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        userTypeTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                userTypeTxtMouseClicked(evt);
            }
        });

        statusTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        statusTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                statusTxtMouseClicked(evt);
            }
        });

        verificationCodeTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        verificationCodeTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                verificationCodeTxtMouseClicked(evt);
            }
        });

        activateBtn.setBackground(new java.awt.Color(51, 0, 204));
        activateBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        activateBtn.setForeground(new java.awt.Color(255, 255, 255));
        activateBtn.setText("Activate");
        activateBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                activateBtnActionPerformed(evt);
            }
        });

        searchBtn.setBackground(new java.awt.Color(51, 0, 204));
        searchBtn.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        searchBtn.setForeground(new java.awt.Color(255, 255, 255));
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Course ID");

        courseIDCB.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(refreshBtn)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(31, 31, 31)
                                        .addComponent(verificationCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(createBtn)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(disActivateBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(activateBtn)
                                        .addGap(18, 18, 18)
                                        .addComponent(searchBtn))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(49, 49, 49)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(statusTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                            .addComponent(courseIDCB, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(fNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(userTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(65, 65, 65))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fNameTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(33, 33, 33)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(81, 81, 81)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(userTypeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseIDCB, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verificationCodeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(disActivateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(activateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(259, Short.MAX_VALUE))
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

    public static boolean isValidEmail(String email) {
        // Regex pattern for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        
        // Return true if the email matches the regex pattern, otherwise false
        return matcher.matches();
    }
    
    private void disActivateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_disActivateBtnActionPerformed
        // TODO add your handling code here:
        String userEmail = emailTxt.getText();

        if(idTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The ID is required");
        }else if(fNameTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Names are required");
        }else if(emailTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Email is required");
        }else if(!isValidEmail(userEmail)){
            JOptionPane.showMessageDialog(this, "Email is Invalid"); //second Validation
        }else if(userTypeTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, " Instructor Type required");
        }else if(statusTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, " Instructor Status required");
        }else if(courseIDCB.getSelectedItem().equals("Select Course")){
            JOptionPane.showMessageDialog(this, " Choose a course for The Instructor");
        }else if(verificationCodeTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, " Instructor VCode required");
        }else{

                try {
                    
                    //creating Object of the model class
                        Instructor theInstructor = new Instructor();
                        int id = Integer.parseInt(idTxt.getText());
                        theInstructor.setInstructorId(id);
//                        theUser.setFullName(fNameTxt.getText());
//                        theUser.setEmail(emailTxt.getText());
//                        theUser.setPassword(passwd);
//                        theUser.setStatus(statusTxt.getText());
//                        theUser.setUserType(userTypeTxt.getText());
//                        theUser.setCode(verificationCodeTxt.getText());                

                        Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                        InstructorService service = (InstructorService) registry.lookup("Instructor");
                        Integer Id = service.adminInactiveInstructor(theInstructor);

                        if(Id != null){
                            JOptionPane.showMessageDialog(this, "Instructor Status set to Inactive");
                            addRowDataToTable();
                            idTxt.setText("");
                            fNameTxt.setText("");
                            emailTxt.setText("");                    
                            userTypeTxt.setText("");
                            verificationCodeTxt.setText("");
                            statusTxt.setText("");
                            courseIDCB.setSelectedItem("Select Course");
                        }else{
                            JOptionPane.showMessageDialog(this, "Instructor Status Not Changed");
                        }

                } catch (HeadlessException | NumberFormatException | NotBoundException | RemoteException e) {
                    e.printStackTrace();
                }
        }

    }//GEN-LAST:event_disActivateBtnActionPerformed

    private void courseRecordTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseRecordTableMouseClicked
        // TODO add your handling code here:
        String tblID = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 0).toString();
        String tblName = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 1).toString();
        String tblEmail = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 2).toString();
        String tblUserType = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 3).toString();
        String tblStatus = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 4).toString();
        String tblCourse = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 5).toString();
        String tblvCode = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 6).toString();
        
        idTxt.setText(tblID);
        idTxt.setEditable(false);
        fNameTxt.setText(tblName);
        fNameTxt.setEditable(false);
        emailTxt.setText(tblEmail);
        emailTxt.setEditable(false);
        userTypeTxt.setText(tblUserType);
        userTypeTxt.setEditable(false);
        verificationCodeTxt.setText(tblvCode);
        verificationCodeTxt.setEditable(false);
        courseIDCB.setSelectedItem(tblCourse);
        courseIDCB.setEditable(false);
        statusTxt.setText(tblStatus);
        statusTxt.setEditable(false);
    }//GEN-LAST:event_courseRecordTableMouseClicked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        dispose(); 
        new ManageInstructorDashboard(adminId,fname, email).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
                    idTxt.setText("");
                    //idTxt.setEditable(false);
                    fNameTxt.setText("");
                    fNameTxt.setEditable(true);
                    emailTxt.setText(""); 
                    emailTxt.setEditable(true); 
                    userTypeTxt.setText("");
                    userTypeTxt.setEditable(true);
                    verificationCodeTxt.setText("");
                    verificationCodeTxt.setEditable(true);
                    statusTxt.setText("");  
                    statusTxt.setEditable(true);
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void activateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_activateBtnActionPerformed
        // TODO add your handling code here:
        String userEmail = emailTxt.getText();

        if(idTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The ID is required");
        }else if(fNameTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Names are required");
        }else if(emailTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Email is required");
        }else if(!isValidEmail(userEmail)){
            JOptionPane.showMessageDialog(this, "Email is Invalid"); //second Validation
        }else if(userTypeTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, " Instructor Type required");
        }else if(statusTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, " Instructor Status required");
        }else if(courseIDCB.getSelectedItem().equals("Select Course")){
            JOptionPane.showMessageDialog(this, " Choose a course for The Instructor");
        }else if(verificationCodeTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, " Instructor VCode required");
        }else{

                try {
                    
                    //creating Object of the model class
                        Instructor theInstructor = new Instructor();
                        int id = Integer.parseInt(idTxt.getText());
                        theInstructor.setInstructorId(id);
//                        theUser.setFullName(fNameTxt.getText());
//                        theUser.setEmail(emailTxt.getText());
//                        theUser.setPassword(passwd);
//                        theUser.setStatus(statusTxt.getText());
//                        theUser.setUserType(userTypeTxt.getText());
//                        theUser.setCode(verificationCodeTxt.getText());                

                        Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                        InstructorService service = (InstructorService) registry.lookup("Instructor");
                        Integer Id = service.ActivateInstructor(theInstructor); 

                        if(Id != null){
                            JOptionPane.showMessageDialog(this, "Instructor Status set to Active");
                            addRowDataToTable();
                            idTxt.setText("");
                            fNameTxt.setText("");
                            emailTxt.setText("");                    
                            userTypeTxt.setText("");
                            verificationCodeTxt.setText("");
                            statusTxt.setText("");
                            courseIDCB.setSelectedItem("Select Course");
                        }else{
                            JOptionPane.showMessageDialog(this, "Instructor Status Not Changed");
                        }

                } catch (HeadlessException | NumberFormatException | NotBoundException | RemoteException e) {
                    e.printStackTrace();
                }
        }
    }//GEN-LAST:event_activateBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        if(idTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Use Only the Instructor Id to search the User you need!");
        }else{
            try {
                
                Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                InstructorService service = (InstructorService)registry.lookup("Instructor");
                
                Instructor theInstructor = new Instructor();
                int id = Integer.parseInt(idTxt.getText());
                theInstructor.setInstructorId(id); 
                
                Instructor instObj = service.findInstructorById(theInstructor); 

                if(instObj != null){
                    JOptionPane.showMessageDialog(this, "Instructor Found");
                    idTxt.setText(String.valueOf(instObj.getInstructorId())); 
                    fNameTxt.setText(instObj.getFullName());
                    emailTxt.setText(instObj.getEmail());                    
                    userTypeTxt.setText(instObj.getUserType());
                    verificationCodeTxt.setText(instObj.getCode());
                    statusTxt.setText(instObj.getStatus()); 
                    
                }else{
                    JOptionPane.showMessageDialog(this, "Instructor with that ID doesn't exist!");
                }
            } catch (Exception e) {
            }
        }
    }//GEN-LAST:event_searchBtnActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        // TODO add your handling code here:
        String userEmail = emailTxt.getText();
        

        if(!idTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Field Id should be empty to create an instructor ");
            idTxt.setText("");
            idTxt.setEditable(false); 
        }else if(fNameTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Names are required");
        }else if(emailTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Email is required");
        }else if(!isValidEmail(userEmail)){
            JOptionPane.showMessageDialog(this, "Email is Invalid"); //second Validation
        }else if(userTypeTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, " Instructor Type required");
        }else if(statusTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, " Instructor Status required");
        }else if(courseIDCB.getSelectedItem().equals("Select Course")){
            JOptionPane.showMessageDialog(this, " Choose a course for The Instructor");
        }else if(verificationCodeTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, " Instructor VCode required");
        }else{

                try {
                    
                    //creating Object of the model class
                        Instructor theInstructor = new Instructor();
                        Course seletctedCourse = new Course();
                        seletctedCourse.setCourseId(courseIDCB.getSelectedItem().toString()); 
                        List<Course> courseId = new ArrayList<>();
                        courseId.add(seletctedCourse);
                        //int id = Integer.parseInt(idTxt.getText());
                        //theInstructor.setInstructorId(id); 
                        theInstructor.setFullName(fNameTxt.getText());
                        theInstructor.setEmail(emailTxt.getText());
                        theInstructor.setStatus(statusTxt.getText());
                        theInstructor.setUserType(userTypeTxt.getText());
                        theInstructor.setTheCourse(courseId);
                        theInstructor.setCode(verificationCodeTxt.getText());                

                        Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                        InstructorService service = (InstructorService) registry.lookup("Instructor");
                        Integer Id = service.instructorSignUp(theInstructor); 
                        
                        if(Id != null){
                            //Emailing the Instructor 
                            
                            Properties props = new Properties();
                            props.put("mail.smtp.host","smtp.gmail.com");
                            props.put("mail.smtp.socketFactory.port","465");
                            props.put("mail.smtp.socketFactory.class","javax.net.ssl.SSLSocketFactory");
                            props.put("mail.smtp.auth", "true");
                            props.put("mail.smtp.port", "465");

                            Session ss = Session.getDefaultInstance(props,
                                    new javax.mail.Authenticator() {
                                        @Override
                                        protected PasswordAuthentication getPasswordAuthentication(){
                                        return new PasswordAuthentication("linuxkevin2024@gmail.com", "coirxjvsqdepzqcx");
                                        }
                                        }

                                    );
                            try {
                                Message message = new MimeMessage(ss);
                                message.setFrom(new InternetAddress("linuxkevin2024@gmail.com"));
                                message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(emailTxt.getText()));
                                message.setSubject("QuizQuest Account confirmation");
                                message.setText("Dear Instructor "+fNameTxt.getText()+", This is Email is sent to confirm to you that your Account was created successfuly\nRegards,QuizQuest app Team!"); 
                                Transport.send(message); 
                                JOptionPane.showMessageDialog(this, "Confirmation Email sent.\nInstructor Account Created successfuly");
                                 
                            } catch (Exception e) {
                                JOptionPane.showMessageDialog(this, e);
                            }
                            
                            addRowDataToTable();
                            
                            idTxt.setText("");
                            fNameTxt.setText("");
                            emailTxt.setText("");                    
                            userTypeTxt.setText("");
                            verificationCodeTxt.setText("");
                            statusTxt.setText("");
                            courseIDCB.setSelectedItem("Select Course");
                        }else{
                            JOptionPane.showMessageDialog(this, "Instructor Account Not Created");
                        }

                } catch (HeadlessException | NumberFormatException | NotBoundException | RemoteException e) {
                    e.printStackTrace();
                }
        }

    }//GEN-LAST:event_createBtnActionPerformed

    private void userTypeTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_userTypeTxtMouseClicked
        // TODO add your handling code here:
        userTypeTxt.setText("Instructor");
        userTypeTxt.setEditable(false);
    }//GEN-LAST:event_userTypeTxtMouseClicked

    private void statusTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_statusTxtMouseClicked
        // TODO add your handling code here:
        statusTxt.setText("Active");
        statusTxt.setEditable(false);
    }//GEN-LAST:event_statusTxtMouseClicked

    private void verificationCodeTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_verificationCodeTxtMouseClicked
        // TODO add your handling code here:
        verificationCodeTxt.setText(String.valueOf(random));
        verificationCodeTxt.setEditable(false);
    }//GEN-LAST:event_verificationCodeTxtMouseClicked

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
            java.util.logging.Logger.getLogger(InstrucorCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(InstrucorCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(InstrucorCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(InstrucorCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new InstrucorCrudOp("","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton activateBtn;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> courseIDCB;
    private javax.swing.JTable courseRecordTable;
    private javax.swing.JButton createBtn;
    private javax.swing.JButton disActivateBtn;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JTextField fNameTxt;
    private javax.swing.JTextField idTxt;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField statusTxt;
    private javax.swing.JTextField userTypeTxt;
    private javax.swing.JTextField verificationCodeTxt;
    // End of variables declaration//GEN-END:variables
}
