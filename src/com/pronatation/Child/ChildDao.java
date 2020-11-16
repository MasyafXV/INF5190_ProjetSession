package com.pronatation.Child;

import service.UserService;

public class ChildDao {
	

	private String ProjectPath;

	   public ChildDao() {
		   
	   }
	   
	   public boolean registerChild(String userName,String childFname, String childLname, String childAge) {
		   
			UserService uservice = new UserService(userName);
			
			uservice.addNewChild(childFname, childLname, childAge);

			   
			
			return true;

	   }
   
}
