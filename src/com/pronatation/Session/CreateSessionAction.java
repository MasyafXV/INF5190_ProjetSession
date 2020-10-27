package com.pronatation.Session;

import java.text.ParseException;

import com.opensymphony.xwork2.ActionSupport;

public class CreateSessionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private SessionBeans newSession;

	public String execute() {
		System.out.print("\ncreateSessionAction check");
		System.out.print("\n");
		System.out.print("\nsession.season = " + newSession.getSeason());
		System.out.print("\nsession.year = " + newSession.getYear());
		System.out.print("\nsession.sessionFrom = " + newSession.getSessionFrom());
		System.out.print("\nsession.sessionTo = " + newSession.getSessionTo());
		System.out.print("\nsession.code = " + newSession.getCode());

		SessionBusiness sessionBusiness = new SessionBusiness();

		SessionDTO sessionDTO = null;
		try {
			sessionDTO = new SessionDTO(newSession.getCode(), newSession.getSeason(), newSession.getYear(),
					newSession.getSessionFrom(), newSession.getSessionTo());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
