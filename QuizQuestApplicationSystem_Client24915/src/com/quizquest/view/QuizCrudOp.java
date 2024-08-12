/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.view;

import com.quizquest.model.Course;
import com.quizquest.model.Questions;
import com.quizquest.service.CourseService;
import com.quizquest.service.QuestionsService;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
public class QuizCrudOp extends javax.swing.JFrame {

    String fname,email,instId,course;
    public QuizCrudOp(String Id, String name,String courseId,String email) {
        initComponents();
        this.instId = Id;
        this.fname = name;
        this.course = courseId;
        this.email = email;
        
        courseIdTxt.setEditable(false); 
        questionIdTxt.setEditable(false);
        addColumnHeaderName();
        addRowDataToTable();
        courseRecordTable.getTableHeader().setFont(new Font("Segoe UI",Font.BOLD,12));
        courseRecordTable.getTableHeader().setOpaque(false);
        courseRecordTable.getTableHeader().setBackground(new Color(51,0,204));;
        courseRecordTable.getTableHeader().setForeground(new Color(255,255,255));
        courseRecordTable.setRowHeight(25); 
     
    }
    
    DefaultTableModel tableModel = new DefaultTableModel();
    
    public final void addColumnHeaderName(){
        
        tableModel.addColumn("Course ID");
        tableModel.addColumn("Question ID");
        tableModel.addColumn("Question Text");
        tableModel.addColumn("Correct Answer");
        tableModel.addColumn("Choice 1");
        tableModel.addColumn("Choice 2");
        tableModel.addColumn("Choice 3");
        tableModel.addColumn("Choice 4");
        courseRecordTable.setModel(tableModel);
    }
    
