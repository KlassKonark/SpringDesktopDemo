package com.scp.Util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class utilityMethods {

	static SessionFactory sf = null;
	
	
	public static SessionFactory establishFactory(){
		
		if(sf==null){
			
			sf = new Configuration().configure("hibernate.mysqlcfg.xml").buildSessionFactory();
					
		}
		
		return sf;
	}
	
	
	
	
	
	public static Session createSession(){
		
	  Session ss = utilityMethods.establishFactory().openSession();	
		
		return ss;
	}
	
}
