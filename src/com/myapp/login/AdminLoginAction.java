package com.myapp.login;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
 
public class AdminLoginAction extends ActionSupport {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String userName="";
    private String password="";
 
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
 
    public void validate() {
    	LoginDao loginDao= new LoginDao();

    	if(loginDao.validateAdmin(userName, password)==false){
            addFieldError("userName", "Invalid User, Try again");
    	}
    	else{
    		 Map<String,Object> session = ActionContext.getContext().getSession();
    		 session.put("userName", userName);
    	}
    	
    }
}