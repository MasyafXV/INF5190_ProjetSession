package com.pronatation.Grade;

import java.io.File;
import java.io.FileNotFoundException;
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
				grade = line.split("\\s+");

				if (line.split("\\s+").length == 1) {
					System.out.print("\n");
					System.out.print(grade[0]);
					System.out.print("\n");
					listGrades.add(new GradeDTO(grade[0], "", ""));
				} else if (line.split("\\s+").length == 2) {
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

	public boolean setAllGrades(String courseCode, ArrayList<GradeDTO> listGrades) {
		System.out.println("\nSetting all grades");

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String coursesDetailsPath = ProjectPath + "CoursesDetails/" + courseCode + ".txt";

		try {

			Path path = Paths.get(coursesDetailsPath);
			java.util.List<String> lines = null;
			lines = Files.readAllLines(path, StandardCharsets.UTF_8);
			int j = 0;
			for (int i = 4; i < lines.size() - 1; i++) {
				lines.set(i, listGrades.get(j).getPersonName() + " " + listGrades.get(j).getComments() + " "
						+ listGrades.get(j).getGrade());
			}

			Files.write(path, lines, StandardCharsets.UTF_8);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return true;
	}

}
