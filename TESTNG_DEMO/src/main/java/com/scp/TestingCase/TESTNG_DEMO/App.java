package com.scp.TestingCase.TESTNG_DEMO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.scp.Entitiy.UserData;
import com.scp.Pojo.UserPojo;
import com.scp.constants.UserFieldsConstants;
import com.scp.constants.UserFieldsConstants.UserFields;
import com.scp.serviceImplementation.serviceImplementation;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
       
    	/*
    	 * I'm creating objects of my Entity class and will save them in database using hibernate.
    	 * 
    	 * To perform the desired task I'll have to create service class which will allow me desired operation to be 
    	 * perfomed on the objects of my Entity class.
    	 *  
    	 */
    	
    	//Creating POJO Objects manually.
    	
    	UserPojo pobj = new UserPojo(4, "MBAPPE", "FRANCE");
    	
    	
    	
    	
    	/*
    	 * Below are my Entity Objects.
    	 */
    	UserData user1 = new UserData(1,"Konark","skylight");
    	UserData user2 = new UserData(2,"Ninad","supernova");
    	UserData user3 = new UserData(3,"Anthony","silverspoon");
    	
    	
    	List<UserData> uob = new ArrayList<UserData>();
       
        uob.add(user1);
        uob.add(user2);
        uob.add(user3);
        
        HashMap<UserFields, String> smap = new HashMap<UserFields, String>();
    	
    	smap.put(UserFieldsConstants.UserFields.userName, "Konark");
    	//smap.put(user2, "Valid User");
    	//smap.put(user3, "Valid User");
    	
        
        serviceImplementation obj = new serviceImplementation();
        
       // obj.addUser(uob);
        //obj.displayUser(uob);
        //obj.authenticateUser("Konark","skylight", uob);
        //obj.getUser(1);
        
        //System.out.println("The UserPojo Object created from entity obj present in database="+ obj.getUser(1));
        
        //System.out.println(obj.addUser(pobj));
        
        // obj.deleteUser(3);
        
        //obj.updateUser(pobj);
        
        System.out.println(obj.getAllUser());
        
       // obj.searchUser(smap);
        
        
    }
}
