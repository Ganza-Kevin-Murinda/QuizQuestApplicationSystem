package com.quizquest.model;

import java.io.Serializable;
import java.util.List;



/**
 *
 * @author Mulinda Kevin
 */

public class UserIdentity implements Serializable {
    private int Id;
    private String fullName;
    private String email;
    private String userType;
    private String password;
    private String status;
    private String code;
    private List<UserResult> theResult;
    private List<Feedback> theFeedback;

    public UserIdentity() {
    }

    public UserIdentity(int Id, String fullName, String email, String userType, String password, String status, String code, List<UserResult> theResult, List<Feedback> theFeedback) {
        this.Id = Id;
        this.fullName = fullName;
        this.email = email;
        this.userType = userType;
        this.password = password;
        this.status = status;
        this.code = code;
        this.theResult = theResult;
        this.theFeedback = theFeedback;
    }

    public UserIdentity(int Id) {
        this.Id = Id;
    }
    

    public int getId() {
        return Id;
    }

    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getUserType() {
        return userType;
    }

    public String getPassword() {
        return password;
    }

    public String getStatus() {
        return status;
    }

    public String getCode() {
        return code;
    }

    public List<UserResult> getTheResult() {
        return theResult;
    }

    public List<Feedback> getTheFeedback() {
        return theFeedback;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setTheResult(List<UserResult> theResult) {
        this.theResult = theResult;
    }

    public void setTheFeedback(List<Feedback> theFeedback) {
        this.theFeedback = theFeedback;
    }
  
    
    
}
