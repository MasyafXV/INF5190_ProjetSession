package com.pronatation.Grade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

import com.pronatation.pathManager.PathManager;

public class GradeDAO {

	private String ProjectPath;
	private ArrayList<GradeDTO> listGrades;

	public ArrayList<GradeDTO> getAllGrades(String courseCode) {
		System.out.println("\nGetting all grades");

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String coursesDetailsPath = ProjectPath + "CoursesDetails/" + courseCode + ".txt";

		try {
			// File myObj = new File("personnes.txt");
			Scanner myReader = new Scanner(new File(coursesDetailsPath));
			myReader.useDelimiter("\n");

			String line = "";
			String descriptionLine = "";
			String nbPlaceLine;
			String priceLine;
			String[] grade = { " ", " ", " " };
			listGrades = new ArrayList<>();

			descriptionLine = myReader.next();
			System.out.print("\ndescriptionLine : " + descriptionLine);

			nbPlaceLine = myReader.next();
			System.out.print("\nnb Place : " + nbPlaceLine);

			priceLine = myReader.next();
			System.out.print("\nprice : " + priceLine);

			while (myReader.hasNext()) {

				line = myReader.next();
				grade = line.split("#");

				if (grade.length == 1) {
					System.out.print("\n");
					System.out.print(grade[0]);
					System.out.print("\n");
					listGrades.add(new GradeDTO(grade[0], "", ""));
				} else if (grade.length == 2) {
					System.out.print("\n");
					System.out.print(grade[0]);
					System.out.print(" ");
					System.out.print(grade[1]);
					System.out.print("\n");
					listGrades.add(new GradeDTO(grade[0], grade[1], ""));
				} else {
					System.out.print("\n");
					System.out.print(grade[0]);
					System.out.print(" ");
					System.out.print(grade[1]);
					System.out.print(" ");
					System.out.print(grade[2]);
					System.out.print("\n");
					listGrades.add(new GradeDTO(grade[0], grade[1], grade[2]));
				}

			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Le fichier est inexistant.");
			e.printStackTrace();
		}

		return listGrades;
	}

	public boolean setGrade(String courseCode, GradeDTO personGrade) {
		System.out.println("\nSetting grade of " + personGrade.getPersonName() + " in course " + courseCode);

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String coursesDetailsPath = ProjectPath + "CoursesDetails/" + courseCode + ".txt";

		int lineNumber;
		int targetLine = -1;
		try {
			FileReader readfile = new FileReader(coursesDetailsPath);
			BufferedReader readbuffer = new BufferedReader(readfile);
			for (lineNumber = 1; lineNumber < 53; lineNumber++) {

				if (readFirstWord(readbuffer.readLine()).equals(personGrade.getPersonName())) {
					targetLine = lineNumber;

				}

			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(" The specific Line to add the course is: " + targetLine);

		if (targetLine != -1) { // if swimmer is registered to course

			Path path = Paths.get(coursesDetailsPath);
			java.util.List<String> lines = null;
			try {
				lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			int position = targetLine - 1;
			String extraLine = personGrade.getPersonName() + "#"
					+ personGrade.getComments().replaceAll("\r", ". ").replaceAll("\n", ". ") + "#"
					+ personGrade.getGrade();

			lines.add(position, extraLine);
			lines.remove(targetLine);

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

}
