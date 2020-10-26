package com.pronatation.Session;

import java.text.ParseException;

import com.opensymphony.xwork2.ActionSupport;

public class CreateSessionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private String code;
	private String season;
	private String year;
	private String sessionFrom;
	private String sessionTo;

	private SessionBeans session;

	public String execute() {
		System.out.print("createSEssionAction check");

		SessionBusiness sessionBusiness = new SessionBusiness();

		SessionDTO sessionDTO = null;
		try {
			sessionDTO = new SessionDTO(session.getCode(), session.getSeason(), session.getYear(),
					session.getSessionFrom(), session.getSessionTo());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sessionBusiness.addSession(sessionDTO);

		return SUCCESS;
	}

	public SessionBeans getsession() {
		return session;
	}

	public void setsession(SessionBeans session) {
		this.session = session;
	}

	public String getSeason() {
		return season;
	}

	public void setSeason(String season) {
		this.season = season;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getSessionFrom() {
		return sessionFrom;
	}

	public void setSessionFrom(String sessionFrom) {
		this.sessionFrom = sessionFrom;
	}

	public String getSessionTo() {
		return sessionTo;
	}

	public void setSessionTo(String sessionTo) {
		this.sessionTo = sessionTo;
	}

	public SessionBeans getSession() {
		return session;
	}

	public void setSession(SessionBeans session) {
		this.session = session;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
