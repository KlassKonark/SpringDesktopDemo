package com.scp.Pojo;

public class UserPojo {
	
	private int Uid;
	private String userName;
	private String pwd;
	
	public UserPojo(){
		
	}
	
	public UserPojo(int uid, String userName, String pwd) {
		super();
		Uid = uid;
		this.userName = userName;
		this.pwd = pwd;
	}

	public int getUid() {
		return Uid;
	}

	public void setUid(int uid) {
		Uid = uid;
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

	@Override
	public String toString() {
		return "UserPojo [Uid=" + Uid + ", userName=" + userName + ", pwd=" + pwd + "]";
	}
	
	
	

}
