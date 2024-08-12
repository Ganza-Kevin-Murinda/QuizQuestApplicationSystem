/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service.implementation;

import com.quizquest.dao.UserIdentityDao;
import com.quizquest.model.UserIdentity;
import com.quizquest.service.UserIdentityService;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public class UserIdentityServiceImpl extends UnicastRemoteObject implements UserIdentityService{
    
    public UserIdentityServiceImpl() throws RemoteException{
        super();
    }
    
    UserIdentityDao dao = new UserIdentityDao();
    
    @Override
    public Integer userSignup(UserIdentity theUser) throws RemoteException {
        return dao.userSignUp(theUser);
    }

    @Override
    public String[] userLogin(UserIdentity userObj) throws RemoteException {
        return dao.userLogin(userObj);
    }

    @Override
    public List<UserIdentity> retrieveUser(int userId) throws RemoteException {
        return dao.retrieveUser(userId); 
    }

    @Override
    public Integer updateUser(UserIdentity userObj) throws RemoteException {
        return dao.updateUser(userObj);
    }

    @Override
    public List<UserIdentity> adminRetrieveUser() throws RemoteException {
        return dao.adminRetrieveUser();
    }

    @Override
    public Integer adminInactiveUser(UserIdentity userObj) throws RemoteException {
        return dao.adminInactiveUser(userObj);
    }

    @Override
    public List<UserIdentity> superUserRetrieveAllUser() throws RemoteException {
        return dao.superUserRetrieveAllUser();
    }

    @Override
    public Integer superUserInactiveAdmin(UserIdentity userObj) throws RemoteException {
        return dao.superUserInactiveAdmin(userObj);
    }

    @Override
    public Integer ActivateUsers(UserIdentity userObj) throws RemoteException {
        return dao.ActivateUsers(userObj);
    }

    @Override
    public Integer superUserCreateAdmin(UserIdentity userObj) throws RemoteException {
        return dao.superUserCreateAdmin(userObj);
    }

    @Override
    public List<UserIdentity> superUserRetrieveAllAdmin() throws RemoteException {
        return dao.superUserRetrieveAllAdmin();
    }

    @Override
    public UserIdentity findUserIdentityById(UserIdentity userObj) throws RemoteException {
        return dao.findUserIdentityById(userObj);
    }
    
}
