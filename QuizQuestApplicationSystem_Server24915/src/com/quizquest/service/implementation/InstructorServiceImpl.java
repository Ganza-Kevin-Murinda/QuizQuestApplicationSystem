/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service.implementation;

import com.quizquest.dao.InstructorDao;
import com.quizquest.model.Instructor;
import com.quizquest.service.InstructorService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public class InstructorServiceImpl extends UnicastRemoteObject implements InstructorService{
    
    public InstructorServiceImpl() throws RemoteException{
        super();
    }
    
    InstructorDao dao = new InstructorDao();

    @Override
    public String[] instructorLogin(Instructor instObj) throws RemoteException {
        return dao.instructorLogin(instObj);
    }

    @Override
    public List<Instructor> retrieveInstructor(int instructorId) throws RemoteException {
        return dao.retrieveInstructor(instructorId);
    }

    @Override
    public Integer updateInstructor(Instructor instObj) throws RemoteException {
        return dao.updateInstructor(instObj);
    }

    @Override
    public List<Instructor> adminRetrieveAllInstructor() throws RemoteException {
        return dao.adminRetrieveAllInstructor();
    }

    @Override
    public Integer instructorSignUp(Instructor instObj) throws RemoteException {
        return dao.instructorSignUp(instObj);
    }

    @Override
    public Integer adminInactiveInstructor(Instructor instObj) throws RemoteException {
        return dao.adminInactiveInstructor(instObj);
    }

    @Override
    public Instructor findInstructorById(Instructor instObj) throws RemoteException {
        return dao.findInstructorById(instObj);
    }

    @Override
    public Integer ActivateInstructor(Instructor instObj) throws RemoteException {
        return dao.ActivateInstructor(instObj);
    }
    
}
