/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service;

import com.quizquest.model.Questions;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public interface QuestionsService extends Remote{
    
    //method signature
    Questions registerQuestions(Questions qstObj) throws RemoteException;
    Questions updateQuestions(Questions qstObj) throws RemoteException;
    Questions deleteQuestions(Questions qstObj) throws RemoteException;
    List<Questions>fetchQuestion() throws RemoteException;
    List<Object[]> fetchQuestionsAndAnswers(String courseId) throws RemoteException;
    Questions findQuestionsByQText(Questions qstObj) throws RemoteException;
    
}
