/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service;

import com.quizquest.model.Feedback;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public interface FeedBackService extends Remote{
    
    //method signature
    Feedback registerFeedback(Feedback fbObj) throws RemoteException;
    List<Feedback>retrieveAllFeedback() throws RemoteException;
    List<Feedback> retrieveUnreadFeedback() throws RemoteException;
    Integer updateFeedback() throws RemoteException;
    int countUnReadMessages() throws RemoteException;
    List<Feedback> findFeedbackByUserId(Feedback fbObj) throws RemoteException;
    
}
