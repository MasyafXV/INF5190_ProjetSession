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
		String url_param = "user/courseInscription/";
		
		System.out.println("\nConnection to  " + url+url_param);
		
		URL post_url;
		String string = "\n"
				+ "{\n"
				+ "    \"inscription\": {\n"
				+ "        \"userName\": "+userName+",\n"
				+ "        \"course_code\": "+courseDTO.getCourseCode()+"\n"
				+ "    }\n"
				+ "}";
		
		try {

			JSONObject jsonObject = new JSONObject(string);
 
			// Step2: Now pass JSON File Data to REST Service
			try {
				post_url = new URL(url+url_param);
				URLConnection connection = post_url.openConnection();
				connection.setDoOutput(true);
				connection.setRequestProperty("Content-Type", "application/json");
				connection.setConnectTimeout(5000);
				connection.setReadTimeout(5000);
				OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream());
				out.write(jsonObject.toString());
				out.close();
 
				BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
 
				while (in.readLine() != null) {
				}
				System.out.println("\nREST Service Invoked Successfully..");
				in.close();
			} catch (Exception e) {
				System.out.println("\nError while calling REST Service");
				System.out.println(e);
			}
 
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}
