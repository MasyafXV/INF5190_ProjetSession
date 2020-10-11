package com.myapp.login;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class LoginDao  {
	
	static ArrayList<UserDTO> UserList = new ArrayList<>();
	static ArrayList<AdminDTO> AdminList = new ArrayList<>();
	static String myPath = "/Users/vorolf/Documents/Course/SessionLive/Web app/INF5190_ProjetSession/WebContent/Data/Users.txt";
	static String ElsaPath = "/Users/elsatran/Desktop/PROJECT_INF5190/INF5190_ProjetSession/WebContent/Data/Users.txt";

	   public LoginDao() {
		   
	   }
	   
	public static ArrayList<UserDTO> getAllUsers() {
		System.out.println("Getting all users");
		      
		      try {
			     //File myObj = new File("personnes.txt");
				 Scanner myReader = new Scanner(new File(myPath));
				 
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
	public static ArrayList<AdminDTO> getAllAdmins() {
		System.out.println("Getting all users");
	      
	      try {
		     //File myObj = new File("personnes.txt");
	    	 Scanner myReader = new Scanner(new File("/Users/vorolf/Documents/Course/SessionLive/Web app/INF5190_ProjetSession/WebContent/Data/Admins.txt"));
			 
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

	
	public static boolean validateUser(String userName,String password){
		ArrayList<UserDTO> users = getAllUsers();
		boolean status=false;
		
    	System.out.println("ENTERED username: "+userName);
    	System.out.println("ENTERED pass: "+password);
		
        for (int i = 0; i < users.size(); i++) {

            if (users.get(i).getUsername().equals(userName)) {  
            	if(users.get(i).getPassword().equals(password)) {
                	status=true;
                	System.out.println("LOGIN SUCCES");
            	}
            }
        }
		
		return status;
	}
	
	public static boolean validateAdmin(String userName,String password){
		ArrayList<AdminDTO> admins = getAllAdmins();
		boolean status=false;
		
    	System.out.println("ENTERED username: "+userName);
    	System.out.println("ENTERED pass: "+password);
		
        for (int i = 0; i < admins.size(); i++) {

            if (admins.get(i).getUsername().equals(userName)) {  
            	if(admins.get(i).getPassword().equals(password)) {
                	status=true;
                	System.out.println("LOGIN SUCCES");
            	}
            }
        }
		
		return status;
	}

}
