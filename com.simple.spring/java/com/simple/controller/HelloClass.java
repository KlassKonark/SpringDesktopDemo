package com.simple.controller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.scp.entity.Student;


public class HelloClass {
	
       public static void main(String[] args) {
		
    	  
    	   
    	  ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
		
    	   Student s1 = (Student) context.getBean("studentObj");
    	   
    	   System.out.println(s1);
	}
	
}
