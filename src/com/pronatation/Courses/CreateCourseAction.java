package com.pronatation.Courses;

import com.opensymphony.xwork2.ActionSupport;

public class CreateCourseAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private CourseBean newCourse;

	public String execute() {
		System.out.print("createCourseAction check\n");

		CourseBusiness courseBusiness = new CourseBusiness();

		CourseDTO courseDTO = new CourseDTO(newCourse.getSessionCode(), newCourse.getCourseLevel(),
				newCourse.getDescription(), newCourse.getNbPlace(), newCourse.getPrice());

		courseBusiness.addCourse(courseDTO);

		return SUCCESS;
	}

	public CourseBean getNewCourse() {
		return newCourse;
	}

	public void setNewCourse(CourseBean newCourse) {
		this.newCourse = newCourse;
	}

}
