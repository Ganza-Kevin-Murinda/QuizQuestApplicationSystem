/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service.implementation;

import com.quizquest.dao.UserResultDao;
import com.quizquest.model.UserResult;
import com.quizquest.service.UserResultService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public class UserResultServiceImpl extends UnicastRemoteObject implements UserResultService{
    
    public UserResultServiceImpl() throws RemoteException{
        super();
    }
    
    UserResultDao dao = new UserResultDao();

    @Override
    public UserResult insertResult(UserResult resultObj) throws RemoteException {
        return dao.insertResult(resultObj);
    }

    @Override
    public List<UserResult> retrieveAllResult() throws RemoteException {
        return dao.retrieveAllResult();
    }

    @Override
    public List<UserResult> retrieveUserResult(int userId) throws RemoteException {
        return dao.retrieveUserResult(userId);
    }

    @Override
    public List<UserResult> adminFindUserResultsByUserId(UserResult resultObj) throws RemoteException {
        return dao.adminFindUserResultsByUserId(resultObj);
    }

    @Override
    public List<UserResult> userFindUserResultByDate(UserResult resultObj) throws RemoteException {
        return dao.userFindUserResultByDate(resultObj);
    }
    
}
