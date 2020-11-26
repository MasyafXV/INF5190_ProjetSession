package com.pronatation.Courses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import org.json.JSONArray;
import org.json.JSONObject;

import com.pronatation.pathManager.PathManager;
import com.pronatation.processingBehavior.PersonProcessing;

import dateManager.DateConversion;
import service.ChildService;
import service.CourseService;
import service.UserService;

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

	public String[] getCoursesForSession(String sessionCode) { // To verify if the course already exist
		String[] coursesSession = null;

		System.out.println("Getting all courses from session " + sessionCode);

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String sessionCoursesPath = ProjectPath + "sessionCourse.txt";

		try {
			// File myObj = new File("personnes.txt");
			Scanner myReader = new Scanner(new File(sessionCoursesPath));

			String coursesLine;

			while (myReader.hasNextLine()) {
				coursesLine = myReader.nextLine();

				if (readFirstWord(coursesLine).equals(sessionCode)) {
					coursesSession = coursesLine.split("\\s+");
				}
			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Le fichier est inexistant.");
			e.printStackTrace();
		}

		return coursesSession;

	}

	public void addCourse(CourseDTO newCourse) {
		CourseService cservice = new CourseService();
		cservice.createCourse(newCourse);

	}

	public boolean UserInscription(String userName, CourseDTO courseDTO) {

		String url = "http://localhost:8080/services/webapi/";
		String url_param = "user/courseInscription/";

		System.out.println("\nConnection to  " + url + url_param);

		URL post_url;
		String string = "\n" + "{\n" + "    \"inscription\": {\n" + "        \"userName\": " + userName + ",\n"
				+ "        \"course_code\": " + courseDTO.getCourseCode() + "\n" + "    }\n" + "}";

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

	public boolean ChildInscription(String childFname, String CourseLevel) {

		ChildService childservice = new ChildService(childFname);
		childservice.ChildcourseInscription(CourseLevel);

		return true;

	}

	private static String readFirstWord(String line) {
		String firstWord = "";

		if (line != null) {

			String arr[] = line.split(" ", 2);

			firstWord = arr[0];

		}

		return firstWord;
	}

	public boolean VerifyPrerequisite(String Username, String child_bdate, String courseLevel,
			PersonProcessing processAs) {

		System.out.println("Verification of the Prerequisite for " + courseLevel);
		boolean Prerequisite_Satisfied = false;
		String UserBdate = "1998-09-15";

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

		ArrayList<Object> Courses = new ArrayList<Object>();

		int StudentAge = 0;
		DateConversion converter = new DateConversion();

		// we process as parent or child inscription?
		if (processAs == processAs.Parent) {
			UserService uService = new UserService(Username);
			Courses = uService.getUserCourses();
			StudentAge = converter.getAgeFromBdate(UserBdate);

		} else if (processAs == processAs.Child) {
			ChildService cService = new ChildService(Username);
			Courses = cService.getChildCourses();
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

	public boolean RegisterToCourse(String PersonName, String courseCode) {
		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String coursesDetailsPath = ProjectPath + "CoursesDetails/" + courseCode + ".txt";
		System.out.print(coursesDetailsPath);

		String line = "";
		String newline = "";

		int lineNumber;
		int targetLine = -1;

		try {
			FileReader readfile = new FileReader(coursesDetailsPath);
			BufferedReader readbuffer = new BufferedReader(readfile);
			for (lineNumber = 1; lineNumber < 10; lineNumber++) {

				line = readbuffer.readLine();

				if (readFirstWord(line).equals(PersonName)) {
					targetLine = lineNumber;
					newline = line;

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(" The specific Line to add the course is: " + targetLine);

		if (targetLine == -1) { // if the person isn't already register for this course

			Path path = Paths.get(coursesDetailsPath);
			java.util.List<String> lines = null;
			try {
				lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int position = lines.size();
			String extraLine = PersonName + " ";

			lines.add(position, extraLine);

			try {
				Files.write(path, lines, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	public ArrayList<CourseDTO> getUserCourses() {
		System.out.println("\nGetting User courses");

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String usersCoursesPath = ProjectPath + "UsersCourses.txt";

		try {
			// File myObj = new File("personnes.txt");
			Scanner myReader = new Scanner(new File(usersCoursesPath));

			String coursesLine;
			String user;
			String[] session = null;
			String[] coursesUser = null;
			listCourses = new ArrayList<>();

			while (myReader.hasNextLine()) {
				coursesLine = myReader.nextLine();
				System.out.print("\ncourseLine : " + coursesLine);
				user = readFirstWord(coursesLine);
				System.out.print("\nuser : " + user);
				coursesUser = coursesLine.replaceFirst(user + " ", "").split("\\s+");
				System.out.print("\nlength courses : " + coursesUser.length);

				for (int i = 0; i < coursesUser.length; i++) {
					System.out.print("\n" + i + ". user : " + user + ", courseLevel : " + coursesUser[i] + "\n");
					listCourses.add(new CourseDTO(user, coursesUser[i]));
				}

			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Le fichier est inexistant.");
			e.printStackTrace();
		}

		return listCourses;
	}

	public ArrayList<CourseDTO> getListCourses() {
		return listCourses;
	}

	public void setListCourses(ArrayList<CourseDTO> listCourses) {
		this.listCourses = listCourses;
	}

}
