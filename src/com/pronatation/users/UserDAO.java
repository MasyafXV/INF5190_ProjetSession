package com.pronatation.users;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import org.json.JSONArray;

public class UserDAO {
	
	
	public UserDAO() {
		
	}
	
	public String getUserBdate(String userName) {
		
		String url = "http://localhost:8080/services/webapi/";
		String url_param = "user/getUserBdate/"+userName;
		
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
		return response.body();		
	}
	
	public JSONArray listChilds(String userName) {
		String url = "http://localhost:8080/services/webapi/";
		String url_param = "user/getAllChilds/"+userName;
		
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

        System.out.println("Response body : "+response.body().toString());
        
        JSONArray childs=null;
        if(!response.body().toString().equals("null")) {
         childs = new JSONArray(response.body());
        }
        
        return childs;
	}

}
