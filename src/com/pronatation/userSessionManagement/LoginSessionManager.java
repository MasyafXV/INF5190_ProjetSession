package com.pronatation.userSessionManagement;

import com.opensymphony.xwork2.ActionSupport;

public class LoginSessionManager extends ActionSupport {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6010436271034061242L;
	private String userName="";


	public LoginSessionManager() {
		
	}
    public String execute() {
        return SUCCESS;
    }
 
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
