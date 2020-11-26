package com.pronatation.Child;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;

import org.json.JSONObject;


public class ChildDao {
	

	   public ChildDao() {
		   
	   }
	   
	   public boolean registerChild(String userName,String childFname, String childLname, String child_bdate) {
		   
			String url = "http://localhost:8080/services/webapi/";
			String url_param = "user/addNewChild";
			
			System.out.println("\nConnection to  " + url+url_param);


			URL post_url;
			String string = "\n"
					+ "{\n"
					+ "    \"child\": {\n"
					+ "        \"parent_userName\": "+userName+",\n"
					+ "        \"child_firstname\": "+childFname+",\n"
					+ "        \"child_lastname\": "+childLname+",\n"
					+ "        \"child_bdate\":  "+child_bdate+"\n"
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

			   
			
			return true;

	   }
   
}
