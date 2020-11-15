package com.myapp.login;

import java.util.ArrayList;

import com.pronatation.admins.AdminDTO;
import com.pronatation.users.UserDTO;

import service.AdminService;
import service.UserService;



public class LoginDao  {
	
	static ArrayList<UserDTO> UserList = new ArrayList<>();
	static ArrayList<AdminDTO> AdminList = new ArrayList<>();

	private String ProjectPath;

	   public LoginDao() {
		   
	   }
	   

	   public void save(UserDTO personne) {
		   UserList.add(personne);
		   }
		      
	   public void delete(UserDTO personne) {
		   UserList.remove(personne);
		   }

	
	public  boolean validateUser(String userName,String password){
		
		boolean status=false;
    	System.out.println("Entered user username: "+userName);
    	System.out.println("Entered user pass: "+password);
		
		UserService uservice = new UserService(userName);
		
		if(uservice.getUserPassword().equals(password)) {
        	status=true;

		}
		
		return status;
	}
	
	public  boolean validateAdmin(String userName,String password){
		
		boolean status=false;
    	System.out.println("Entered user username: "+userName);
    	System.out.println("Entered user pass: "+password);
		
		AdminService aservice = new AdminService(userName);
		
		if(aservice.getUserPassword().equals(password)) {
        	status=true;

		}
		
		return status;
	}
	

}
