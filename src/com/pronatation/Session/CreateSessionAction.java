package com.pronatation.Session;

import com.opensymphony.xwork2.ActionSupport;

public class CreateSessionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private SessionBeans newSession;

	public String createSession() {
		System.out.print("createSEssionAction check");
		
		SessionBusiness sessionBusiness = new SessionBusiness();
		
		SessionDTO sessionDTO = new SessionDTO(newSession.getSeason(), newSession.getYear(), 
				newSession.getSessionFrom(), newSession.getSessionTo());
		
		sessionBusiness.addSession(sessionDTO);
		
		return SUCCESS;
	}
	
	public SessionBeans getNewSession() {
		return newSession;
	}

	public void setNewSession(SessionBeans newSession) {
		this.newSession = newSession;
	}
}
