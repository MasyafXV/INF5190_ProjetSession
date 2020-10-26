package com.pronatation.Courses;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

import com.pronatation.pathManager.PathManager;
import com.pronatation.processingBehavior.PersonProcessing;

public class CourseDao {

	private String ProjectPath;

	public CourseDao() {

	}

	public String[] getCoursesForSession(String sessionCode) { // To verify if the course already exist
		String[] coursesSession = null;

		System.out.println("Getting all courses from session " + sessionCode);

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String sessionPath = ProjectPath + "sessionCourse.txt";

		try {
			// File myObj = new File("personnes.txt");
			Scanner myReader = new Scanner(new File(sessionPath));

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

		if (targetLine != -1) { // if the user has a course

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
		}

	}

	public boolean UserInscription(String Username, String CourseLevel) {

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
			String extraLine = newline + " " + CourseLevel;

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
			String extraLine = Username + " " + CourseLevel;

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

	public boolean ChildInscription(String ChildName, String CourseLevel) {

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
			String extraLine = newline + " " + CourseLevel;

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
			String extraLine = ChildName + " " + CourseLevel;

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

	private static String readFirstWord(String line) {
		String firstWord = "";

		if (line != null) {

			String arr[] = line.split(" ", 2);

			firstWord = arr[0];

		}

		return firstWord;
	}

	public boolean VerifyPrerequisite(String Username, String course, PersonProcessing processAs) {

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
			case "Maitre_Nageur":
				// code block
				Prerequisite_Satisfied = userCourses.contains("Dauphins") && userCourses.contains("Grenouilles")
						&& userCourses.contains("Baleines") && userCourses.contains("Salamandre")
						&& userCourses.contains("Pingouins") && userCourses.contains("Tortues")
						&& userCourses.contains("Bambins") && userCourses.contains("Etoile_de_mer");

				break;
			default:
				// code block
			}

		} else if (targetLine == -1 && course.equals("Etoile_de_mer")) { // if the user has no courses
			Prerequisite_Satisfied = true;
		}

		return Prerequisite_Satisfied;
	}

}
