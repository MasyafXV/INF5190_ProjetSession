package com.pronatation.Session;

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
import java.text.ParseException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONObject;

public class SessionDAO {

	private ArrayList<SessionDTO> sessions = new ArrayList<>();

	public SessionDAO() {

	}

	public int size() {
		return sessions.size();
	}

	public ArrayList<SessionDTO> getSessions() throws ParseException {
		String url = "http://localhost:8080/services/webapi/";
		String url_param = "session/getSessions/";

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

		ArrayList<SessionDTO> sessionsList = new ArrayList<>();

		JSONArray sessionsJSON = new JSONArray(response.body());
		for (int i = 0; i < sessionsJSON.length(); i++) {
			JSONObject sessionJSON = sessionsJSON.getJSONObject(i);
			System.out.println("json body : " + sessionJSON);
			sessionsList.add(new SessionDTO(sessionJSON.getString("code"), sessionJSON.getString("season"),
					sessionJSON.getString("year"), DateBDToStringDate(sessionJSON.getString("sessionFrom")),
					DateBDToStringDate(sessionJSON.getString("sessionTo"))));

		}

		sessions = sessionsList;

		return sessions;
	}

	public String DateBDToStringDate(String DateBD) throws DateTimeParseException {
		LocalDateTime ldt = LocalDateTime.parse(DateBD,
				DateTimeFormatter.ofPattern("MMM d, uuuu, hh:mm:ss a", Locale.ENGLISH));
		String strDate = ldt.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		return strDate;
	}

	public void addSession(SessionDTO session) {

		String url = "http://localhost:8080/services/webapi/";
		String url_param = "session/createNewSession";

		System.out.println("\nConnection to  " + url + url_param);

		URL post_url;
		String string = "{\"sessionCode\":\"" + session.getCode() + "\",\"season\":\"" + session.getSeason()
				+ "\",\"year\":\"" + session.getYear() + "\",\"sessionFrom\":\"" + session.getSessionFrom()
				+ "\",\"sessionTo\":\"" + session.getSessionTo() + "\"}";

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

	public void DeleteSession(SessionDTO session) {
		sessions.remove(session);
	}

}
