package com.scp.serviceImplementation;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.commons.collections4.iterators.EntrySetMapIterator;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.scp.Entitiy.UserData;
import com.scp.Pojo.UserPojo;
import com.scp.Util.utilityMethods;
import com.scp.constants.UserFieldsConstants;
import com.scp.constants.UserFieldsConstants.UserFields;
import com.scp.services.UserDataServices;



public class serviceImplementation implements UserDataServices {

	
   /*
    * Now as the method created below will have the implementation for adding the object to database.
    * I'll create a utility class which will allow user to establish connection with the database.
    * 
    * 
    * @see com.scp.services.UserDataServices#addUser(com.scp.Entitiy.UserData)
    */
	
 public static Session ss ;
 
 static{
	  ss = utilityMethods.createSession();
   }
	
	
	
	
	public void addUser(List<UserData> l) {
		
		Iterator<UserData> itr = l.iterator();
	    while(itr.hasNext()){
	    	
	    	UserData ob = itr.next();
	    	
	    	Session ss = utilityMethods.createSession();
	    	Transaction tr = ss.beginTransaction();
	    	
	    	ss.save(ob);
	    	
	    	tr.commit();
	    	
	    }
		
	}

	public UserData displayUser(List<UserData> l) {
		
		UserData ob = new UserData();
		
		Iterator<UserData> itr = l.iterator();
		while(itr.hasNext()){
			ob=itr.next();
			//System.out.println(itr.next());
		}
		return ob;
	}
	
	

	public void authenticateUser(String uname, String psd, List<UserData> l) {
		
	Iterator<UserData> itr = l.iterator();
	while(itr.hasNext()){
		UserData ob = itr.next();
		if(uname.equals(ob.getUserName()) && psd.equals(ob.getPwd())){
			System.out.println("Authentic User Success !!");
		}
		else{
			System.out.println("User Authentication Failed");
		}
	}
		
		
		/*Session ss = utilityMethods.createSession();
		Transaction tr = ss.beginTransaction();
		
		UserData obj= (UserData) ss.get();
		
		try{
			ss.save(obj);
		}
		catch(Exception e){
			
			System.out.println("User Authentication Success !!");
		}
		*/
		
			/*if(ss.get(uname, psd)== true){
				
			}*/
	}

	public String AuthenticateUser(String uname, String psd) {
		
		SessionFactory sf = utilityMethods.establishFactory();
		
		Session ss= sf.openSession();
		
		Transaction tr = ss.beginTransaction();
		
		/*Criteria c = ss.createCriteria(UserData.class);
		//c.add(Restrictions.eq("userName", uname));
		
		List<UserData> listOfAutheticUser = c.list();
		
		System.out.println("size of list   "+listOfAutheticUser.size()+  " for username "+uname);
		
		if(listOfAutheticUser.size()>0){
			
			Iterator<UserData> itr = listOfAutheticUser.iterator();
			while(itr.hasNext()){
				if(psd.equals(itr.next())){
					
					System.out.println("User is valid !!");
					return "User is Valid";
				}
				
			}
			return "invalid pwd";
			
		}
		else{
			return "No Such User";
		}
		
		}	*/
		
		
		//else{
			
			//return "No Such User";
			//if(listOfAutheticUser.iterator() != null)
		//}
		
		List<UserData> listOfAutheticUser = (List<UserData>) ss.createQuery("from userdata");
		
		tr.commit();
		Iterator<UserData> itr = listOfAutheticUser.iterator();
		while(itr.hasNext()){
			
			UserData user = itr.next();
			
			if(uname.equals(user.getUserName()) && psd.equals(user.getPwd())){
				
				return "User is valid !!";
				
			}
			else{
				return "Password not Valid !!";
			}
			
		}
		return "User not valid";
		
		
		
		
		
		//ss.close();
		
		//return listOfAutheticUser;
	}

