
package com.quizquest.view;



import com.quizquest.model.Course;
import com.quizquest.model.UserIdentity;
import com.quizquest.model.UserResult;
import com.quizquest.service.QuestionsService;
import com.quizquest.service.UserResultService;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Quiz extends JFrame implements ActionListener {

    List<Object[]> questionsAndAnswersList;
    String useranswers[][] = new String[10][1];

    JLabel qno, question;
    JRadioButton opt1, opt2, opt3, opt4;
    ButtonGroup groupoptions;
    JButton next, submit;

    public static int timer = 15;
    public static int ans_given = 0;
    public static int count = 0;
    public static int score = 0;
    
     // Get the current date and time
        LocalDateTime currentDateTime = LocalDateTime.now();

    String name,courseId,email,userId;

    Quiz(String Id,String userName, String course,String email) {
        this.userId = Id;
        this.name = userName;
        this.courseId = course;
        this.email = email;

        setBounds(0, 0, 1370, 725);

        getContentPane().setBackground(Color.WHITE);
        setLayout(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setExtendedState(MAXIMIZED_BOTH);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("com/quizquest/view/icon/quiz.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1370, 370);
        add(image);

        qno = new JLabel();
        qno.setBounds(100, 400, 50, 30);
        qno.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(qno);

        question = new JLabel();
        question.setBounds(150, 400, 900, 30);
        question.setFont(new Font("Tahoma", Font.PLAIN, 24));
        add(question);
        
        fetchQuestionsAndAnswersFromDatabase(); // Fetch questions and answers from the database
        shuffleQuestionsAndOptions(); // Shuffle questions and options

        

        opt1 = new JRadioButton();
        opt1.setBounds(170, 460, 700, 30);
        opt1.setBackground(Color.WHITE);
        opt1.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt1);

        opt2 = new JRadioButton();
        opt2.setBounds(170, 500, 700, 30);
        opt2.setBackground(Color.WHITE);
        opt2.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt2);

        opt3 = new JRadioButton();
        opt3.setBounds(170, 540, 700, 30);
        opt3.setBackground(Color.WHITE);
        opt3.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt3);

        opt4 = new JRadioButton();
        opt4.setBounds(170, 580, 700, 30);
        opt4.setBackground(Color.WHITE);
        opt4.setFont(new Font("Dialog", Font.PLAIN, 20));
        add(opt4);
        
        

        groupoptions = new ButtonGroup();
        groupoptions.add(opt1);
        groupoptions.add(opt2);
        groupoptions.add(opt3);
        groupoptions.add(opt4);

        next = new JButton("Next");
        next.setBounds(1100, 480, 200, 40);
        next.setFont(new Font("Tahoma", Font.PLAIN, 22));
        next.setBackground(new Color(51,0,204));
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        submit = new JButton("Submit");
        submit.setBounds(1100, 540, 200, 40);
        submit.setFont(new Font("Tahoma", Font.PLAIN, 22));
        submit.setBackground(new Color(51,0,204));
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setEnabled(false);
        add(submit);

        start(count);

        setVisible(true);

    }
    
    public final void fetchQuestionsAndAnswersFromDatabase() {
        // Code to fetch questions and answers from the database using QuestionsDao class
        try {
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
            QuestionsService service = (QuestionsService)registry.lookup("Questions");
            questionsAndAnswersList = service.fetchQuestionsAndAnswers(courseId);
        } catch (NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
    }
    
public final void shuffleQuestionsAndOptions() {
        // Shuffle the list of questions and answers
        Collections.shuffle(questionsAndAnswersList);
        // Shuffle choices for each question
        for (Object[] questionAndAnswer : questionsAndAnswersList) {
            // Assuming the question is at index 0 and options are at indices 1 to 4
            List<String> options = Arrays.asList(
                (String) questionAndAnswer[3],
                (String) questionAndAnswer[4],
                (String) questionAndAnswer[5],
                (String) questionAndAnswer[6]
            );
            Collections.shuffle(options);
            // Update the shuffled options back to the original list
            questionAndAnswer[3] = options.get(0);
            questionAndAnswer[4] = options.get(1);
            questionAndAnswer[5] = options.get(2);
            questionAndAnswer[6] = options.get(3);
        }
    }



    public void actionPerformed(ActionEvent ae) {
    if (ae.getSource() == next) {
        ans_given = 1;
        
        
        
        if (groupoptions.getSelection() == null) {
            useranswers[count][0] = "0";
        } else {
            useranswers[count][0] = groupoptions.getSelection().getActionCommand();
        }
        
        if (count == 8) {
            next.setEnabled(false);
            submit.setEnabled(true);
        }
        
        count++;
        start(count);
    } else if (ae.getSource() == submit) {
    ans_given = 1;
    if (groupoptions.getSelection() == null) {
        useranswers[count][0] = "0";
    } else {
        useranswers[count][0] = groupoptions.getSelection().getActionCommand();
    }

    // Ensure questionsAndAnswersList is not null
        if (questionsAndAnswersList != null && !questionsAndAnswersList.isEmpty()) {
            for (int i = 0; i < questionsAndAnswersList.size(); i++) {               
                Object[] questionAndAnswer = questionsAndAnswersList.get(i);
                if (questionAndAnswer != null && questionAndAnswer.length > 1) {
                    String correctAnswer = (String) questionAndAnswer[2];
                    if (useranswers[i][0] != null && useranswers[i][0].equals(correctAnswer)) {
                        score += 10;
                    } else if ("0".equals(useranswers[i][0])) {
                        score += 0;
                    } else {
                        score += 0;
                    }
                }
            }
        } else {
            System.out.println("Error: questionsAndAnswersList is null or empty");
        }

    //calling the result method
    quizResult();

}
}


    public void paint(Graphics g){
        
        super.paint(g);
        
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
        
        String time = "00:" + timer;//15
        g.setColor(Color.BLACK);
        g.setFont(new Font("Consolas", Font.BOLD, 40));
        
        if(timer >0){
            g.drawString(time, 1200, 450);
        }else{
            g.drawString("Times up!!", 1100, 450);
        }
        
        timer--;//14
        
        try {
            Thread.sleep(1000);
            repaint();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        if(ans_given == 1){
            ans_given = 0;
            timer = 15;
        } else if(timer < 0){
            timer = 15;
            opt1.setEnabled(true);
            opt2.setEnabled(true);
            opt3.setEnabled(true);
            opt4.setEnabled(true);
            
            if(count == 8){
            next.setEnabled(false);
            submit.setEnabled(true);
            }
            
            if(count == 9){ //submit button
                if(groupoptions.getSelection() == null){
                useranswers[count][0] = "0";//Third change
                }else{
                    useranswers[count][0] = groupoptions.getSelection().getActionCommand();
                }
                
                if (questionsAndAnswersList != null && !questionsAndAnswersList.isEmpty()) {
                    for (int i = 0; i < questionsAndAnswersList.size(); i++) {
                        Object[] questionAndAnswer = questionsAndAnswersList.get(i);
                        if (questionAndAnswer != null && questionAndAnswer.length > 1) {
                            String correctAnswer = (String) questionAndAnswer[2];
                            if (useranswers[i][0] != null && useranswers[i][0].equals(correctAnswer)) {
                                score += 10;
                            } else if ("0".equals(useranswers[i][0])) {
                                score += 0;
                            } else {
                                score += 0;
                            }
                        }
                    }
                }

                    //calling the result method
                    quizResult();

            }else{ //next buttpn
            
            if(groupoptions.getSelection() == null){
                useranswers[count][0] = "0";
            }else{
                useranswers[count][0] = groupoptions.getSelection().getActionCommand();
            }
            count++;//0//1
            start(count);
            }
        }
        
    }


public final void start(int count) {
    // Ensure count is within bounds
    Object[] questionAndChoices = questionsAndAnswersList.get(count);

    if (count >= 0 && count < questionsAndAnswersList.size()) {
        
        //capture the course ID
         courseId = (String) questionAndChoices[0];
        
        String questions = (String) questionAndChoices[1];

        qno.setText("" + (count + 1) + ".");
        question.setText(questions);
        opt1.setText((String) questionAndChoices[3]); // Option 1
        opt2.setText((String) questionAndChoices[4]); // Option 2
        opt3.setText((String) questionAndChoices[5]); // Option 3
        opt4.setText((String) questionAndChoices[6]); // Option 4
        
        opt1.setActionCommand(opt1.getText());
        opt2.setActionCommand(opt2.getText());
        opt3.setActionCommand(opt3.getText());
        opt4.setActionCommand(opt4.getText()); 

        groupoptions.clearSelection();
    } else {
        // Handle the case where count is out of bounds
        System.out.println("Error: Index out of bounds");
    }

}

    public void quizResult(){
        // Define the format for the date and time
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

            // Format the current date and time as a string
            String dateTimeString = currentDateTime.format(formatter);
            
            
        try {
            //Creating result model object
            UserResult theResult = new UserResult();
                theResult.setTheCourse(new Course(courseId));  
                theResult.setTheUser(new UserIdentity(Integer.parseInt(userId)));
                theResult.setScore(score);
                theResult.setDateTime(dateTimeString);  
            
            Registry registry = LocateRegistry.getRegistry("127.0.0.1",5000);
            UserResultService service = (UserResultService)registry.lookup("Result");
            
            UserResult resultObj = new UserResult();
            
            resultObj = service.insertResult(theResult);
            
            if(resultObj != null){
                JOptionPane.showMessageDialog(this, "This Marks the end of the quiz,Click Ok to see your Score");
                setVisible(false);
                new ScoreDashboard(userId,name,courseId,score,email).setVisible(true);
            }else{
            
                setVisible(false);
                new ScoreDashboard(userId,name,courseId,score,email).setVisible(true);
            }
        } catch (HeadlessException | NumberFormatException | NotBoundException | RemoteException e) {
            e.printStackTrace();
        }
        
        
    }


    public static void main(String[] args) {
        new Quiz("Id","User","courseId","email");
    }
}

