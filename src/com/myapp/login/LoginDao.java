package com.myapp.login;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class LoginDao  {
	
	ArrayList<UserDTO> UserList = new ArrayList<>();
	ArrayList<AdminDTO> AdminList = new ArrayList<>();

	   public LoginDao() {
		   
	   }
	   
	public ArrayList<UserDTO> getAllUsers() {
		      
		      try {
			     //File myObj = new File("personnes.txt");
				 Scanner myReader = new Scanner(new File("C:/web/inf5190/personnes.txt"));
				 
				 String prenom;
				 String nom;
				 String adresse;
				 String courriel;
				 
				 while (myReader.hasNextLine()) {
				    		    
				    prenom   = myReader.nextLine();
				    nom      = myReader.nextLine();
				    adresse  = myReader.nextLine();
				    courriel = myReader.nextLine();
				    	
				    UserList.add(new UserDTO(prenom,nom));
				    
				 }
				 myReader.close();
			  } catch (FileNotFoundException e) {
			     System.out.println("Le fichier est inexistant.");
				 e.printStackTrace();
			  }
		   		
			  return UserList;
		   }
	public ArrayList<AdminDTO> getAllAdmins() {
	      
	      try {
		     //File myObj = new File("personnes.txt");
			 Scanner myReader = new Scanner(new File("C:/web/inf5190/personnes.txt"));
			 
			 String prenom;
			 String nom;
			 String adresse;
			 String courriel;
			 
			 while (myReader.hasNextLine()) {
			    		    
			    prenom   = myReader.nextLine();
			    nom      = myReader.nextLine();
			    adresse  = myReader.nextLine();
			    courriel = myReader.nextLine();
			    	
			    AdminList.add(new AdminDTO(prenom,nom));
			    
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
		boolean status=false;
        if (userName.length() == 0) {
        	
        } else if (userName.equals("User")) {
        	status=true;
        }
        if (password.length() == 0) {
        	
        }
		return status;
	}
	
	public static boolean validateAdmin(String userName,String password){
		boolean status=false;
        if (userName.length() == 0) {
        	
        } else if (userName.equals("Admin")) {
        	status=true;
        }
        if (password.length() == 0) {
        	
        }
		return status;
	}

}
