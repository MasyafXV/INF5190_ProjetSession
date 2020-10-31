package com.pronatation.Grade;

import java.util.ArrayList;

public class GradeBusiness {
	private GradeDAO grade = new GradeDAO();

	public GradeBusiness() {
	}

	public ArrayList<GradeDTO> getAllGrades(String CourseCode) {
		System.out.print("\nGradeBusiness getAllGrades");
		return grade.getAllGrades(CourseCode);
	}

	public void setAllGrades(String CourseCode, ArrayList<GradeDTO> listGrades) {
		System.out.print("\nGradeBusiness setAllGrades");
		grade.setAllGrades(CourseCode, listGrades);
	}
}
