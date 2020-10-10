package com.pronatation.Session;

import com.opensymphony.xwork2.ActionSupport;

import java.util.ArrayList;

public class ViewSessionAction extends ActionSupport {
	
	private static final long serialVersionUID = 1L;
	private ArrayList<SessionBeans> listSessions;

	public ViewSessionAction() {}
	
	public String execute() {
		
		SessionBusiness sesssionBusiness = new SessionBusiness();
		
		ArrayList<SessionDTO> listSessionsDTO = sesssionBusiness.getListSessions();
		
		this.listSessions = new ArrayList<>();
		
		for (int i = 0; i < listSessionsDTO.size(); i++) {
			this.listSessions.add(
					new SessionBeans(listSessionsDTO.get(i).getSeason(), listSessionsDTO.get(i).getYear(), 
					listSessionsDTO.get(i).getSessionFrom(), listSessionsDTO.get(i).getSessionTo()));
		}
		
		return SUCCESS;
	}
	
	public ArrayList<SessionBeans> getListSessions() {
		return listSessions;
	}
	
	public void setListSessions(ArrayList<SessionBeans> listSessions) {
		this.listSessions = listSessions;
	}
}
