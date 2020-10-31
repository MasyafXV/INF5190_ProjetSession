package com.pronatation.Grade;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class ListGradesAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<GradeBean> listGrades;
	private String courseCode;

	public String execute() {
		System.out.println("\nListing grades");

		GradeBusiness gradesBusiness = new GradeBusiness();

		ArrayList<GradeDTO> listGradesDTO = gradesBusiness.getAllGrades(courseCode);

		this.listGrades = new ArrayList<>();

		for (int i = 0; i < listGradesDTO.size(); i++) {
			this.listGrades.add(new GradeBean(listGradesDTO.get(i).getPersonName(), listGradesDTO.get(i).getComments(),
					listGradesDTO.get(i).getGrade()));
		}

		return SUCCESS;
	}

	public ArrayList<GradeBean> getListGrades() {
		return listGrades;
	}

	public void setListGrades(ArrayList<GradeBean> listGrades) {
		this.listGrades = listGrades;
	}

	public String getCourseCode() {
		return courseCode;
	}

	public void setCourseCode(String courseCode) {
		this.courseCode = courseCode;
	}

}
