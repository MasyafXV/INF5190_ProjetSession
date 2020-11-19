package com.pronatation.Session;

import java.text.ParseException;
import java.util.ArrayList;

import service.SessionService;

public class SessionDAO {

	private ArrayList<SessionDTO> sessions = new ArrayList<>();

	public SessionDAO() {

	}

	public int size() {
		return sessions.size();
	}

	public ArrayList<SessionDTO> getSessions() throws ParseException {
		SessionService sessionService = new SessionService();
		sessions = sessionService.getAllSessions();

		return sessions;
	}

	public void addSession(SessionDTO session) {
		SessionService sessionService = new SessionService();
		sessionService.createSession(session);
	}

	public void DeleteSession(SessionDTO session) {
		sessions.remove(session);
	}

}
