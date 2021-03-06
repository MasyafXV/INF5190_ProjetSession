package com.pronatation.Courses;

import org.json.JSONArray;

public class CourseDTO {

	private String courseCode = "";
	private String sessionCode = "";
	private String courseLevel = "";
	private String description = "";
	private String NbPlace = "";
	private String price = "";
	private JSONArray prerequisite = null;

	public CourseDTO(String courseLevel, JSONArray jsonArray) {
		this.courseLevel = courseLevel;
		this.prerequisite = jsonArray;
	}

	public CourseDTO(String sessionCode, String courseLevel, String description, String NbPlace, String price,
			JSONArray prerequisite) {
		this.sessionCode = sessionCode;
		this.courseLevel = courseLevel;
		this.description = description;
		this.NbPlace = NbPlace;
		this.price = price;
		this.prerequisite = prerequisite;
	}

	public CourseDTO(String sessionCode, String courseLevel) {
		this.sessionCode = sessionCode;
		this.courseLevel = courseLevel;

	}

	public CourseDTO(String courseCode, String sessionCode, String courseLevel) {
		this.courseCode = courseCode;
		this.sessionCode = sessionCode;
		this.courseLevel = courseLevel;
	}

	public CourseDTO(String sessionCode, String courseLevel, String description, String NbPlace, String price) {
		this.sessionCode = sessionCode;
		this.courseLevel = courseLevel;
		this.description = description;
		this.NbPlace = NbPlace;
		this.price = price;
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
		return this.price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public JSONArray getPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(JSONArray prerequisite) {
		this.prerequisite = prerequisite;
	}

}
