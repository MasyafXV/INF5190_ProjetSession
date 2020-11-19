package com.pronatation.Session;

import java.text.ParseException;
import java.util.ArrayList;

public class SessionBusiness {
	SessionDAO sessionDAO = new SessionDAO();

	public SessionBusiness() {
	}

	public ArrayList<SessionDTO> getListSessions() throws ParseException {
		return sessionDAO.getSessions();
	}

	public void addSession(SessionDTO newSession) {
		System.out.print("\nsessionBusiness addSession");
		sessionDAO.addSession(newSession);
	}
}
