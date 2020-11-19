package com.pronatation.Session;

import java.text.ParseException;
import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class ViewSessionAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private ArrayList<SessionBeans> listSessions;

	public ViewSessionAction() {
	}

	public String execute() throws ParseException {

		SessionBusiness sessionBusiness = new SessionBusiness();

		ArrayList<SessionDTO> listSessionsDTO = sessionBusiness.getListSessions();

		this.listSessions = new ArrayList<>();

		for (int i = 0; i < listSessionsDTO.size(); i++) {
			try {

				this.listSessions.add(new SessionBeans(listSessionsDTO.get(i).getCode(),
						listSessionsDTO.get(i).getSeason(), listSessionsDTO.get(i).getYear(),
						listSessionsDTO.get(i).getSessionFrom(), listSessionsDTO.get(i).getSessionTo()));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
