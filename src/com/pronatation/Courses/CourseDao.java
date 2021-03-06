package com.pronatation.Courses;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.pronatation.processingBehavior.PersonProcessing;

import dateManager.DateConversion;

public class CourseDao {

	private String ProjectPath;
	private ArrayList<CourseDTO> listCourses;

	public CourseDao() {

	}

	public ArrayList<CourseDTO> getAllCourses() {

		String url = "http://localhost:8080/services/webapi/";
		String url_param = "course/getAllCourses/";

		System.out.println("\nConnection to  " + url + url_param);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + url_param)).build();

		HttpResponse<String> response = null;

		response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<CourseDTO> coursesList = new ArrayList<>();

		JSONArray coursesJSON = new JSONArray(response.body());
		for (int i = 0; i < coursesJSON.length(); i++) {
			JSONObject courseJSON = coursesJSON.getJSONObject(i);
			System.out.println("json body : " + courseJSON);

			coursesList
					.add(new CourseDTO(courseJSON.getString("courseLevel"), courseJSON.getJSONArray("prerequisite")));

		}

		listCourses = coursesList;

		return listCourses;
	}

	public JSONArray getAllCoursesJSON() {

		String url = "http://localhost:8080/services/webapi/";
		String url_param = "course/getAllCourses/";

		System.out.println("\nConnection to  " + url + url_param);

		HttpClient client = HttpClient.newHttpClient();
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + url_param)).build();

		HttpResponse<String> response = null;

		response = null;
		try {
			response = client.send(request, HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return new JSONArray(response.body());

	}



	public void addCourse(CourseDTO newCourse) {
		String url = "http://localhost:8080/services/webapi/";
		String url_param = "course/createNewCourse";

		System.out.println("\nConnection to  " + url + url_param);

		URL post_url;
		String string = "{\"sessionCode\":\"" + newCourse.getSessionCode() + "\",\"courseLevel\":\""
				+ newCourse.getCourseLevel() + "\",\"description\":\"" + newCourse.getDescription()
				+ "\",\"NbPlace\":\"" + newCourse.getNbPlace() + "\",\"price\":\"" + newCourse.getPrice() + "\"}";

		try {

			JSONObject jsonObject = new JSONObject(string);

			// Step2: Now pass JSON File Data to REST Service
			try {
				post_url = new URL(url + url_param);
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

	}

	public boolean ChildInscription(String childFname, String courseCode) {
		String url = "http://localhost:8080/services/webapi/";
		String url_param = "child/ChildcourseInscription";

		System.out.println("\nConnection to  " + url + url_param);

		URL post_url;
		String string = "\n" + "{\n" + "\"inscription\": {\n" + "\"childFname\": " + childFname + ",\n"
				+ "\"course_code\": " + courseCode + "\n" + "}\n" + "}";

		try {

			JSONObject jsonObject = new JSONObject(string);

			// Step2: Now pass JSON File Data to REST Service
			try {
				post_url = new URL(url + url_param);
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

		return true;
	}

	public boolean UserInscription(String userName, CourseDTO courseDTO) {

		String url = "http://localhost:8080/services/webapi/";
		String url_param = "user/courseInscription/";

		System.out.println("\nConnection to  " + url + url_param);

		URL post_url;
		String string = "\n" + "{\n" + "\"inscription\": {\n" + "\"userName\": " + userName + ",\n"
				+ "\"course_code\": " + courseDTO.getCourseCode() + "\n" + "}\n" + "}";

		try {

			JSONObject jsonObject = new JSONObject(string);

			// Step2: Now pass JSON File Data to REST Service
			try {
				post_url = new URL(url + url_param);
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

		return true;

	}

//	public boolean ChildInscription(String childFname, String CourseLevel) {
//
//		ChildService childservice = new ChildService(childFname);
//		childservice.ChildcourseInscription(CourseLevel);
//
//		return true;
//
//	}

	private static String readFirstWord(String line) {
		String firstWord = "";

		if (line != null) {

			String arr[] = line.split(" ", 2);

			firstWord = arr[0];

		}

		return firstWord;
	}

	public boolean VerifyPrerequisite(String Username, String bdate, String courseLevel, PersonProcessing processAs) {

		System.out.println("Verification of the Prerequisite for " + courseLevel);
		boolean Prerequisite_Satisfied = false;

		ArrayList<CourseDTO> courses = getAllCourses();
		CourseDTO course = null;

		// looking for which course we want to register for
		for (CourseDTO courseDto : courses)

		{

			if (courseLevel.contains(courseDto.getCourseLevel())) {
				course = courseDto;
			}
		}
		System.out.println("print " + course.getCourseLevel());

		// the prerequisite needed to be satisfied for courseLevel
		JSONArray courseprerequisites = course.getPrerequisite();

		String Courses = "";

		int StudentAge = 0;
		DateConversion converter = new DateConversion();

		// we process as parent or child inscription?
		if (processAs == processAs.Parent) {

			String url = "http://localhost:8080/services/webapi/";
			String url_param = "user/getUserCourses/" + Username;

			System.out.println("\nConnection to  " + url + url_param);

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + url_param)).build();

			HttpResponse<String> response = null;
			try {
				response = client.send(request, HttpResponse.BodyHandlers.ofString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Courses = response.body();

			StudentAge = converter.getAgeFromBdate(bdate);

		} else if (processAs == processAs.Child) {
			String url = "http://localhost:8080/services/webapi/";
			String url_param = "child/getChildCourses/" + Username;

			System.out.println("\nConnection to  " + url + url_param);

			HttpClient client = HttpClient.newHttpClient();
			HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url + url_param)).build();

			HttpResponse<String> response = null;
			try {
				response = client.send(request, HttpResponse.BodyHandlers.ofString());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Courses = response.body();

			String child_bdate = bdate;
			StudentAge = converter.getAgeFromBdate(child_bdate);

		}

		// verifying the prerequisites
		for (Object courseprerequisite : courseprerequisites)

		{
			if (Courses.toString().contains(courseprerequisite.toString())
					&& courseprerequisite.toString().equals("Age higher than 16") == false) {
				Prerequisite_Satisfied = true;
				System.out.println("Prerequisite " + courseprerequisite.toString() + " satisfied.");

				// for maitre nageur
			} else if (courseprerequisite.toString().equals("Age higher than 16") == true && StudentAge >= 16) {
				Prerequisite_Satisfied = true;
				System.out.println("Prerequisite " + "(Age higher than 16)" + " satisfied.");
				System.out.println("Student age: " + StudentAge);

			} else {
				Prerequisite_Satisfied = false;
				System.out.println("Prerequisite " + courseprerequisite.toString() + " unsatisfied.");
				System.out.println("Student age: " + StudentAge);

			}

		}

		return Prerequisite_Satisfied;
	}

	public ArrayList<CourseDTO> getListCourses() {
		return listCourses;
	}

	public void setListCourses(ArrayList<CourseDTO> listCourses) {
		this.listCourses = listCourses;
	}

	public boolean setNewStudent(String userName, String courseLevel) {

		String url = "http://localhost:8080/services/webapi/";
		String url_param = "course/setNewStudent";

		System.out.println("\nConnection to  " + url + url_param);

		URL post_url;
		String string = "\n" + "{\n" + "\"Student\": {\n" + "\"userName\": " + userName + ",\n" + "\"courseLevel\": "
				+ courseLevel + "\n" + "}\n" + "}";

		try {

			JSONObject jsonObject = new JSONObject(string);

			// Step2: Now pass JSON File Data to REST Service
			try {
				post_url = new URL(url + url_param);
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

		return true;
	}

}
