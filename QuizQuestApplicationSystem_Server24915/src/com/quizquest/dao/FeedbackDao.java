/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.dao;


import com.quizquest.model.Feedback;
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
public class FeedbackDao {
    
    public Feedback registerFeedback(Feedback fbObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(fbObj);
            tr.commit();
            ss.close();
            return fbObj;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return null;
    }

    public List<Feedback>retrieveAllFeedback(){
        List<Feedback> feedbacks = new ArrayList<>();
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Feedback> list = ss.createQuery("SELECT feedback FROM Feedback feedback").list();
            if (list != null) {
                for(Feedback theFeedback : list){
                    Hibernate.initialize(theFeedback.getTheUser());
                    feedbacks.add(theFeedback);
                }
            }
            ss.close();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return feedbacks;
    }
    
    public List<Feedback> retrieveUnreadFeedback(){ 
        
        List<Feedback> feedbackList = new ArrayList<>();
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Feedback WHERE isRead = false";
            List<Feedback>list = ss.createQuery(hql).list();
            if (list != null) {
                for(Feedback theFeedback : list){
                    Hibernate.initialize(theFeedback.getTheUser());
                    feedbackList.add(theFeedback);
                }
            }
            ss.close();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return feedbackList;
    }
    
    //To be back!!
    public Integer updateFeedback(){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            String hql = "UPDATE Feedback fdb SET fdb.isRead = :newValue WHERE fdb.isRead = :oldValue";
            Query query = ss.createQuery(hql);
            query.setParameter("newValue", true);
            query.setParameter("oldValue", false);
            int num = query.executeUpdate();
            tr.commit();
            ss.close();
            return num;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return null;
    }
 
    //To be back!!
    public int countUnReadMessages(){
            int num = 0;
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            //ss.update(fbObj);
            String hql = "SELECT COUNT(fdb) FROM Feedback fdb WHERE fdb.isRead = false";
            Query query = ss.createQuery(hql);
            Long count =  (Long) query.uniqueResult();
            if (count != null) {
               num = count.intValue();
            }else{
                num =0;
            }
            //num = count != null ? count.intValue() : 0;
            tr.commit();
            ss.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return num;
    }
    
    public List<Feedback> findFeedbackByUserId(Feedback fbObj){
        
        List<Feedback> resultList = new ArrayList<>();
            try {
                Session ss = HibernateUtil.getSessionFactory().openSession();
                String hql = "FROM Feedback WHERE theUser.id = :userId";
                Query query = ss.createQuery(hql);
                query.setParameter("userId", fbObj.getTheUser().getId());
                resultList = query.list();
                ss.close();
                return resultList;
            } catch (HibernateException e) {
                e.printStackTrace();
            } 
        return null;
    }
    
}
