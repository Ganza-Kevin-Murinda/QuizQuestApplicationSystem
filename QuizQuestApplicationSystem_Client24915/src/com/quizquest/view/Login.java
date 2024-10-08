/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.view;


import com.quizquest.model.UserIdentity;
import com.quizquest.service.UserIdentityService;
import com.quizquest.model.Instructor;
import com.quizquest.service.InstructorService;
import java.awt.Color;
import java.awt.HeadlessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.*;

/**
 *
 * @author Mulinda Kevin
 */
public class Login extends javax.swing.JFrame {

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        //loginBtn.setBackground(new Color(51,0,153)); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        Right = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        Left = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        emailTxt = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        passwordTxt = new javax.swing.JPasswordField();
        loginBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        signupBtn = new javax.swing.JButton();
        instructorCBX = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("QUIZQUEST APPLICATION SYSTEM");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 500));
        jPanel1.setLayout(null);

        Right.setBackground(new java.awt.Color(255, 255, 255));
        Right.setPreferredSize(new java.awt.Dimension(400, 500));

        jLabel6.setIcon(new javax.swing.ImageIcon("D:\\STUDIES\\Semester 6\\Java Programming\\Exercise\\LoginAnd Signup\\src\\icon\\login2.jpeg")); // NOI18N

        javax.swing.GroupLayout RightLayout = new javax.swing.GroupLayout(Right);
        Right.setLayout(RightLayout);
        RightLayout.setHorizontalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 16, Short.MAX_VALUE))
        );
        RightLayout.setVerticalGroup(
            RightLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(RightLayout.createSequentialGroup()
                .addComponent(jLabel6)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(Right);
        Right.setBounds(0, 0, 400, 480);

        Left.setBackground(new java.awt.Color(255, 255, 255));
        Left.setMinimumSize(new java.awt.Dimension(400, 500));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 0, 204));
        jLabel1.setText("LOGIN");

        jLabel2.setBackground(new java.awt.Color(102, 102, 102));
        jLabel2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel2.setText("Email");

        emailTxt.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N

        jLabel3.setBackground(new java.awt.Color(102, 102, 102));
        jLabel3.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel3.setText("Password");

        passwordTxt.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        loginBtn.setBackground(new java.awt.Color(51, 0, 204));
        loginBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        loginBtn.setForeground(new java.awt.Color(255, 255, 255));
        loginBtn.setText("Login");
        loginBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        loginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginBtnActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("I don't have an account");

        signupBtn.setBackground(new java.awt.Color(51, 0, 204));
        signupBtn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        signupBtn.setForeground(new java.awt.Color(255, 255, 255));
        signupBtn.setText("Signup");
        signupBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        signupBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signupBtnActionPerformed(evt);
            }
        });

        instructorCBX.setBackground(new java.awt.Color(255, 255, 255));
        instructorCBX.setFont(new java.awt.Font("Segoe UI", 0, 16)); // NOI18N
        instructorCBX.setText("I am an Instructor");

        javax.swing.GroupLayout LeftLayout = new javax.swing.GroupLayout(Left);
        Left.setLayout(LeftLayout);
        LeftLayout.setHorizontalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(153, 153, 153)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(LeftLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(LeftLayout.createSequentialGroup()
                                .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(instructorCBX)
                                .addGap(13, 13, 13))
                            .addGroup(LeftLayout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(37, 37, 37)
                                .addComponent(signupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(emailTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE)
                            .addComponent(passwordTxt))))
                .addContainerGap(35, Short.MAX_VALUE))
        );
        LeftLayout.setVerticalGroup(
            LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LeftLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel1)
                .addGap(54, 54, 54)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(emailTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(passwordTxt, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(loginBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(instructorCBX))
                .addGap(37, 37, 37)
                .addGroup(LeftLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(signupBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(88, Short.MAX_VALUE))
        );

        jPanel1.add(Left);
        Left.setBounds(400, 0, 400, 480);

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

        jPanel1.getAccessibleContext().setAccessibleName("");

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void signupBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signupBtnActionPerformed
        // TODO add your handling code here:
        
        SignUp SignupFrame = new SignUp();
        SignupFrame.setVisible(true);
        SignupFrame.pack();
        //LoginFrame.setLocationRelativeTo(null);// code for centralizing the frame
        this.dispose();
    }//GEN-LAST:event_signupBtnActionPerformed
    
    public static boolean isValidEmail(String email) {
        // Regex pattern for email validation
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);
        
        // Return true if the email matches the regex pattern, otherwise false
        return matcher.matches();
    }
    
    
    private void loginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginBtnActionPerformed
        // TODO add your handling code here:
        
        String email = emailTxt.getText();
        
        if(emailTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Email is required");
        }else if(!isValidEmail(email)){
            JOptionPane.showMessageDialog(this, "Email is Invalid"); //second Validation
        }else if(passwordTxt.getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(this, "Password is required");
        }else{ 
                if(instructorCBX.isSelected()){
//                    JOptionPane.showMessageDialog(this, "Instructor's page underconstruction!!");
//                    emailTxt.setText("");
//                    passwordTxt.setText("");
//                    instructorCBX.setSelected(false);
                    try {
                    
                     //creating Object of the model class
                     Instructor theInstructor = new Instructor();
                     theInstructor.setEmail(emailTxt.getText());
                     theInstructor.setPassword(passwordTxt.getText());

                     Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                     InstructorService service = (InstructorService) registry.lookup("Instructor");
                     String[] ifFound = new String[6];
                     ifFound= service.instructorLogin(theInstructor); 

                      if(ifFound[0].equals("1") && ifFound[1].equals("1")){
                          //Condition for login as different user
                          if(ifFound[4].equals("Instructor")){
                             JOptionPane.showMessageDialog(this, "Welcome Instructor!!\nIf this is your first login please proceed with changing your password"); 
                             dispose();
                           new InstructorDashboard(ifFound[2], ifFound[3], email).setVisible(true);
                          }

                      }else if(ifFound[0].equals("1") && ifFound[1].equals("0")){
                           JOptionPane.showMessageDialog(this, "This Account was DisActivated");
                      }else if(ifFound[0].equals("0")){
                          JOptionPane.showMessageDialog(this, "Incorrect Email or Password for the Intsructor Account Try again");
                      }
                
                    } catch (HeadlessException | NotBoundException | RemoteException e) {
                        e.printStackTrace();
                    }

                }else{
                
                    try {
                    
                     //creating Object of the model class
                     UserIdentity theUser = new UserIdentity();
                     theUser.setEmail(emailTxt.getText());
                     theUser.setPassword(passwordTxt.getText());

                     Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
                     UserIdentityService service = (UserIdentityService) registry.lookup("User");
                     String[] ifFound = new String[5];
                     ifFound= service.userLogin(theUser); 

                      if(ifFound[0].equals("1") && ifFound[1].equals("1")){
                          //Condition for login as different user
                          if(ifFound[4].equals("SystemUser")){
                           dispose();
                           new UserDashboard(ifFound[2], ifFound[3],email).setVisible(true);
                          }else{
                           dispose();
                           new AdminDashboard(ifFound[2], ifFound[3],email).setVisible(true);
                          }

                      }else if(ifFound[0].equals("1") && ifFound[1].equals("0")){
                           JOptionPane.showMessageDialog(this, "This Account was DisActivated");
                      }else if(ifFound[0].equals("0")){
                          JOptionPane.showMessageDialog(this, "Please if your an Instructor first check the I am an instructor button then proceed with the Login\nIncorrect Email or Password Try again");
                      }
                
                } catch (HeadlessException | NotBoundException | RemoteException e) {
                    e.printStackTrace();
                }
                    
                }
            
              
        }    
        
    }//GEN-LAST:event_loginBtnActionPerformed

    /**
     * @param args the command line arguments
     */

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Left;
    private javax.swing.JPanel Right;
    private javax.swing.JTextField emailTxt;
    private javax.swing.JCheckBox instructorCBX;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton loginBtn;
    private javax.swing.JPasswordField passwordTxt;
    private javax.swing.JButton signupBtn;
    // End of variables declaration//GEN-END:variables
}