	public UserPojo getUser(int userId) {
		
		Transaction tr = ss.beginTransaction();
		
		UserData obj = ss.get(UserData.class,userId);
		
		tr.commit();
		
		UserPojo up = new UserPojo(); 
		
		up.setUid(obj.getUid());
		up.setUserName(obj.getUserName());
		up.setPwd(obj.getPwd());
		
		
		return up;
		
		
	}

	
	public static void main(String[] args) {
		
		serviceImplementation ob = new serviceImplementation();
		ob.addUser(new UserPojo());
	}
	
	
	public boolean addUser(UserPojo user) {
		
		UserData obj = new UserData();
		
		obj.setUid(user.getUid());
		obj.setUserName(user.getUserName());
		obj.setPwd(user.getPwd());
		
		Transaction tr= ss.beginTransaction();
		try{
			ss.save(obj);
			if(true)
			throw new Exception();
				
			tr.commit();
			System.out.println("Inside try block exception!!");
			return true;
		}
		
		
		finally{
		//	tr.rollback();
		System.out.println("I'm in finally block!!");
		return false;
		}
		
	}

	public boolean deleteUser(int userId) {
		
		UserData obj = new UserData();
		obj.setUid(userId);
		
		Transaction tr = ss.beginTransaction();

		ss.delete(obj);
		
		tr.commit();
		return true;
	}

	public boolean updateUser(UserPojo user) {
		
		//user.setUserName("POGBA");
		
		user.setUid(3);
		
		Transaction tr = ss.beginTransaction();
		
		UserData eob= ss.get(UserData.class, 4);
		
	//	eob.setUid(user.getUid());     //ye comment kiya to chalega , but tu id kyu change kr rha hai , nice point merge dosent allow to change id
		eob.setUserName(user.getUserName());// You mean to say i should try changing the string value of the obj. rather than id.?? yes shoud not be changed , its normaly auto generated , u w
		eob.setPwd(user.getPwd());// mera auto gen nahi hai.. know but  muze b qstn hai why merge dosent allow to change id , i think bcoz then than object will be treated as transient
		
		ss.merge(eob);    //eob has 3 id , but it had 4  before , how hib knows that ?coz meine upar usko get se retrive kiya hai
		
		tr.commit();  //id altered from 4 to 3
		
		return true;
	}

	public List<UserPojo> getAllUser() {
		
		List<UserData> enlist = new ArrayList<UserData>();
		
		List<UserPojo> polist = new ArrayList<UserPojo>();
		
		Transaction tr = ss.beginTransaction();
		
		Criteria c = ss.createCriteria(UserData.class);
		
		//enlist = c.list();
		
		polist = c.list();
		
		/*Iterator<UserData> itr = enlist.iterator();
		while(itr.hasNext()){
			
			
			
			//polist.addAll((Collection<? extends UserPojo>) itr.next());
			
		}*/
		return polist;
	}

	

/*	public List<UserPojo> searchUser(HashMap<UserFieldsConstants.UserFields, String> searchCriteria) {
		
		Transaction tr = ss.beginTransaction();
		
		try{	
			
		Query query = ss.createQuery( "from userdata where Userid =: Uid  and UserName =: userName");
		
		Set<Entry<UserFields, String>> entrySet = searchCriteria.entrySet();
		
		
		for (Entry<UserFields, String> entry : entrySet) {
			if(entry.getKey().equals(UserFields.Uid))
				query.setInteger(entry.getKey().toString(), Integer.parseInt(entry.getValue()));
			
			if(entry.getKey().equals(UserFields.pwd)){
				query.setString(entry.getKey().toString(),  entry.getValue().toString());
			}
			if(entry.getKey().equals(UserFields.userName)){
				query.setString(entry.getKey().toString(),  entry.getValue().toString());
			}
        }

          System.out.println(query.getQueryString());
          System.out.println("Query list -- " +query.list());

          return query.list();
      
         } catch (Exception e) {
                e.printStackTrace();

                tr.rollback();
          }finally{
           ss.close();
          } 
     return null;

}
	*/	
		/*Set<Entry<UserFields,String>> eSet = searchCriteria.entrySet();
		
		List<UserData> elist = new ArrayList();
		
		Transaction tr = ss.beginTransaction();
		
		Criteria c = ss.createCriteria(UserData.class);
		
		elist = c.list();
		
		Iterator<Entry<UserFields, String>> itr = eSet.iterator();
		while(itr.hasNext()){
			
			Entry eset1 = itr.next();

			c.add(Restrictions.eq(eset1.getKey().toString(), eset1.getValue().toString()));
			
			System.out.println("The output of entry set " + eset1);
			
			//System.out.println("Criteria Ka Output ="+ c.toString());
		}
		
		
		return null;
	}*/
	
  }
