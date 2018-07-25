package com.scp.services;

import java.util.HashMap;
import java.util.List;

import com.scp.Entitiy.UserData;
import com.scp.Pojo.UserPojo;
import com.scp.constants.UserFieldsConstants;


public interface UserDataServices {

	public void addUser(List<UserData> ob);
	public UserData displayUser(List<UserData> ob);
	public void authenticateUser(String uname, String psd, List<UserData> l);
	public String AuthenticateUser(String uname, String psd);
	
	/************************************/
	
	public boolean addUser(UserPojo user);
	public UserPojo getUser(int userId);
	public boolean deleteUser(int userId);
	public boolean updateUser(UserPojo user);
	public List<UserPojo> getAllUser();
	//public List<UserPojo> searchUser(HashMap<UserFieldsConstants.UserFields,String> searchCriteria);
	
	
	
	/*
	 * 
	 * public boolean addEmp(UserPojo user); [done]
	 * public boolean deleteEmp(int empId);
	 * public EmpPojo getEmp(int empId);     [done]
	 * public boolean updateEmp(EmpPojo emp);
	 * public List<EmpPojo> getAllEmps();
	 * public List<EmpPojo> searchEmp(HashMap<AppLevelContants.EmpFields,String> searchCriteria);
	 * 
	 * 
	 */
	
}
