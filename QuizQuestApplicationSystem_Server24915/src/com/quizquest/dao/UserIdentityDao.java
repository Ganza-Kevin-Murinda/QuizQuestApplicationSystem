/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.dao;

import com.quizquest.model.UserIdentity;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mulinda Kevin
 */
public class UserIdentityDao {
    
    //UserPart
    
    public Integer userSignUp(UserIdentity userObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            userObj.setUserType("SystemUser"); 
            userObj.setStatus("Active");
            Integer ID = (Integer) ss.save(userObj);
            tr.commit();
            ss.close();
            return ID;
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Error occurred during userSignup: " + e.getMessage());
        }
        return null;
    }
    
    public String[] userLogin(UserIdentity userObj){
        
        String[] isFound = new String[5];
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM UserIdentity WHERE email = :email AND password = :password";
            Query query = ss.createQuery(hql);
            query.setParameter("email", userObj.getEmail());
            query.setParameter("password", userObj.getPassword());
            UserIdentity user = (UserIdentity) query.uniqueResult();
            
            if (user != null) {
            isFound[0] = "1";
            if ("Active".equals(user.getStatus())) {
                isFound[1] = "1";
            } else {
                isFound[1] = "0";
            }
            String userId = String.valueOf(user.getId());
            isFound[2] = userId;
            isFound[3] = user.getFullName();
            isFound[4] = user.getUserType();
            } else {
                isFound[0] = "0";
            }
            ss.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        return isFound;
    }
    
    public List<UserIdentity> retrieveUser(int userId){ //I have to use the userId instead of email
        
        List<UserIdentity> userList = new ArrayList<>();
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM UserIdentity WHERE Id = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("id", userId);
            List<UserIdentity> list = query.list();
               if(list != null){
                for (UserIdentity theUser : list){
                Hibernate.initialize(theUser.getTheResult());
                Hibernate.initialize(theUser.getTheFeedback());
                userList.add(theUser);
                }
            }
            ss.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return userList;
    }
    
    public Integer updateUser(UserIdentity userObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            String hql = "UPDATE UserIdentity user SET user.fullName = :name, user.email = :email, user.password = :password WHERE user.Id = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("name", userObj.getFullName());
            query.setParameter("email", userObj.getEmail());
            query.setParameter("password", userObj.getPassword());
            query.setParameter("id", userObj.getId());
            int num = query.executeUpdate();
            tr.commit();
            ss.close();
            return num;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    //Admin Part
    
    public List<UserIdentity>adminRetrieveUser(){
        
        List<UserIdentity> userList = new ArrayList<>();
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM UserIdentity WHERE userType = 'SystemUser'";
            List<UserIdentity> list = ss.createQuery(hql).list();
            
            if(list != null){
                for (UserIdentity theUser : list){
                Hibernate.initialize(theUser.getTheResult());
                Hibernate.initialize(theUser.getTheFeedback());
                userList.add(theUser);
                }
            }
            ss.close();
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Error occurred during userretrieval: " + e.getMessage());
        }
    
        return userList;
    }
    
    public Integer adminInactiveUser(UserIdentity userObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction(); 
            String hql = "UPDATE UserIdentity user SET user.status = :newValue WHERE user.Id = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("newValue", "InActive");
            query.setParameter("id", userObj.getId());
            int num = query.executeUpdate();
            tr.commit();
            ss.close();
            return num;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    //superUser Part
    
    public List<UserIdentity>superUserRetrieveAllUser(){
            
        List<UserIdentity> userList = new ArrayList<>();
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM UserIdentity WHERE userType = 'SystemUser'";
            userList = ss.createQuery(hql).list();
            ss.close();
            return userList;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return null;
    }
    
    public List<UserIdentity>superUserRetrieveAllAdmin(){
            
        List<UserIdentity> userList = new ArrayList<>();
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM UserIdentity WHERE userType = 'SystemAdmin'";
            userList = ss.createQuery(hql).list();
            ss.close();
            return userList;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return null;
    }
    
    public Integer superUserInactiveAdmin(UserIdentity userObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction(); 
            String hql = "UPDATE UserIdentity user SET user.status = :newValue WHERE user.Id = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("newValue", "InActive");
            query.setParameter("id", userObj.getId());
            int num = query.executeUpdate();
            tr.commit();
            ss.close();
            return num;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public Integer ActivateUsers(UserIdentity userObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction(); 
            String hql = "UPDATE UserIdentity user SET user.status = :newValue WHERE user.Id = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("newValue", "Active");
            query.setParameter("id", userObj.getId());
            int num = query.executeUpdate();
            tr.commit();
            ss.close();
            return num;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public Integer superUserCreateAdmin(UserIdentity userObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            userObj.setUserType("SystemAdmin"); 
            userObj.setStatus("Active");
            Integer adminID = (Integer) ss.save(userObj);
            tr.commit();
            ss.close();
            return adminID;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    
    public UserIdentity findUserIdentityById(UserIdentity userObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            UserIdentity theUser = (UserIdentity) ss.get(UserIdentity.class, userObj.getId());
            ss.close();
            return theUser;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return null;
    }
}
