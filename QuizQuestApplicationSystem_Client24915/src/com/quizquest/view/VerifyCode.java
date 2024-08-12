/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.quizquest.view;

import com.quizquest.service.UserIdentityService;
import com.quizquest.model.UserIdentity;
import java.awt.HeadlessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;

public class VerifyCode extends javax.swing.JFrame {

    String email,names,password,randomN; 
    

    public VerifyCode(String emails,String fnames, long random, String passwd) {
        initComponents();
        this.email = emails;
        this.names = fnames;
        this.password = passwd;
        this.randomN = String.valueOf(random);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        verifyBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        codeTxt = new javax.swing.JTextField();
        resendBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUIZQUEST APPLICATION SYSTEM");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setIcon(new javax.swing.ImageIcon("D:\\STUDIES\\Semester 6\\Java Programming\\Exercise\\LoginAnd Signup\\src\\icon\\login2.jpeg")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addGap(0, 20, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel2);
        jPanel2.setBounds(0, 0, 400, 480);

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setMinimumSize(new java.awt.Dimension(400, 500));

        verifyBtn.setBackground(new java.awt.Color(51, 0, 204));
        verifyBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        verifyBtn.setForeground(new java.awt.Color(255, 255, 255));
        verifyBtn.setText("Verify");
        verifyBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        verifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verifyBtnActionPerformed(evt);
            }
        });

        jLabel6.setBackground(new java.awt.Color(102, 102, 102));
        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel6.setText("Verification Code");

        codeTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        codeTxt.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        resendBtn.setBackground(new java.awt.Color(51, 0, 204));
        resendBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        resendBtn.setForeground(new java.awt.Color(255, 255, 255));
        resendBtn.setText("Resend");
        resendBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        resendBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                resendBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(verifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(41, 41, 41)
                                .addComponent(resendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(codeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 236, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(105, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(139, 139, 139)
                .addComponent(jLabel6)
                .addGap(34, 34, 34)
                .addComponent(codeTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(verifyBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(resendBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(185, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3);
        jPanel3.setBounds(400, 0, 400, 480);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
    private void verifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verifyBtnActionPerformed
        // TODO add your handling code here:        
        
        String code = codeTxt.getText();
        if(codeTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Input the verification code");
        }
        else if(codeTxt.getText().length() < 5){
             JOptionPane.showMessageDialog(this, "The verification code must atleast be 5 characters long");
        }else{
            if (codeTxt.getText().equals(randomN)){
                
                try {
                    //creating Object of the model class
                    UserIdentity theUser = new UserIdentity();
                    theUser.setFullName(names);
                    theUser.setEmail(email);
                    theUser.setPassword(password);
                    theUser.setCode(randomN);

                    Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                    UserIdentityService service = (UserIdentityService) registry.lookup("User");
                    Integer resp = service.userSignup(theUser);  

                    if(resp != null){
                         JOptionPane.showMessageDialog(this, "User Created successfuly");
                         dispose();
                         new Login().setVisible(true); 
                    }else{
                         JOptionPane.showMessageDialog(this, "User not Created");
                    }
                } catch (HeadlessException | NotBoundException | RemoteException e) {
                    e.printStackTrace();
                }
                
            }  else{
                JOptionPane.showMessageDialog(this, "Invalid Code, try again or click on Resend button to send another code");
            }    
        }
        
    }//GEN-LAST:event_verifyBtnActionPerformed

    private void resendBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_resendBtnActionPerformed
        // TODO add your handling code here:
        long randomCode;
        Random ran = new Random();
                randomCode = Math.abs((ran.nextLong() % 900000L) + 100000L);
                this.randomN = String.valueOf(randomCode);
                System.out.println("code: " + randomN);
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
                    message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(email));
                    message.setSubject("QuizQuest Verification Code");
                    message.setText("Email Verification Code: "+randomCode); 
                    Transport.send(message); 
                    JOptionPane.showMessageDialog(this, "Verification code resent check your Email"); 
                } catch (HeadlessException | MessagingException e) {
                    JOptionPane.showMessageDialog(this, e);
                }
    }//GEN-LAST:event_resendBtnActionPerformed



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField codeTxt;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JButton resendBtn;
    private javax.swing.JButton verifyBtn;
    // End of variables declaration//GEN-END:variables

}
