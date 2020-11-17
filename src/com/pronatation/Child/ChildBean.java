package com.pronatation.Child;

import com.pronatation.Courses.CourseDTO;
import com.pronatation.Courses.CourseDao;
import com.pronatation.processingBehavior.PersonProcessing;

public class ChildBean {

	private String childFname="";
	private String child_bdate=""; 

	private PersonProcessing processAs = PersonProcessing.Child;

	public ChildBean() {

	}

	public ChildBean(String childFname,String child_bdate) {
		this.childFname = childFname;
		this.child_bdate = child_bdate;

	}

	public boolean registerCourse(CourseDTO courseDTO) {

		System.out.println("Registering " + childFname + " to " + courseDTO.getCourseCode() + "...");

		CourseDao course = new CourseDao();

		if (course.VerifyPrerequisite(childFname, child_bdate, courseDTO.getCourseLevel(), processAs)) {

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
	public String getChild_bdate() {
		return child_bdate;
	}

	public void setChild_bdate(String child_bdate) {
		this.child_bdate = child_bdate;
	}

}
