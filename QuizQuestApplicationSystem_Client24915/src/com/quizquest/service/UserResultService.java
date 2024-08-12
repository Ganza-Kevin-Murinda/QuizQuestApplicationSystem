/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service;

import com.quizquest.model.UserResult;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public interface UserResultService extends Remote {
    //method signature
    UserResult insertResult(UserResult resultObj) throws RemoteException;
    List<UserResult> retrieveAllResult() throws RemoteException;
    List<UserResult> retrieveUserResult(int userId) throws RemoteException;
    List<UserResult> adminFindUserResultsByUserId(UserResult resultObj) throws RemoteException;
    List<UserResult> userFindUserResultByDate(UserResult resultObj) throws RemoteException;
    
}
