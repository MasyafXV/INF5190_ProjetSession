package com.pronatation.users;

import com.pronatation.Courses.CourseDTO;
import com.pronatation.Courses.CourseDao;
import com.pronatation.processingBehavior.PersonProcessing;

public class UserBean {

	private String userName;
	private PersonProcessing processAs = PersonProcessing.Parent;

	public UserBean() {
	}

	public UserBean(String userName) {
		this.userName = userName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public boolean registerCourse(CourseDTO courseDTO) {

		System.out.println("Registering " + userName + " to " + courseDTO.getCourseCode() + "...");

		CourseDao course = new CourseDao();

		if (course.VerifyPrerequisite(userName,-1, courseDTO.getCourseLevel(), processAs)) {

			course.UserInscription(userName, courseDTO.getCourseCode());

		} else {
			System.out.println(userName + " n'a pas les prealables pour ce cours");

		}

		return false;
	}

}
