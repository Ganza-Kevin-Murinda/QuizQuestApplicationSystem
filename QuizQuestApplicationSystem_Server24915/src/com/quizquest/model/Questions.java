/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Mulinda Kevin
 */
@Entity
public class Questions implements Serializable {
    @Id
    @Column(name = "question_Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int qId;
    @ManyToOne
    @JoinColumn(name = "course_Id_fk")
    private Course theCourse;
    @Column(name = "question_Text")
    private String qText;
    private String correctAnswer;
    private String choice1;
    private String choice2;
    private String choice3;
    private String choice4;

    public Questions() {
    }

    public Questions(Course theCourse, int qId, String qText, String correctAnswer, String choice1, String choice2, String choice3, String choice4) {
        this.theCourse = theCourse;
        this.qId = qId;
        this.qText = qText;
        this.correctAnswer = correctAnswer;
        this.choice1 = choice1;
        this.choice2 = choice2;
        this.choice3 = choice3;
        this.choice4 = choice4;
    }

    public Questions(int qId) {
        this.qId = qId;
    }

    public Questions(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public Course getTheCourse() {
        return theCourse;
    }

    public int getqId() {
        return qId;
    }

    public String getqText() {
        return qText;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public String getChoice1() {
        return choice1;
    }

    public String getChoice2() {
        return choice2;
    }

    public String getChoice3() {
        return choice3;
    }

    public String getChoice4() {
        return choice4;
    }

    public void setTheCourse(Course theCourse) {
        this.theCourse = theCourse;
    }

    public void setqId(int qId) {
        this.qId = qId;
    }

    public void setqText(String qText) {
        this.qText = qText;
    }

    public void setCorrectAnswer(String correctAnswer) {
        this.correctAnswer = correctAnswer;
    }

    public void setChoice1(String choice1) {
        this.choice1 = choice1;
    }

    public void setChoice2(String choice2) {
        this.choice2 = choice2;
    }

    public void setChoice3(String choice3) {
        this.choice3 = choice3;
    }

    public void setChoice4(String choice4) {
        this.choice4 = choice4;
    }
    
    
    
}
