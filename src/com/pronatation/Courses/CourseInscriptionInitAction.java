package com.pronatation.Courses;

import java.util.ArrayList;

import com.opensymphony.xwork2.ActionSupport;
import com.pronatation.Child.ChildBean;
import com.pronatation.Child.ChildDto;
import com.pronatation.users.UserDTO;

public class CourseInscriptionInitAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4860040487301150565L;
	private ArrayList<ChildBean> childsList;
	private String userName = "";
	private ArrayList<CourseBean> coursesList;

	public String execute() {

		System.out.println("\nListing childs of " + userName);

		ArrayList<ChildDto> listChildsDTO = new ArrayList<ChildDto>();
		listChildsDTO = getAllChilds();

		childsList = new ArrayList<>();

		for (int i = 1; i < listChildsDTO.size(); i++) {
			childsList.add(new ChildBean(listChildsDTO.get(i).getChild_firstname()));
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

	private ArrayList<ChildDto> getAllChilds() {

		UserDTO userDTO = new UserDTO(userName, "");

		return userDTO.getAllChilds();
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
