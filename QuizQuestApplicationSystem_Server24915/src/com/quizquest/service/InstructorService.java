/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service;

import com.quizquest.model.Instructor;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public interface InstructorService extends Remote{
    
    //method signature
    String[] instructorLogin(Instructor instObj) throws RemoteException;
    List<Instructor> retrieveInstructor(int instructorId) throws RemoteException;
    Integer updateInstructor(Instructor instObj) throws RemoteException;
    
    List<Instructor> adminRetrieveAllInstructor() throws RemoteException;
    Integer instructorSignUp(Instructor instObj) throws RemoteException;
    Integer adminInactiveInstructor(Instructor instObj) throws RemoteException;
    Instructor findInstructorById(Instructor instObj) throws RemoteException;
    Integer ActivateInstructor(Instructor instObj) throws RemoteException;
}
