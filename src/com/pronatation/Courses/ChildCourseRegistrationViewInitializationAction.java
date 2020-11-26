package com.pronatation.Courses;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import com.opensymphony.xwork2.ActionSupport;
import com.pronatation.Child.ChildBean;



public class ChildCourseRegistrationViewInitializationAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4860040487301150565L;
	private ArrayList<ChildBean> childsList;
	private String userName = "";
	private ArrayList<CourseBean> coursesList;

	public String execute() {

		System.out.println("\nListing the childs of " + userName);

		String url = "http://localhost:8080/services/webapi/";
		String url_param = "user/getAllChilds/"+userName;
		
		System.out.println("\nConnection to  " + url+url_param);

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url+url_param))
                .build();

        HttpResponse<String> response = null;
		try {
			response = client.send(request,
			        HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

        System.out.println("Response body : "+response.body());
        JSONArray childs = new JSONArray(response.body());


		childsList = new ArrayList<>();

		if(childs!=null) {
			
			for (int i = 0; i < childs.length(); i++) {
				
				String childObject = childs.get(i).toString();

				childObject = childObject.replace("[", "");
				childObject= childObject.replace("]", "");
				childObject= childObject.replace(",", "");
				childObject= childObject.replace("\"\"", " ");
				childObject= childObject.replace("\"", "");


				String arr[] = childObject.split(" ", 2);

				String firstName= arr[0]; 

				String theRest = arr[1];    

				childsList.add(new ChildBean(firstName,""));
			}
		}
		
		


		System.out.println("\nListing courses");
		url = "http://localhost:8080/services/webapi/";
		url_param = "course/getAllCourses/";
		
		System.out.println("\nConnection to  " + url+url_param);
		
        client = HttpClient.newHttpClient();
        request = HttpRequest.newBuilder()
                .uri(URI.create(url+url_param))
                .build();

        response = null;
		try {
			response = client.send(request,
			        HttpResponse.BodyHandlers.ofString());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.coursesList = new ArrayList<>();

        JSONArray coursesJSON = new JSONArray(response.body());
        for (int i = 0; i < coursesJSON.length(); i++) {
        	JSONObject courseJSON= coursesJSON.getJSONObject(i);
            System.out.println("json body : "+courseJSON);
            
			this.coursesList.add(new CourseBean(courseJSON.getString("sessionCode"),
					courseJSON.getString("courseLevel"), courseJSON.getString("description")));

        }
        

		return SUCCESS;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public ArrayList<ChildBean> getChildsList() {
		return childsList;
	}

	public void setChildsList(ArrayList<ChildBean> childsList) {
		this.childsList = childsList;
	}

	public ArrayList<CourseBean> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(ArrayList<CourseBean> coursesList) {
		this.coursesList = coursesList;
	}

}
