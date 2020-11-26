package com.pronatation.users;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

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
		String url = "http://localhost:8080/services/webapi/";
		String url_param = "user/courseInscription/"+userName+"/"+courseDTO.getCourseCode();
		
		System.out.println("\nConnection to  " + url+url_param);
		
		URL post_url;
		try {
			post_url = new URL ( url+url_param);
			HttpURLConnection con = (HttpURLConnection)post_url.openConnection();
			con.setRequestMethod("POST");
			con.setRequestProperty("Content-Type", "application/json; utf-8");
			con.setRequestProperty("Accept", "application/json");
			con.setDoOutput(true);
			con.disconnect();
			System.out.println(userName+" Have been successfully registered to  "+ courseDTO.getCourseCode());



		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		CourseDao course = new CourseDao();
//
//		if (course.VerifyPrerequisite(userName,"", courseDTO.getCourseLevel(), processAs)) {
//
//			course.UserInscription(userName, courseDTO.getCourseCode());
//
//		} else {
//			System.out.println(userName + " n'a pas les prealables pour ce cours");
//
//		}

		return false;
	}

}
