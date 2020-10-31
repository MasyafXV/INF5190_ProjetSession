package com.pronatation.Grade;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class GradeSwimmerAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ArrayList<GradeBean> listGrades;
	private String courseCode;

	public String execute() {
		System.out.println("\nListing grades for course :" + courseCode);

		GradeBusiness gradesBusiness = new GradeBusiness();
		System.out.print("\nStill working ?");
		ArrayList<GradeDTO> listGradesDTO = new ArrayList<>();

		for (int i = 0; i < listGrades.size(); i++) {
			listGradesDTO.add(new GradeDTO(listGrades.get(i).getPersonName(), listGrades.get(i).getComments(),
					listGrades.get(i).getGrade()));
			System.out.print("\nPersonName : " + listGrades.get(i).getPersonName());
			System.out.print("\nComments : " + listGrades.get(i).getComments());
			System.out.print("\nGrade : " + listGrades.get(i).getGrade());
		}

		gradesBusiness.setAllGrades(courseCode, listGradesDTO);

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
