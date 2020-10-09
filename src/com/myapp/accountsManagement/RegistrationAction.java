package com.myapp.accountsManagement;

import java.io.IOException;

import com.opensymphony.xwork2.ActionSupport;

public class RegistrationAction  extends ActionSupport{
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName="";
    private String password="";
	private String firstname="";
    private String lastname="";
	private String email="";
    private String adress="";
	private String bdate="";
 
    public String execute() {
        return SUCCESS;
    }
 
   
    public String getUserName() {
        return userName;
    }
 
    public void setUserName(String userName) {
        this.userName = userName;
    }
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }

	public String getFirstname() {
		return firstname;
	}


	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}


	public String getLastname() {
		return lastname;
	}


	public void setLastname(String lastname) {
		this.lastname = lastname;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getAdress() {
		return adress;
	}


	public void setAdress(String adress) {
		this.adress = adress;
	}


	public String getBdate() {
		return bdate;
	}


	public void setBdate(String bdate) {
		this.bdate = bdate;
	}
	
    public void validate() {
    	
    	try {
			if(RegistrationDao.RegisterUser(userName, password,firstname,lastname,email,adress,bdate)){
//            addFieldError("userName", "Invalid User !!!");
				RegistrationDao.addUserToDatabase(userName, password);
			}
			else{
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

}
