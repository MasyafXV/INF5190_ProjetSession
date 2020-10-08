package com.myapp.login;

public class LoginDao  {
	
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
