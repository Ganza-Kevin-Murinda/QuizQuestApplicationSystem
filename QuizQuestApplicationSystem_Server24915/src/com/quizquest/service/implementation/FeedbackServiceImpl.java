/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service.implementation;

import com.quizquest.dao.FeedbackDao;
import com.quizquest.model.Feedback;
import com.quizquest.service.FeedBackService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public class FeedbackServiceImpl extends UnicastRemoteObject implements FeedBackService{
    
    public FeedbackServiceImpl() throws RemoteException{
        super();
    }
    
    FeedbackDao dao = new FeedbackDao();
    
    @Override
    public Feedback registerFeedback(Feedback fbObj) throws RemoteException {
        return dao.registerFeedback(fbObj);
    }

    @Override
    public List<Feedback> retrieveAllFeedback() throws RemoteException {
        return dao.retrieveAllFeedback();
    }

    @Override
    public Integer updateFeedback() throws RemoteException {
        return dao.updateFeedback();
    }

    @Override
    public int countUnReadMessages() throws RemoteException {
        return dao.countUnReadMessages();
    }

    @Override
    public List<Feedback> retrieveUnreadFeedback() throws RemoteException {
        return dao.retrieveUnreadFeedback();
    }

    @Override
    public List<Feedback> findFeedbackByUserId(Feedback fbObj) throws RemoteException {
        return dao.findFeedbackByUserId(fbObj);
    }
    
}
