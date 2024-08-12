/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.model;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */

public class Instructor implements Serializable {
    private int instructorId;
    private List<Course> theCourse;
    private String fullName;
    private String email;
    private String userType;
    private String password;
    private String status;
    private String code;

    public Instructor() {
    }

    public Instructor(int instructorId, List<Course> theCourse, String fullName, String email, String userType, String password, String status, String code) {
        this.instructorId = instructorId;
        this.theCourse = theCourse;
        this.fullName = fullName;
        this.email = email;
        this.userType = userType;
        this.password = password;
        this.status = status;
        this.code = code;
    }

    public Instructor(int instructorId) {
        this.instructorId = instructorId;
    }

    public int getInstructorId() {
        return instructorId;
    }

    public List<Course> getTheCourse() {
        return theCourse;
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

    public void setInstructorId(int instructorId) {
        this.instructorId = instructorId;
    }

    public void setTheCourse(List<Course> theCourse) {
        this.theCourse = theCourse;
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
    
    
    
}
