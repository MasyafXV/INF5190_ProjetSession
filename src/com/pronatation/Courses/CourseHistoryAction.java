package com.pronatation.Courses;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;

public class CourseHistoryAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8109917321479821460L;
	private String userName = "";
	private ArrayList<CourseBean> coursesList;
	
	public String execute() {
	
//	System.out.println("\nListing courses");
//
//	CourseBusiness courseBusiness = new CourseBusiness();
//
//	ArrayList<CourseDTO> listCoursesDTO = courseBusiness.getUserCourses();
//
//	this.coursesList = new ArrayList<>();
//
//	for (int i = 0; i < listCoursesDTO.size(); i++) {
//		this.coursesList.add(new CourseBean(listCoursesDTO.get(i).getSessionCode(),
//				listCoursesDTO.get(i).getCourseLevel(), listCoursesDTO.get(i).getDescription()));
//	}

	return SUCCESS;
}
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public ArrayList<CourseBean> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(ArrayList<CourseBean> coursesList) {
		this.coursesList = coursesList;
	}

}
