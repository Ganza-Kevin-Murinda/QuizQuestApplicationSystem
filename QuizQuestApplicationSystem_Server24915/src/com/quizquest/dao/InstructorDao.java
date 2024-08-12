/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.dao;


import com.quizquest.model.Instructor;
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
public class InstructorDao {
    
    public String[] instructorLogin(Instructor instObj){
        
        String[] isFound = new String[6];
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Instructor WHERE email = :email AND password = :password";
            Query query = ss.createQuery(hql);
            query.setParameter("email", instObj.getEmail());
            query.setParameter("password", instObj.getPassword());
            Instructor instructor = (Instructor) query.uniqueResult();
            
            if (instructor != null) {
            isFound[0] = "1";
            if ("Active".equals(instructor.getStatus())) {
                isFound[1] = "1";
            } else {
                isFound[1] = "0";
            }
            String instructorId = String.valueOf(instructor.getInstructorId());
            isFound[2] = instructorId;
            isFound[3] = instructor.getFullName();
            isFound[4] = instructor.getUserType();
            } else {
                isFound[0] = "0";
            }
            ss.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        return isFound;
    }
    
    public List<Instructor> retrieveInstructor(int instructorId){ //I have to use the instructorId instead of email
        
        List<Instructor> userList = new ArrayList<>();
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            String hql = "FROM Instructor WHERE instructorId = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("id", instructorId);
            List<Instructor> list = query.list();
            if (list != null) { 
                for (Instructor theInstructor : list){
                Hibernate.initialize(theInstructor.getTheCourse());
                userList.add(theInstructor);
                }
            }
            ss.close();
            
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return userList;
    }
    
    public Integer updateInstructor(Instructor instObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            String hql = "UPDATE Instructor inst SET inst.fullName = :name, inst.email = :email, inst.password = :password WHERE inst.instructorId = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("name", instObj.getFullName());
            query.setParameter("email", instObj.getEmail());
            query.setParameter("password", instObj.getPassword());
            query.setParameter("id", instObj.getInstructorId());
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
    
    @SuppressWarnings("empty-statement")
    public List<Instructor> adminRetrieveAllInstructor(){
            
            List<Instructor> instructors = new ArrayList<>();
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Instructor> list = ss.createQuery("SELECT instructor FROM Instructor instructor").list();
            if(list != null){
                for (Instructor theInstructor : list){
                Hibernate.initialize(theInstructor.getTheCourse());
                instructors.add(theInstructor);
                }
            }
            ss.close();
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return instructors;
    }
    
    public Integer instructorSignUp(Instructor instObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            instObj.setPassword("12345");
            Integer ID = (Integer) ss.save(instObj);
            tr.commit();
            ss.close();
            return ID;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public Integer adminInactiveInstructor(Instructor instObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction(); 
            String hql = "UPDATE Instructor inst SET inst.status = :newValue WHERE inst.instructorId = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("newValue", "InActive");
            query.setParameter("id", instObj.getInstructorId());
            int num = query.executeUpdate();
            tr.commit();
            ss.close();
            return num;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public Integer ActivateInstructor(Instructor instObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction(); 
            String hql = "UPDATE Instructor inst SET inst.status = :newValue WHERE inst.instructorId = :id";
            Query query = ss.createQuery(hql);
            query.setParameter("newValue", "Active");
            query.setParameter("id", instObj.getInstructorId());
            int num = query.executeUpdate();
            tr.commit();
            ss.close();
            return num;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
        
        return null;
    }
    
    public Instructor findInstructorById(Instructor instObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Instructor theInstructor = (Instructor) ss.get(Instructor.class, instObj.getInstructorId());
            ss.close();
            return theInstructor;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
