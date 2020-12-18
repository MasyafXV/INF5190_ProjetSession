package com.pronatation.Grade;

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

public class GradeDAO {

	private String ProjectPath;
	private ArrayList<GradeDTO> listGrades;

	public ArrayList<GradeDTO> getAllGrades(String courseCode) {
		System.out.println("\nGetting all grades");

		String url = "http://localhost:8080/services/webapi/";
		String url_param = "course/getGradesForCourse/" + courseCode;

		System.out.println("\nConnection to  " + url + url_param);

		// String[] splitCourseCode = courseCode.split("-", 2);

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

		ArrayList<GradeDTO> grades = new ArrayList<>();

		JSONArray gradesJSON = new JSONArray(response.body());
		for (int i = 0; i < gradesJSON.length(); i++) {
			JSONArray studentsJSON = gradesJSON.getJSONArray(i);

			System.out.println("studentGradeJSON body : " + studentsJSON);

			String studentName = studentsJSON.getString(0);
			String studentComment = studentsJSON.getString(1);
			String studentGrade = studentsJSON.getString(2);

			grades.add(new GradeDTO(studentName, studentComment, studentGrade));

		}

		listGrades = grades;

		return listGrades;

	}

	public boolean setGrade(String courseCode, GradeDTO personGrade) {

		String url = "http://localhost:8080/services/webapi/";
		String url_param = "course/gradeStudent/";

		System.out.println("\nConnection to  " + url + url_param);

		URL post_url;
		String string = "\n" + "{\"courseCode\":\"" + courseCode + "\",\"Student\":{\"name\":\""
				+ personGrade.getPersonName() + "\",\"comments\":\"" + personGrade.getComments() + "\",\"grade\":\""
				+ personGrade.getGrade() + "\"}}";

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
		/*
		 * System.out.println("\nSetting grade of " + personGrade.getPersonName() +
		 * " in course " + courseCode);
		 * 
		 * PathManager pathManager = new PathManager(); ProjectPath =
		 * pathManager.getProjectPath();
		 * 
		 * String coursesDetailsPath = ProjectPath + "CoursesDetails/" + courseCode +
		 * ".txt";
		 * 
		 * int lineNumber; int targetLine = -1; try { FileReader readfile = new
		 * FileReader(coursesDetailsPath); BufferedReader readbuffer = new
		 * BufferedReader(readfile); for (lineNumber = 1; lineNumber < 53; lineNumber++)
		 * {
		 * 
		 * if (readFirstWord(readbuffer.readLine()).equals(personGrade.getPersonName()))
		 * { targetLine = lineNumber;
		 * 
		 * }
		 * 
		 * } } catch (IOException e) { e.printStackTrace(); }
		 * System.out.println(" The specific Line to add the course is: " + targetLine);
		 * 
		 * if (targetLine != -1) { // if swimmer is registered to course
		 * 
		 * Path path = Paths.get(coursesDetailsPath); java.util.List<String> lines =
		 * null; try { lines = Files.readAllLines(path, StandardCharsets.UTF_8); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * int position = targetLine - 1; String extraLine = personGrade.getPersonName()
		 * + "#" + personGrade.getComments().replaceAll("\r", ". ").replaceAll("\n",
		 * ". ") + "#" + personGrade.getGrade();
		 * 
		 * lines.add(position, extraLine); lines.remove(targetLine);
		 * 
		 * try { Files.write(path, lines, StandardCharsets.UTF_8); } catch (IOException
		 * e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * }
		 * 
		 * return true;
		 */
	}

	private static String readFirstWord(String line) {
		String firstWord = "";

		if (line != null) {

			String arr[] = line.split(" ", 2);

			firstWord = arr[0];

		}

		return firstWord;
	}

}
