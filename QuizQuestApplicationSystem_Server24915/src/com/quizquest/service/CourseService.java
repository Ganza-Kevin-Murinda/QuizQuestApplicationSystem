/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service;

import com.quizquest.model.Course;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public interface CourseService extends Remote{
    
    //method signature
    
    Course registerCourse(Course crsObj) throws RemoteException;
    Course updateCourse(Course crsObj) throws RemoteException;
    List<Course>retrieveAllCourse() throws RemoteException;
    Course findCourseById(Course crsObj) throws RemoteException;
    
}
