package com.pronatation.users;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;

import com.pronatation.Courses.CourseDTO;
import com.pronatation.Courses.CourseDao;
import com.pronatation.processingBehavior.PersonProcessing;

public class UserBean {

	private String userName;
	private String userBdate;

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
	public String getUserBdate() {
		return userBdate;
	}

	public void setUserBdate(String userBdate) {
		this.userBdate = userBdate;
	}

	public boolean registerCourse(CourseDTO courseDTO) {

		System.out.println("Registering " + userName + " to " + courseDTO.getCourseCode() + "...");
		CourseDao course = new CourseDao();

		
		if (course.VerifyPrerequisite(userName, userBdate, courseDTO.getCourseLevel(), processAs)) {

			course.UserInscription(userName, courseDTO);
			System.out.println(userName + " a ete inscrit pour "+courseDTO.getCourseLevel());


		} else {
			System.out.println(userName + " n'a pas les prealables pour ce cours");

		}
		return false;
	}

}
