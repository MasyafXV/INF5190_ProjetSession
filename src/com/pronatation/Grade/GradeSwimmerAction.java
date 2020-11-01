package com.pronatation.Grade;

import com.opensymphony.xwork2.ActionSupport;

public class GradeSwimmerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String courseCode;
	private String personName;
	private String comments;
	private String grade;

	public String execute() {
		System.out.println("\nListing grades for course :" + courseCode);
		System.out.print("\npersonName : " + personName);
		System.out.print("\ncomments : " + comments);
		System.out.print("\ngrade : " + grade);

		GradeBusiness gradesBusiness = new GradeBusiness();
		GradeDTO personGradeDTO = new GradeDTO(personName, comments, grade);

		gradesBusiness.setGrade(courseCode, personGradeDTO);
		return SUCCESS;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
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
