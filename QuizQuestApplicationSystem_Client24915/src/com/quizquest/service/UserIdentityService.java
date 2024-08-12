/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.service;

import java.rmi.Remote;
import java.rmi.RemoteException;
import com.quizquest.model.UserIdentity;
import java.util.List;

/**
 *
 * @author Mulinda Kevin
 */
public interface UserIdentityService extends Remote{
    //method Signature

    Integer userSignup(UserIdentity theUser) throws RemoteException;
    String[] userLogin(UserIdentity userObj) throws RemoteException;
    List<UserIdentity> retrieveUser(int userId) throws RemoteException;
    Integer updateUser(UserIdentity userObj) throws RemoteException;
    
    List<UserIdentity>adminRetrieveUser() throws RemoteException;
    Integer adminInactiveUser(UserIdentity userObj) throws RemoteException;
    
    List<UserIdentity>superUserRetrieveAllUser() throws RemoteException;
    List<UserIdentity>superUserRetrieveAllAdmin() throws RemoteException;
    Integer superUserInactiveAdmin(UserIdentity userObj) throws RemoteException;
    Integer ActivateUsers(UserIdentity userObj) throws RemoteException;
    Integer superUserCreateAdmin(UserIdentity userObj) throws RemoteException;
    
    UserIdentity findUserIdentityById(UserIdentity userObj) throws RemoteException;
}
