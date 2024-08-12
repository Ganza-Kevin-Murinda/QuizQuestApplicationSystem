/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizquest.controller;

import com.quizquest.service.implementation.CourseServiceImpl;
import com.quizquest.service.implementation.FeedbackServiceImpl;
import com.quizquest.service.implementation.InstructorServiceImpl;
import com.quizquest.service.implementation.QuestionsServiceImpl;
import com.quizquest.service.implementation.UserIdentityServiceImpl;
import com.quizquest.service.implementation.UserResultServiceImpl;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

/**
 *
 * @author Mulinda Kevin
 */
public class Server {
    
    public static void main(String[] args) {
        try {
            
            System.setProperty("java.rmi.server.hostname","127.0.0.1");
            Registry registry = LocateRegistry.createRegistry(5000);
            registry.rebind("User", new UserIdentityServiceImpl()); 
            registry.rebind("Result", new UserResultServiceImpl());
            registry.rebind("Instructor", new InstructorServiceImpl());
            registry.rebind("Questions", new QuestionsServiceImpl());
            registry.rebind("Feedback", new FeedbackServiceImpl());
            registry.rebind("Course", new CourseServiceImpl());
            System.out.println("Server is running on port 5000");
            
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
    
}
