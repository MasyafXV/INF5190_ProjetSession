package com.pronatation.Session;

import java.util.ArrayList;

public class SessionBusiness {
	SessionDAO sessionDAO = new SessionDAO();
	
    public SessionBusiness() {}
    
    public ArrayList<SessionDTO> getListSessions() {
        return sessionDAO.getSessions();
    }
    
    public void addSession(SessionDTO newSession) {
    	System.out.print("sessionBusiness addSession");
    	sessionDAO.addSession(newSession);
    }
}
