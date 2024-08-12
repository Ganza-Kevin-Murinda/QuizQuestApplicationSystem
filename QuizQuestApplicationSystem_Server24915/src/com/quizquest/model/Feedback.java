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
public class Feedback implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "feedback_Id")
    private int feedbackId;
    @ManyToOne
    @JoinColumn(name = "user_Id_fk")
    private UserIdentity theUser;
    @Column(name = "Text_Message")
    private String messageTxt;
    private boolean isRead;

    public Feedback() {
    }

    public Feedback(UserIdentity theUser, int feedbackId, String messageTxt, boolean isRead) {
        this.theUser = theUser;
        this.feedbackId = feedbackId;
        this.messageTxt = messageTxt;
        this.isRead = isRead;
    }

    public UserIdentity getTheUser() {
        return theUser;
    }

    public int getFeedbackId() {
        return feedbackId;
    }

    public String getMessageTxt() {
        return messageTxt;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setTheUser(UserIdentity theUser) {
        this.theUser = theUser;
    }

    public void setFeedbackId(int feedbackId) {
        this.feedbackId = feedbackId;
    }

    public void setMessageTxt(String messageTxt) {
        this.messageTxt = messageTxt;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }
    
    
    
}
