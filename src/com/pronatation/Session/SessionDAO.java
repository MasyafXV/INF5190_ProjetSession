package com.pronatation.Session;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SessionDAO {
	
	private ArrayList<SessionDTO> sessions = new ArrayList<>();
	//private List<ClassDTO> listClass;
	
	public SessionDAO() {
		
	}
	
	public ArrayList<SessionDTO> getSessions() {
		System.out.println("Getting all sessions");
	      
	    try {
		//File myObj = new File("personnes.txt");
	    	Scanner myReader = new Scanner(new File("/Users/elsatran/Desktop/PROJECT_INF5190/INF5190_ProjetSession/WebContent/Data/session.txt"));
			 
			String season;
			int year;
			String dateFrom;
			String dateTo;
			 
			while (myReader.hasNextLine()) {
				season = myReader.nextLine();
	    		year = Integer.parseInt(myReader.nextLine());
	    		dateFrom = myReader.nextLine();
	    		dateTo = myReader.nextLine();
			    	
	    		sessions.add(new SessionDTO(season, year, dateFrom, dateTo));
			    
			 }
			 myReader.close();
			 
	    } catch (FileNotFoundException e) {
		     System.out.println("Le fichier est inexistant.");
			 e.printStackTrace();
		}
		return sessions;
	}
	
	public ArrayList<SessionDTO> getAllSessions() {
		SessionDTO sessionAutumn = new SessionDTO("Autumn", 2020, "08/09/2020", "22/12/2020");
		SessionDTO sessionWinter = new SessionDTO("Winter", 2021, "05/01/2021", "29/04/2021");
		
		sessions.add(sessionAutumn);
		sessions.add(sessionWinter);
	   		
		return sessions;
	   }
	     
	public void AddSession(SessionDTO session) {
		   sessions.add(session);
	}
	      
	public void DeleteSession(SessionDTO session) {
		   sessions.remove(session);
	}
	   
	   
}
