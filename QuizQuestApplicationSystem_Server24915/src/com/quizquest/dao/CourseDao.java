
package com.quizquest.dao;

import com.quizquest.model.Course;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Mulinda Kevin
 */
public class CourseDao {
    
    public Course registerCourse(Course crsObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.save(crsObj);
            tr.commit();
            ss.close();
            return crsObj;
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Erro Message: "+e.getMessage());
        }
    
        return null;
    }

    public Course updateCourse(Course crsObj){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Transaction tr = ss.beginTransaction();
            ss.update(crsObj);
            tr.commit();
            ss.close();
            return crsObj;
        } catch (HibernateException e) {
            e.printStackTrace();
            System.err.println("Erro Message: "+e.getMessage());
        }
    
        return null;
    }

    public List<Course>retrieveAllCourse(){
        
        try {
            Session ss = HibernateUtil.getSessionFactory().openSession();
            List<Course> courses = ss.createQuery("SELECT course FROM Course course").list();
            ss.close();
            return courses;
        } catch (HibernateException e) {
            e.printStackTrace();
        }
    
        return null;
    }
    
    public Course findCourseById(Course crsObj){
        try{
            Session ss = HibernateUtil.getSessionFactory().openSession();
            Course theCourse = (Course) ss.get(Course.class, crsObj.getCourseId());
            ss.close();
            return theCourse;
        }catch(HibernateException ex){
            ex.printStackTrace();
        }
        return null;
    }
    
}
