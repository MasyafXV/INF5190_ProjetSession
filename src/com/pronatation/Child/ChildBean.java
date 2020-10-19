package com.pronatation.Child;

import com.pronatation.Courses.CourseDTO;
import com.pronatation.Courses.CourseDao;

public class ChildBean {

	private String childName;


	public ChildBean() {
		
	}
	
	public ChildBean(String childName) {
		this.childName=childName;
	}

	
	
	public boolean registerCourse(CourseDTO courseDTO) {
		
		System.out.println("Registering "+childName+ " to "+courseDTO.getCourseLevel()+"...");
		
		CourseDao course = new CourseDao();
		
		course.ChildInscription(childName, courseDTO.getCourseLevel());
		
		
		return false;
	}




	public String getChildName() {
		return childName;
	}




	public void setChildName(String childName) {
		this.childName = childName;
	}
}
