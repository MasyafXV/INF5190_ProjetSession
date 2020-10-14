package com.pronatation.Session;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;



public class SessionDAO {
	
	public final String filePath = "/Users/elsatran/Desktop/PROJECT_INF5190/INF5190_ProjetSession/WebContent/Data/session.txt";
	private ArrayList<SessionDTO> sessions = new ArrayList<>();
	
	
	public SessionDAO() {
		
	}
	
	public ArrayList<SessionDTO> getSessions() {
		System.out.println("Getting all sessions");
	      
	    try {
		//File myObj = new File("personnes.txt");
	    	Scanner myReader = new Scanner(new File(filePath));
			 
			String season;
			String year;
			String dateFrom;
			String dateTo;
			 
			while (myReader.hasNextLine()) {
				season = myReader.nextLine();
	    		year = myReader.nextLine();
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
	
	     
	public void addSession(SessionDTO session) {
		System.out.println("Saving new sessions");
		
		try {
			File file = new File(filePath);
			FileOutputStream fos = new FileOutputStream(file,true);
			 
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
			
			bw.write(session.getSeason());
			bw.newLine();
			bw.write(session.getYear());
			bw.newLine();
			bw.write(session.getSessionFrom());
			bw.newLine();
			bw.write(session.getSessionTo());
			bw.newLine();
			
			bw.close();
			
		} catch (Exception e) { System.out.print("Error adding Session");}

	}
	      
	public void DeleteSession(SessionDTO session) {
		   sessions.remove(session);
	}
	   
	   
}
