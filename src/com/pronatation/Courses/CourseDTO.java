package com.pronatation.Courses;

public class CourseDTO {
	

	String courseLevel;
	
	
	public CourseDTO (String courseLevel) {
		this.courseLevel=courseLevel;
	}
	

	public String getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}



}