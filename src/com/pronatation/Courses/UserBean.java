package com.pronatation.Courses;

public class UserBean {
	
	private String userName;


	public UserBean() {
	}
	
	public UserBean(String userName) {
		this.userName=userName;
	}

	
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public boolean registerCourse(CourseDTO courseDTO) {
		
		System.out.println("Registering "+userName+ " to "+courseDTO.getCourseLevel()+"...");
		
		CourseDao course = new CourseDao();
		
		course.UserInscription(userName, courseDTO.getCourseLevel());
		
		
		return false;
	}

}
