package com.myapp.login;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

import com.pronatation.admins.AdminDTO;
import com.pronatation.pathManager.PathManager;
import com.pronatation.users.UserDTO;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

public class LoginDao  {
	
	static ArrayList<UserDTO> UserList = new ArrayList<>();
	static ArrayList<AdminDTO> AdminList = new ArrayList<>();

	private String ProjectPath;

	   public LoginDao() {
		   
	   }
	   
	public  ArrayList<UserDTO> getAllUsers() {
		
		
		   PathManager pathManager= new PathManager();
		   ProjectPath= pathManager.getProjectPath();
		   
		   String allUsersPath = ProjectPath+"Users.txt";

		System.out.println("Getting all users");
		      
		      try {
			     //File myObj = new File("personnes.txt");
				 Scanner myReader = new Scanner(new File(allUsersPath));
				 
				 String username;
				 String password;
				 
				 while (myReader.hasNextLine()) {
					 username   = myReader.nextLine();
					 password      = myReader.nextLine();
				    	
				    UserList.add(new UserDTO(username,password));
				    
				 }
				 myReader.close();
			  } catch (FileNotFoundException e) {
			     System.out.println("Le fichier est inexistant.");
				 e.printStackTrace();
			  }
		   		
			  return UserList;
		   }
	public  ArrayList<AdminDTO> getAllAdmins() {
		
		   PathManager pathManager= new PathManager();
		   ProjectPath= pathManager.getProjectPath();
		   
		   String allAdminsPath = ProjectPath+"Admins.txt";

		System.out.println("Getting all admins");
	      
	      try {
		     //File myObj = new File("personnes.txt");
	    	 Scanner myReader = new Scanner(new File(allAdminsPath));
			 
			 String username;
			 String password;
			 
			 while (myReader.hasNextLine()) {
				 username   = myReader.nextLine();
				 password      = myReader.nextLine();
			    	
				 AdminList.add(new AdminDTO(username,password));
			    
			 }
			 myReader.close();
		  } catch (FileNotFoundException e) {
		     System.out.println("Le fichier est inexistant.");
			 e.printStackTrace();
		  }
	   		
		  return AdminList;
	   }
	
	   public void save(UserDTO personne) {
		   UserList.add(personne);
		   }
		      
	   public void delete(UserDTO personne) {
		   UserList.remove(personne);
		   }

	
	public  boolean validateUser(String userName,String password){
		ArrayList<UserDTO> users = getAllUsers();
		boolean status=false;
		
    	System.out.println("Entered user username: "+userName);
    	System.out.println("Entered user pass: "+password);
		
        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getUsername().equals(userName)) {  
            	if(users.get(i).getPassword().equals(password)) {
                	status=true;
            	}
            }
        }
		
		return status;
	}
	
	public  boolean validateAdmin(String userName,String password){
		ArrayList<AdminDTO> admins = getAllAdmins();
		boolean status=false;
		
    	System.out.println("Entered admin username: "+userName);
    	System.out.println("Entered admin pass: "+password);
		
        for (int i = 0; i < admins.size(); i++) {

            if (admins.get(i).getUsername().equals(userName)) {  
            	if(admins.get(i).getPassword().equals(password)) {
                	status=true;
            	}
            }
        }
		
		return status;
	}
	

}
