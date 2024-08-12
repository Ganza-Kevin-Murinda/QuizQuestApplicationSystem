/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service.implementation;

import com.quizquest.dao.QuestionsDao;
import com.quizquest.model.Questions;
import com.quizquest.service.QuestionsService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public class QuestionsServiceImpl extends UnicastRemoteObject implements QuestionsService{
    
    public QuestionsServiceImpl() throws RemoteException{
        super();
    }
    
    QuestionsDao dao = new QuestionsDao();

    @Override
    public Questions registerQuestions(Questions qstObj) throws RemoteException {
        return dao.registerQuestions(qstObj);
    }

    @Override
    public Questions updateQuestions(Questions qstObj) throws RemoteException {
        return dao.updateQuestions(qstObj);
    }

    @Override
    public Questions deleteQuestions(Questions qstObj) throws RemoteException {
        return dao.deleteQuestions(qstObj);
    }

    @Override
    public List<Questions> fetchQuestion() throws RemoteException {
        return dao.fetchQuestion();
    }

    @Override
    public List<Object[]> fetchQuestionsAndAnswers(String courseId) throws RemoteException {
        return dao.fetchQuestionsAndAnswers(courseId);
    }

    @Override
    public Questions findQuestionsByQText(Questions qstObj) throws RemoteException {
        return dao.findQuestionsByQText(qstObj);
    }
    
}
