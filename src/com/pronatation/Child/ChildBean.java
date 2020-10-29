package com.pronatation.Child;

import com.pronatation.Courses.CourseDTO;
import com.pronatation.Courses.CourseDao;
import com.pronatation.processingBehavior.PersonProcessing;

public class ChildBean {

	private String childName;
	private PersonProcessing processAs = PersonProcessing.Child;

	public ChildBean() {

	}

	public ChildBean(String childName) {
		this.childName = childName;
	}

	public boolean registerCourse(CourseDTO courseDTO) {

		System.out.println("Registering " + childName + " to " + courseDTO.getCourseCode() + "...");

		CourseDao course = new CourseDao();

		if (course.VerifyPrerequisite(childName, courseDTO.getCourseLevel(), processAs)) {

			course.ChildInscription(childName, courseDTO.getCourseCode());

		} else {
			System.out.println(childName + " n'a pas les prealables pour ce cours");

		}

		return false;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}
}
