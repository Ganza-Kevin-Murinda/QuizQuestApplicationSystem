/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service.implementation;

import com.quizquest.dao.CourseDao;
import com.quizquest.model.Course;
import com.quizquest.service.CourseService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public class CourseServiceImpl extends UnicastRemoteObject implements CourseService{
    
    public CourseServiceImpl() throws RemoteException{
        super();
    }
    
    public CourseDao dao = new CourseDao();

    @Override
    public Course registerCourse(Course crsObj) throws RemoteException {
        return dao.registerCourse(crsObj);
    }

    @Override
    public Course updateCourse(Course crsObj) throws RemoteException {
        return dao.updateCourse(crsObj);
    }

    @Override
    public List<Course> retrieveAllCourse() throws RemoteException {
        return dao.retrieveAllCourse();
    }

    @Override
    public Course findCourseById(Course crsObj) throws RemoteException {
        return dao.findCourseById(crsObj);
    }
    
}
