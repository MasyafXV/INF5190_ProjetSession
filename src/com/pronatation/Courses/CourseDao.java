package com.pronatation.Courses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.pronatation.Child.ChildBean;
import com.pronatation.pathManager.PathManager;
import com.pronatation.processingBehavior.PersonProcessing;

import service.CourseService;
import service.UserService;

public class CourseDao {

	private String ProjectPath;
	private ArrayList<CourseDTO> listCourses;

	public CourseDao() {

	}

	public ArrayList<CourseDTO> getAllCourses() {
		
		CourseService cservice = new CourseService();
		cservice.getAllCourses();


    	listCourses = cservice.getAllCourses();

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
		System.out.println("\nSaving new course to :" + newCourse.getSessionCode());

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String coursesPath = ProjectPath + "sessionCourses.txt";

		String line = "";
		String newline = "";

		int lineNumber;
		int targetLine = -1;

		try {
			FileReader readfile;
			readfile = new FileReader(coursesPath);
			BufferedReader readbuffer = new BufferedReader(readfile);
			for (lineNumber = 1; lineNumber < 10; lineNumber++) {

				line = readbuffer.readLine();

				if (readFirstWord(line).equals(newCourse.getSessionCode())) {
					targetLine = lineNumber;
					newline = line;
				}
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println(" The specific Line to add the course is: " + targetLine);

		if (targetLine != -1) { // if the session exist

			Path path = Paths.get(coursesPath);
			java.util.List<String> lines = null;
			try {
				lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int position = targetLine - 1;
			String extraLine = newline + " " + newCourse.getCourseLevel();

			lines.add(position, extraLine);
			lines.remove(targetLine);

			try {
				Files.write(path, lines, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			String coursesDetailsPath = ProjectPath + "CoursesDetails/" + newCourse.getSessionCode() + "-"
					+ newCourse.getCourseLevel() + ".txt";
			System.out.print(coursesDetailsPath);
			File newCoursesDetails = new File(coursesDetailsPath);
			try {
				if (newCoursesDetails.createNewFile()) {
					FileWriter myWriter = new FileWriter(coursesDetailsPath);
					myWriter.write(newCourse.getDescription().replace("\n", "\\n"));
					myWriter.write("\n");
					myWriter.write(newCourse.getNbPlace());
					myWriter.write("\n");
					myWriter.write(newCourse.getprice());
					myWriter.write("\n");
					myWriter.close();
				} else {
					System.out.println("File already exists.");
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("File created: " + newCoursesDetails.getName());
		}

	}

	public boolean UserInscription(String Username, String CourseCode) {

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String usercoursePath = ProjectPath + "UsersCourses.txt";

		String line = "";
		String newline = "";

		int lineNumber;
		int targetLine = -1;
		try {
			FileReader readfile = new FileReader(usercoursePath);
			BufferedReader readbuffer = new BufferedReader(readfile);
			for (lineNumber = 1; lineNumber < 10; lineNumber++) {

				line = readbuffer.readLine();

				if (readFirstWord(line).equals(Username)) {
					targetLine = lineNumber;
					newline = line;

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(" The specific Line to add the course is: " + targetLine);

		if (targetLine != -1) { // if the user has a course

			Path path = Paths.get(usercoursePath);
			java.util.List<String> lines = null;
			try {
				lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int position = targetLine - 1;
			String extraLine = newline + " " + CourseCode;

			lines.add(position, extraLine);
			lines.remove(targetLine);

			try {
				Files.write(path, lines, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (targetLine == -1) { // if the user has no courses

			Path path = Paths.get(usercoursePath);
			java.util.List<String> lines = null;
			try {
				lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int position = 0;
			String extraLine = Username + " " + CourseCode;

			lines.add(position, extraLine);

			try {
				Files.write(path, lines, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		RegisterToCourse(Username, CourseCode);

		return true;

	}

	public boolean ChildInscription(String ChildName, String CourseCode) {

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String usercoursePath = ProjectPath + "ChildsCourses.txt";

		String line = "";
		String newline = "";

		int lineNumber;
		int targetLine = -1;
		try {
			FileReader readfile = new FileReader(usercoursePath);
			BufferedReader readbuffer = new BufferedReader(readfile);
			for (lineNumber = 1; lineNumber < 10; lineNumber++) {

				line = readbuffer.readLine();

				if (readFirstWord(line).equals(ChildName)) {
					targetLine = lineNumber;
					newline = line;

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(" The specific Line to add the course is: " + targetLine);

		if (targetLine != -1) { // if the user has a course

			Path path = Paths.get(usercoursePath);
			java.util.List<String> lines = null;
			try {
				lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int position = targetLine - 1;
			String extraLine = newline + " " + CourseCode;

			lines.add(position, extraLine);
			lines.remove(targetLine);

			try {
				Files.write(path, lines, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else if (targetLine == -1) { // if the user has no courses

			Path path = Paths.get(usercoursePath);
			java.util.List<String> lines = null;
			try {
				lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int position = 0;
			String extraLine = ChildName + " " + CourseCode;

			lines.add(position, extraLine);

			try {
				Files.write(path, lines, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		RegisterToCourse(ChildName, CourseCode);

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

	public boolean VerifyPrerequisite(String Username, int childAge, String course, PersonProcessing processAs) {

		System.out.println("Verification of the Prerequisite for " + course);
		boolean Prerequisite_Satisfied = false;

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String usercoursePath = "";

		if (processAs == PersonProcessing.Parent) {
			usercoursePath = ProjectPath + "UsersCourses.txt";

		} else if (processAs == PersonProcessing.Child) {
			usercoursePath = ProjectPath + "ChildsCourses.txt";
		}

		String line = "";
		String userCourses = "";

		int lineNumber;
		int targetLine = -1;
		try {
			FileReader readfile = new FileReader(usercoursePath);
			BufferedReader readbuffer = new BufferedReader(readfile);
			for (lineNumber = 1; lineNumber < 10; lineNumber++) {

				line = readbuffer.readLine();

				if (readFirstWord(line).equals(Username)) {
					targetLine = lineNumber;
					userCourses = line;

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		if (targetLine != -1) { // if the user has courses

			// Verify Prerequisite

			System.out.println(userCourses);

			switch (course) {
			case "Etoile_de_mer":
				// code block
				Prerequisite_Satisfied = true;
				break;
			case "Bambins":
				// code block
				Prerequisite_Satisfied = userCourses.contains("Etoile_de_mer");
				break;
			case "Tortues":
				// code block
				Prerequisite_Satisfied = userCourses.contains("Bambins") && userCourses.contains("Etoile_de_mer");
				break;
			case "Pingouins":
				// code block
				Prerequisite_Satisfied = userCourses.contains("Tortues") && userCourses.contains("Bambins")
						&& userCourses.contains("Etoile_de_mer");
				break;
			case "Salamandre":
				// code block
				Prerequisite_Satisfied = userCourses.contains("Pingouins") && userCourses.contains("Tortues")
						&& userCourses.contains("Bambins") && userCourses.contains("Etoile_de_mer");

				break;
			case "Baleines":
				// code block
				Prerequisite_Satisfied = userCourses.contains("Salamandre") && userCourses.contains("Pingouins")
						&& userCourses.contains("Tortues") && userCourses.contains("Bambins")
						&& userCourses.contains("Etoile_de_mer");

				break;
			case "Grenouilles":
				// code block
				Prerequisite_Satisfied = userCourses.contains("Baleines") && userCourses.contains("Salamandre")
						&& userCourses.contains("Pingouins") && userCourses.contains("Tortues")
						&& userCourses.contains("Bambins") && userCourses.contains("Etoile_de_mer");

				break;
			case "Dauphins":
				// code block
				Prerequisite_Satisfied = userCourses.contains("Grenouilles") && userCourses.contains("Baleines")
						&& userCourses.contains("Salamandre") && userCourses.contains("Pingouins")
						&& userCourses.contains("Tortues") && userCourses.contains("Bambins")
						&& userCourses.contains("Etoile_de_mer");

				break;
			case "Junior_1":
				// code block
				Prerequisite_Satisfied = userCourses.contains("Dauphins") && userCourses.contains("Grenouilles")
				&& userCourses.contains("Baleines") && userCourses.contains("Salamandre")
				&& userCourses.contains("Pingouins") && userCourses.contains("Tortues")
				&& userCourses.contains("Bambins") && userCourses.contains("Etoile_de_mer");

				break;
			case "Junior_2":
				// code block
				Prerequisite_Satisfied = userCourses.contains("Junior_1") && userCourses.contains("Dauphins") && userCourses.contains("Grenouilles")
				&& userCourses.contains("Baleines") && userCourses.contains("Salamandre")
				&& userCourses.contains("Pingouins") && userCourses.contains("Tortues")
				&& userCourses.contains("Bambins") && userCourses.contains("Etoile_de_mer");

				break;
				
			case "Junior_3":
				// code block
				Prerequisite_Satisfied =  userCourses.contains("Junior_2") && userCourses.contains("Junior_1") && userCourses.contains("Dauphins") && userCourses.contains("Grenouilles")
				&& userCourses.contains("Baleines") && userCourses.contains("Salamandre")
				&& userCourses.contains("Pingouins") && userCourses.contains("Tortues")
				&& userCourses.contains("Bambins") && userCourses.contains("Etoile_de_mer");

				break;
			case "Junior_4":
				// code block
				Prerequisite_Satisfied =  userCourses.contains("Junior_3") &&  userCourses.contains("Junior_2") && userCourses.contains("Junior_1") && userCourses.contains("Dauphins") && userCourses.contains("Grenouilles")
				&& userCourses.contains("Baleines") && userCourses.contains("Salamandre")
				&& userCourses.contains("Pingouins") && userCourses.contains("Tortues")
				&& userCourses.contains("Bambins") && userCourses.contains("Etoile_de_mer");

				break;
			case "Junior_5":
				// code block
				Prerequisite_Satisfied =  userCourses.contains("Junior_4") &&  userCourses.contains("Junior_2") && userCourses.contains("Junior_1") && userCourses.contains("Dauphins") && userCourses.contains("Grenouilles")
				&& userCourses.contains("Baleines") && userCourses.contains("Salamandre")
				&& userCourses.contains("Pingouins") && userCourses.contains("Tortues")
				&& userCourses.contains("Bambins") && userCourses.contains("Etoile_de_mer");

				break;
			case "Maitre_Nageur": // enfant doit avoir 16 ans minimum
				// code block
				Prerequisite_Satisfied = processAs == PersonProcessing.Parent || 
						 				 (processAs == PersonProcessing.Child && childAge>=16)	;

				break;
			default:
				// code block
			}

		} else if (targetLine == -1 && course.equals("Etoile_de_mer")) { // if the user has no courses
			Prerequisite_Satisfied = true;
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
			String [] session = null;
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
					System.out
							.print("\n" + i + ". user : " + user + ", courseLevel : " + coursesUser[i] + "\n");
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
