package com.scp.Entitiy;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserData {

	@Id
	private int Uid;
	private String userName;
	private String pwd;
	
	
	public UserData(){
		
	}


	public UserData(int uid, String userName, String pwd) {
		super();
		Uid = uid;
		this.userName = userName;
		this.pwd = pwd;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	
	public int getUid() {
		return Uid;
	}


	public void setUid(int uid) {
		Uid = uid;
	}


	@Override
	public String toString() {
		return "\n UserData [Uid=" + Uid + ", userName=" + userName + ", pwd=" + pwd + "]";
	}


	
}
