package com.pronatation.Courses;

import java.util.ArrayList;

public class CourseBusiness {
	private CourseDao course = new CourseDao();

	public CourseBusiness() {
	}

	public ArrayList<CourseDTO> getAllCourses() {
		System.out.print("\nCourseBusiness getAllCourses");
		return course.getAllCourses();
	}

	public void addCourse(CourseDTO newCourse) {
		System.out.print("\nCourseBusiness addCourse");
		course.addCourse(newCourse);
	}
	

}
