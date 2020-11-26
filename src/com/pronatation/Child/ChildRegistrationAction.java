package com.pronatation.Child;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
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
		String url_param = "user/addNewChild/"+userName+"/"+child_firstname+"/"+child_lastname+"/"+child_bdate;
		
		System.out.println("\nConnection to  " + url+url_param);
		
		URL post_url;
		try {
			post_url = new URL ( url+url_param);
			HttpURLConnection con = (HttpURLConnection)post_url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			con.disconnect();
			System.out.println(child_firstname+" Have been successfully registered ");



		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
