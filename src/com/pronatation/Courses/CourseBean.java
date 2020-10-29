package com.pronatation.Courses;

public class CourseBean {

	private String courseCode = "";
	private String sessionCode;
	private String courseLevel;
	private String description = "";
	private String NbPlace = "";
	private String Price = "";

	public CourseBean() {

	}

	public CourseBean(String courseCode) {
		this.courseCode = courseCode;
	}

	public CourseBean(String sessionCode, String courseLevel, String description) {
		this.sessionCode = sessionCode;
		this.courseLevel = courseLevel;
		this.description = description;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
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

	public String getNbPlace() {
		return NbPlace;
	}

	public void setNbPlace(String nbPlace) {
		NbPlace = nbPlace;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		Price = price;
	}

}
