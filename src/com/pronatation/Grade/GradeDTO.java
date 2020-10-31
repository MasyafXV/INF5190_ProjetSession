package com.pronatation.Grade;

public class GradeDTO {

	private String personName = "";
	private String comments = "";
	private String grade = "";

	public GradeDTO(String personName, String comments, String grade) {
		this.personName = personName;
		this.comments = comments;
		this.grade = grade;
	}

	public String getPersonName() {
		return personName;
	}

	public void setPersonName(String personName) {
		this.personName = personName;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

}
