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

	public void setGrade(String CourseCode, GradeDTO personGrade) {
		System.out.print("\nGradeBusiness setGrade for " + personGrade.getPersonName() + " in course " + CourseCode);
		grade.setGrade(CourseCode, personGrade);
	}
}
