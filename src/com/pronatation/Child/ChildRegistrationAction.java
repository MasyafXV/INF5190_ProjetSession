package com.pronatation.Child;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

import org.json.JSONObject;


import com.opensymphony.xwork2.ActionSupport;

public class ChildRegistrationAction extends ActionSupport {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName="";
	private String child_firstname="";
    private String child_lastname="";
    private String child_bdate="";
    
 
    
    public String execute() {
    	System.out.println(userName);

        return SUCCESS;
    }
 

 
    public void validate() {
    	
		System.out.println("registration of your child " + child_firstname);
		
		String url = "http://localhost:8080/services/webapi/";
		String url_param = "user/addNewChild";
		
		System.out.println("\nConnection to  " + url+url_param);


		URL post_url;
		String string = "\n"
				+ "{\n"
				+ "    \"child\": {\n"
				+ "        \"parent_userName\": "+userName+",\n"
				+ "        \"child_firstname\": "+child_firstname+",\n"
				+ "        \"child_lastname\": "+child_lastname+",\n"
				+ "        \"child_bdate\":  "+child_bdate+"\n"
				+ "    }\n"
				+ "}";
		
		try {

			JSONObject jsonObject = new JSONObject(string);
 
			// Step2: Now pass JSON File Data to REST Service
			try {
				post_url = new URL(url+url_param);
				URLConnection connection = post_url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(jsonObject.toString());
				out.close();
 
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
 
//				while (in.readLine() != null) {
//				}
				System.out.println("\nREST Service Invoked Successfully..");
				in.close();
			} catch (Exception e) {
				System.out.println("\nError while calling REST Service");
				System.out.println(e);
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}



    	
    



	public String getChild_firstname() {
		return child_firstname;
	}



	public void setChild_firstname(String child_firstname) {
		this.child_firstname = child_firstname;
	}



	public String getChild_lastname() {
		return child_lastname;
	}



	public void setChild_lastname(String child_lastname) {
		this.child_lastname = child_lastname;
	}



	public String getChild_bdate() {
		return child_bdate;
	}



	public void setChild_bdate(String child_bdate) {
		this.child_bdate = child_bdate;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}

}
