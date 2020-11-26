package com.pronatation.Child;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

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
		ChildDao childDao = new ChildDao();
		childDao.registerChild(userName, child_firstname, child_lastname, child_bdate);
		

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
