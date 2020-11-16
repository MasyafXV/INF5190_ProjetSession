package com.pronatation.Courses;

import com.opensymphony.xwork2.ActionSupport;
import com.pronatation.Child.ChildBean;
import com.pronatation.users.UserBean;

public class CourseInscriptionAction extends ActionSupport {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String userName = "";
	private String childName = "";
	private String CourseLevel;

	private boolean childInscription = false;
	private boolean UserInscription = false;

	private CourseBean course;
	private UserBean user;
	private ChildBean child;

	public String execute() {
		System.out.println("courseInscription");

		String courseCode = course.getCourseCode();
		String[] partsCourseCode = courseCode.split("-");
		course.setSessionCode(partsCourseCode[0]);
		course.setCourseLevel(partsCourseCode[1]);

		userName = user.getUserName();
		CourseDTO courseDTO = new CourseDTO(course.getCourseCode(), course.getSessionCode(), course.getCourseLevel());

		if (UserInscription) {

			// register the user to the selected course
			user.registerCourse(courseDTO);

		} else if (childInscription) {

			System.out.println("Child Inscription...");
			System.out.println("username : " + user.getUserName());
			System.out.println("child : " + child.getChildFname());
			System.out.println("course : " + course.getCourseCode());

			// register the child to the selected course
			child.registerCourse(courseDTO);
		}

		return SUCCESS;
	}

	public void validate() {

		if (UserInscription) {

		} else if (childInscription) {

		}

	}

	public CourseBean getCourse() {
		return course;
	}

	public void setCourse(CourseBean course) {
		this.course = course;
	}

	public UserBean getUser() {
		return user;
	}

	public void setUser(UserBean user) {
		this.user = user;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public boolean isChildInscription() {
		return childInscription;
	}

	public void setChildInscription(boolean childInscription) {
		this.childInscription = childInscription;
	}

	public boolean isUserInscription() {
		return UserInscription;
	}

	public void setUserInscription(boolean userInscription) {
		UserInscription = userInscription;
	}

	public String getCourseLevel() {
		return CourseLevel;
	}

	public void setCourseLevel(String courseLevel) {
		CourseLevel = courseLevel;
	}

	public ChildBean getChild() {
		return child;
	}

	public void setChild(ChildBean child) {
		this.child = child;
	}

}
