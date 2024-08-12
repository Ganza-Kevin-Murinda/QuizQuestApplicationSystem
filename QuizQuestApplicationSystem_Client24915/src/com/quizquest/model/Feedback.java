/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.model;

import java.io.Serializable;



/**
 *
 * @author Mulinda Kevin
 */

public class Feedback implements Serializable {
    private UserIdentity theUser;
    private int feedbackId;
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
