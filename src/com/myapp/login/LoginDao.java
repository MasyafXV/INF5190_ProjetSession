package com.myapp.login;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;

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
    	
		String url = "http://localhost:8080/services/webapi/";
		String url_param = "user/getUserPassword/"+userName;
		
		System.out.println("\nConnection to  " + url+url_param);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+url_param))
                .build();

        HttpResponse<String> response = null;
		try {
			response = client.send(request,
			        HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		if(response.body().toString().equals(password)) {
        	status=true;

		}
		
		return status;
	}
	
	public  boolean validateAdmin(String userName,String password){
		
		boolean status=false;
    	System.out.println("Entered admin username: "+userName);
    	System.out.println("Entered admin pass: "+password);
		
		String url = "http://localhost:8080/services/webapi/";
		String url_param = "admin/getAdminPassword/"+userName;
		
		System.out.println("\nConnection to  " + url+url_param);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+url_param))
                .build();

        HttpResponse<String> response = null;
		try {
			response = client.send(request,
			        HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		if(response.body().toString().equals(password)) {
        	status=true;

		}
		
		return status;
	}
	

}
