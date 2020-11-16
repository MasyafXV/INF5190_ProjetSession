package com.pronatation.Child;

import com.pronatation.Courses.CourseDTO;
import com.pronatation.Courses.CourseDao;
import com.pronatation.processingBehavior.PersonProcessing;

public class ChildBean {

	private String childFname="";
	private int childAge=12; //ceci est un age temporaire

	private PersonProcessing processAs = PersonProcessing.Child;

	public ChildBean() {

	}

	public ChildBean(String childFname) {
		this.childFname = childFname;
	}

	public boolean registerCourse(CourseDTO courseDTO) {

		System.out.println("Registering " + childFname + " to " + courseDTO.getCourseCode() + "...");

		CourseDao course = new CourseDao();

		if (course.VerifyPrerequisite(childFname,childAge, courseDTO.getCourseLevel(), processAs)) {

			course.ChildInscription(childFname, courseDTO.getCourseCode());

		} else {
			System.out.println(childFname + " n'a pas les prealables pour ce cours");

		}

		return false;
	}

	public String getChildFname() {
		return childFname;
	}

	public void setChildFname(String childName) {
		this.childFname = childName;
	}
}
