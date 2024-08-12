/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.dao;

import com.quizquest.model.UserResult;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mulinda Kevin
 */
public class UserResultDao {
    
    public UserResult insertResult(UserResult resultObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(resultObj);
            tr.commit();
            ss.close();
            return resultObj;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
    return null;
    }
    
    public List<UserResult> retrieveAllResult(){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<UserResult> results = ss.createQuery("SELECT result FROM UserResult result").list();
            ss.close();
            return results;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<UserResult> retrieveUserResult(int userId){
        
        List<UserResult> resultList = new ArrayList<>();
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM UserResult WHERE theUser.Id = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("id", userId);
            resultList = query.list();
            ss.close();
            return resultList;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public List<UserResult> adminFindUserResultsByUserId(UserResult resultObj){
        
        List<UserResult> resultList = new ArrayList<>();
            try {
                Session ss = HibernateUtil.getSessionFactory().openSession();
                String hql = "FROM UserResult WHERE theUser.id = :userId";
                Query query = ss.createQuery(hql);
                query.setParameter("userId", resultObj.getTheUser().getId());
                resultList = query.list();
                ss.close();
                return resultList;
            } catch (HibernateException e) {
                e.printStackTrace();
            } 
    return null;
    }
    
    public List<UserResult> userFindUserResultByDate(UserResult resultObj){
        
            List<UserResult> resultList = new ArrayList<>();
            try {
                Session ss = HibernateUtil.getSessionFactory().openSession();
                String hql = "FROM UserResult WHERE dateTime = :date";
                Query query = ss.createQuery(hql);
                query.setParameter("date", resultObj.getDateTime());
                resultList = query.list();
                ss.close();
                return resultList;
            } catch (HibernateException e) {
                e.printStackTrace();
            } 
      
        return null;
    }
    
    
}
