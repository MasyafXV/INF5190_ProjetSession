package com.pronatation.Courses;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.pronatation.Child.ChildBean;


import service.UserService;

public class CourseInscriptionInitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4860040487301150565L;
	private ArrayList<ChildBean> childsList;
	private String userName = "";
	private ArrayList<CourseBean> coursesList;

	public String execute() {

		System.out.println("\nListing the childs of " + userName);
		UserService uservice = new UserService(userName);
    	ArrayList<Object> childs =uservice.getAllChilds();

		childsList = new ArrayList<>();

		if(childs!=null) {
			
			for (int i = 0; i < childs.size(); i++) {
				
				String childObject = childs.get(i).toString();
				
				childObject = childObject.replace("[", "");
				childObject= childObject.replace("]", "");
				childObject= childObject.replace(",", "");


				String arr[] = childObject.split(" ", 2);

				String firstName= arr[0];   
				String theRest = arr[1];    

				childsList.add(new ChildBean(firstName));
			}
		}
		
		


		System.out.println("\nListing courses");

		CourseBusiness courseBusiness = new CourseBusiness();

		ArrayList<CourseDTO> listCoursesDTO = courseBusiness.getAllCourses();

		this.coursesList = new ArrayList<>();

		for (int i = 0; i < listCoursesDTO.size(); i++) {
			this.coursesList.add(new CourseBean(listCoursesDTO.get(i).getSessionCode(),
					listCoursesDTO.get(i).getCourseLevel(), listCoursesDTO.get(i).getDescription()));
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
