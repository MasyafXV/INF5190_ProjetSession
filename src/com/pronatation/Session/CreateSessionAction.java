package com.pronatation.Session;

import com.opensymphony.xwork2.ActionSupport;

public class CreateSessionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private SessionBeans newSession;
	
	public String createSession() {
		return SUCCESS;
	}
}
