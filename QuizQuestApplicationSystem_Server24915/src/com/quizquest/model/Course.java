/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Mulinda Kevin
 */
@Entity
public class Course implements Serializable {
    @Id
    @Column(name = "course_Id")
    private String courseId;
    private String courseName;
    @OneToMany(mappedBy = "theCourse")
    private List<UserResult> theResult;
    @OneToMany(mappedBy = "theCourse")
    private List<Questions> theQuestion;
    @ManyToMany(mappedBy = "theCourse")
    private List<Instructor> theInstructor;
    
    
    public Course() {
    }

    public Course(String courseId, String courseName, List<UserResult> theResult, List<Questions> theQuestion, List<Instructor> theInstructor) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.theResult = theResult;
        this.theQuestion = theQuestion;
        this.theInstructor = theInstructor;
    }


    public Course(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public List<UserResult> getTheResult() {
        return theResult;
    }

    public List<Questions> getTheQuestion() {
        return theQuestion;
    }


    public List<Instructor> getTheInstructor() {
        return theInstructor;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setTheResult(List<UserResult> theResult) {
        this.theResult = theResult;
    }

    public void setTheQuestion(List<Questions> theQuestion) {
        this.theQuestion = theQuestion;
    }


    public void setTheInstructor(List<Instructor> theInstructor) {
        this.theInstructor = theInstructor;
    }
    
    
    
}
