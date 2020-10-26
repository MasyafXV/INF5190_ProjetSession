package com.pronatation.Courses;

public class CourseBean {

	private String sessionCode;
	private String courseLevel;
	private String description = "";

	public CourseBean() {

	}

	public CourseBean(String courseLevel) {
		this.courseLevel = courseLevel;
	}

	public CourseBean(String sessionCode, String courseLevel, String description) {
		this.sessionCode = sessionCode;
		this.courseLevel = courseLevel;
		this.description = description;
	}

	public String getCourseLevel() {
		return courseLevel;
	}

	public void setCourseLevel(String courseLevel) {
		this.courseLevel = courseLevel;
	}

	public String getSessionCode() {
		return sessionCode;
	}

	public void setSessionCode(String sessionCode) {
		this.sessionCode = sessionCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
