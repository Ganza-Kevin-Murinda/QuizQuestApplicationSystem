/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Mulinda Kevin
 */
@Entity
public class UserResult implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "result_Id")
    private int resultId;
    @ManyToOne
    @JoinColumn(name = "user_Id_fk")
    private UserIdentity theUser;
    @ManyToOne
    @JoinColumn(name = "course_Id_fk")
    private Course theCourse;
    private int score;
    private String dateTime;

    public UserResult() {
    }

    public UserResult(int resultId, UserIdentity theUser, Course theCourse, int score, String dateTime) {
        this.resultId = resultId;
        this.theUser = theUser;
        this.theCourse = theCourse;
        this.score = score;
        this.dateTime = dateTime;
    }

    public UserResult(int resultId) {
        this.resultId = resultId;
    }

    public int getResultId() {
        return resultId;
    }

    public UserIdentity getTheUser() {
        return theUser;
    }

    public Course getTheCourse() {
        return theCourse;
    }

    public int getScore() {
        return score;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setResultId(int resultId) {
        this.resultId = resultId;
    }

    public void setTheUser(UserIdentity theUser) {
        this.theUser = theUser;
    }

    public void setTheCourse(Course theCourse) {
        this.theCourse = theCourse;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    
    
    
}
