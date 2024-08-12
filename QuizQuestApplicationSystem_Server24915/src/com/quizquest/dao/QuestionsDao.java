/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.dao;

import com.quizquest.model.Questions;
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
public class QuestionsDao {
    //used
    public Questions registerQuestions(Questions qstObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(qstObj);
            tr.commit();
            ss.close();
            return qstObj;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return null;
    }
    //used
    public Questions updateQuestions(Questions qstObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.update(qstObj);
            tr.commit();
            ss.close();
            return qstObj;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return null;
    }
    //unused
    public Questions deleteQuestions(Questions qstObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.delete(qstObj);
            tr.commit();
            ss.close();
            return qstObj;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return null;
    }
    //used
    public List<Questions>fetchQuestion(){
        
            List<Questions> questions = new ArrayList<>();
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Questions> list = ss.createQuery("SELECT question FROM Questions question").list();
            if(list != null){
                for (Questions theQuestions : list){
                Hibernate.initialize(theQuestions.getTheCourse());
                questions.add(theQuestions);
                }
             }
            ss.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return questions;
    }
    //used
    public List<Object[]> fetchQuestionsAndAnswers(String courseId) {
        
        List<Object[]> questionsAndAnswersList = new ArrayList<>();

        try {
            Session session = HibernateUtil.getSessionFactory().openSession();

            String hql = "FROM Questions q WHERE q.theCourse.courseId = :courseId";
            Query query = session.createQuery(hql);
            query.setParameter("courseId", courseId);
            List<Questions> questionsList = query.list();

            for (Questions question : questionsList) {
                Hibernate.initialize(question.getTheCourse());
                Object[] questionAndChoices = { 
                    question.getTheCourse().getCourseId(), 
                    question.getqText(), 
                    question.getCorrectAnswer(), 
                    question.getChoice1(), 
                    question.getChoice2(), 
                    question.getChoice3(), 
                    question.getChoice4() 
                };
                questionsAndAnswersList.add(questionAndChoices);
            }
            session.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }

        return questionsAndAnswersList;
    }
    //unused
    public Questions findQuestionsByQText(Questions qstObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Questions theQuestions = (Questions) ss.get(Questions.class, qstObj.getqText());
            ss.close();
            return theQuestions;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
