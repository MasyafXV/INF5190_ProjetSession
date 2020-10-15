package com.pronatation.Session;

import com.opensymphony.xwork2.ActionSupport;

public class CreateSessionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private SessionBeans session;

	public String execute() {
		System.out.print("createSEssionAction check");
		
		SessionBusiness sessionBusiness = new SessionBusiness();
		
		SessionDTO sessionDTO = new SessionDTO(session.getSeason(), session.getYear(), 
				session.getSessionFrom(), session.getSessionTo());
		
		sessionBusiness.addSession(sessionDTO);
		
		return SUCCESS;
	}
	
	public SessionBeans getsession() {
		return session;
	}

	public void setsession(SessionBeans session) {
		this.session = session;
	}
}