    public final void addRowDataToTable(){
        
        tableModel.setRowCount(0);
        
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
            QuestionsService service = (QuestionsService)registry.lookup("Questions");
        
            List<Questions> questionList = service.fetchQuestion();

            for(Questions theQuestions : questionList){
                tableModel.addRow(new Object[]{

                    theQuestions.getTheCourse().getCourseId(),
                    theQuestions.getqId(),
                    theQuestions.getqText(),
                    theQuestions.getCorrectAnswer(),
                    theQuestions.getChoice1(),
                    theQuestions.getChoice2(),
                    theQuestions.getChoice3(),
                    theQuestions.getChoice4()
                });
            }
        } catch (Exception e) {
        }
        
    }
    
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        courseRecordTable = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        courseIdTxt = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        questionIdTxt = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        updateBtn = new javax.swing.JButton();
        createBtn = new javax.swing.JButton();
        backBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        QuestionTxt = new javax.swing.JTextArea();
        choice1Txt = new javax.swing.JTextField();
        choice2Txt = new javax.swing.JTextField();
        choice3Txt = new javax.swing.JTextField();
        choice4Txt = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        cATxt = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUIZMANAGEMENT");
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

        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Correct Answer");

        courseIdTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        courseIdTxt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                courseIdTxtMouseClicked(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel4.setText("Choice 2");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setText("Choice 1");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setText("Question ID");

        questionIdTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel7.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel7.setText("Choice 3");

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

        jLabel8.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel8.setText("Question Text");

        QuestionTxt.setColumns(20);
        QuestionTxt.setRows(5);
        QuestionTxt.setPreferredSize(new java.awt.Dimension(400, 300));
        jScrollPane2.setViewportView(QuestionTxt);

        choice1Txt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        choice2Txt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        choice3Txt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        choice4Txt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel9.setText("Choice 4");

        cATxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

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
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 741, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(choice4Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(cATxt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(32, 32, 32)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(questionIdTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                                    .addComponent(jScrollPane2)
                                    .addComponent(courseIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(choice1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(choice2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(choice3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(68, 68, 68))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(33, 33, 33)
                        .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(102, 102, 102))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(courseIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(questionIdTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cATxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice3Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(choice4Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(createBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(updateBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(168, 168, 168))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(backBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(refreshBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(70, 70, 70)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

   
    private void updateBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateBtnActionPerformed
        // TODO add your handling code here:
        if(courseIdTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Course ID is required");
        }else if(questionIdTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Question ID is required");
        }else if(QuestionTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Question Text is required");
        }else if(cATxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Correct Answer is required"); //second Validation
        }else if(choice1Txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Choice1 field is required");
        }else if(choice2Txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Choice2 field is required");
        }else if(choice3Txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Choice3 field is required");
        }else if(choice4Txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Choice4 field is required");
        }else{

            try {
               //creating Object of the model class
                Questions theQuestions = new Questions();
                int id = Integer.parseInt(questionIdTxt.getText());
                theQuestions.setTheCourse(new Course(courseIdTxt.getText()));
                theQuestions.setqId(id);
                theQuestions.setqText(QuestionTxt.getText());
                theQuestions.setCorrectAnswer(cATxt.getText());
                theQuestions.setChoice1(choice1Txt.getText());
                theQuestions.setChoice2(choice2Txt.getText());
                theQuestions.setChoice3(choice3Txt.getText());
                theQuestions.setChoice4(choice4Txt.getText());

                Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                QuestionsService service = (QuestionsService)registry.lookup("Questions");
                Questions rowsAffected = service.updateQuestions(theQuestions);

                if(rowsAffected != null){
                    JOptionPane.showMessageDialog(this, "The Question is Updated");
                    addRowDataToTable();
                    courseIdTxt.setText("");
                    questionIdTxt.setText("");
                    questionIdTxt.setEditable(false);
                    QuestionTxt.setText("");
                    cATxt.setText("");
                    choice1Txt.setText("");
                    choice2Txt.setText("");
                    choice3Txt.setText("");
                    choice4Txt.setText("");
                }else{
                    JOptionPane.showMessageDialog(this, "Question is not Updated");
                }

           } catch (HeadlessException | NumberFormatException | NotBoundException | RemoteException e) {
               e.printStackTrace();
           }
        }
    }//GEN-LAST:event_updateBtnActionPerformed

    private void createBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_createBtnActionPerformed
        // TODO add your handling code here:
        
       if(courseIdTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Course ID is required");
        }else if(QuestionTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Question Text is required");
        }else if(cATxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "The Correct Answer is required"); //second Validation
        }else if(choice1Txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Choice1 field is required");
        }else if(choice2Txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Choice2 field is required");
        }else if(choice3Txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Choice3 field is required");
        }else if(choice4Txt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Choice4 field is required");
        }else{

            try {
               //creating Object of the model class
                Questions theQuestions = new Questions();
                //int id = Integer.parseInt(questionIdTxt.getText());
                theQuestions.setTheCourse(new Course(courseIdTxt.getText()));
                //theQuestions.setqId(id);
                theQuestions.setqText(QuestionTxt.getText());
                theQuestions.setCorrectAnswer(cATxt.getText());
                theQuestions.setChoice1(choice1Txt.getText());
                theQuestions.setChoice2(choice2Txt.getText());
                theQuestions.setChoice3(choice3Txt.getText());
                theQuestions.setChoice4(choice4Txt.getText());

                Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                QuestionsService service = (QuestionsService)registry.lookup("Questions");
                Questions rowsAffected = service.registerQuestions(theQuestions);

                if(rowsAffected != null){
                    JOptionPane.showMessageDialog(this, "Question Saved");
                    addRowDataToTable();
                    courseIdTxt.setText("");
                    questionIdTxt.setText("");
                    questionIdTxt.setEditable(false);
                    QuestionTxt.setText("");
                    cATxt.setText("");
                    choice1Txt.setText("");
                    choice2Txt.setText("");
                    choice3Txt.setText("");
                    choice4Txt.setText("");
                }else{
                    JOptionPane.showMessageDialog(this, "Question not Saved");
                }

           } catch (HeadlessException | NumberFormatException | NotBoundException | RemoteException e) {
               e.printStackTrace();
           }
        }
    }//GEN-LAST:event_createBtnActionPerformed

    private void courseRecordTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseRecordTableMouseClicked
        // TODO add your handling code here:
        String tblCourseID = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 0).toString();
        String tblQId = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 1).toString();
        String tblQText = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 2).toString();
        String tblCorrectAnswer = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 3).toString();
        String tblChoice1 = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 4).toString();
        String tblChoice2 = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 5).toString();
        String tblChoice3 = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 6).toString();
        String tblChoice4 = tableModel.getValueAt(courseRecordTable.getSelectedRow(), 7).toString();
        
        courseIdTxt.setText(tblCourseID);
        courseIdTxt.setEditable(false);
        questionIdTxt.setText(tblQId);
        questionIdTxt.setEditable(false);
        QuestionTxt.setText(tblQText);
        cATxt.setText(tblCorrectAnswer);
        choice1Txt.setText(tblChoice1);
        choice2Txt.setText(tblChoice2);
        choice3Txt.setText(tblChoice3);
        choice4Txt.setText(tblChoice4);
    }//GEN-LAST:event_courseRecordTableMouseClicked

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        setVisible(false); 
        new ManageQuizDashboard(instId,fname,course,email).setVisible(true);
    }//GEN-LAST:event_backBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:
                    courseIdTxt.setText("");
                    courseIdTxt.setEditable(false);
                    questionIdTxt.setText("");
                    questionIdTxt.setEditable(false);
                    QuestionTxt.setText("");
                    cATxt.setText("");
                    choice1Txt.setText("");
                    choice2Txt.setText("");
                    choice3Txt.setText("");
                    choice4Txt.setText("");
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void courseIdTxtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_courseIdTxtMouseClicked
        // TODO add your handling code here:
        courseIdTxt.setText(course); 
    }//GEN-LAST:event_courseIdTxtMouseClicked

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
            java.util.logging.Logger.getLogger(QuizCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuizCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuizCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuizCrudOp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new QuizCrudOp("","","","").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea QuestionTxt;
    private javax.swing.JButton backBtn;
    private javax.swing.JTextField cATxt;
    private javax.swing.JTextField choice1Txt;
    private javax.swing.JTextField choice2Txt;
    private javax.swing.JTextField choice3Txt;
    private javax.swing.JTextField choice4Txt;
    private javax.swing.JTextField courseIdTxt;
    private javax.swing.JTable courseRecordTable;
    private javax.swing.JButton createBtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField questionIdTxt;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JButton updateBtn;
    // End of variables declaration//GEN-END:variables
}
