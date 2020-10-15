package com.pronatation.Courses;

public class CourseBean {
	
	private String courseLevel;
	
	public CourseBean() {
		
	}
	
	public CourseBean(String courseLevel) {
		this.courseLevel=courseLevel;
	}

	public String getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}


}
