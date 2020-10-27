package com.pronatation.Session;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import com.pronatation.pathManager.PathManager;

public class SessionDAO {

	private String ProjectPath;
	private ArrayList<SessionDTO> sessions = new ArrayList<>();

	public SessionDAO() {

	}

	public int size() {
		return sessions.size();
	}

	public ArrayList<SessionDTO> getSessions() {
		System.out.println("\nGetting all sessions");

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String sessionPath = ProjectPath + "session.txt";

		try {
			// File myObj = new File("personnes.txt");
			Scanner myReader = new Scanner(new File(sessionPath));

			String session;

			while (myReader.hasNextLine()) {
				session = myReader.nextLine();

				String[] sessionParameters = session.split("\\s+");

				sessions.add(new SessionDTO(sessionParameters[0], sessionParameters[1], sessionParameters[2],
						sessionParameters[3], sessionParameters[4]));

			}
			myReader.close();

		} catch (FileNotFoundException e) {
			System.out.println("Le fichier est inexistant.");
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return sessions;
	}

	public void addSession(SessionDTO session) {
		System.out.println("\nSaving new sessions");

		PathManager pathManager = new PathManager();
		ProjectPath = pathManager.getProjectPath();

		String sessionPath = ProjectPath + "session.txt";

		try {
			File file = new File(sessionPath);
			FileOutputStream fos = new FileOutputStream(file, true);

			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));

			bw.newLine();
			bw.write(session.getCode());
			bw.write(" ");
			bw.write(session.getSeason());
			bw.write(" ");
			bw.write(session.getYear());
			bw.write(" ");
			bw.write(session.getSessionFrom());
			bw.write(" ");
			bw.write(session.getSessionTo());
			bw.write(" ");

			bw.close();

		} catch (Exception e) {
			System.out.print("Error adding Session");
		}

	}

	public void DeleteSession(SessionDTO session) {
		sessions.remove(session);
	}

}
