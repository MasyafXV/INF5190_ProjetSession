package com.pronatation.Courses;

public class CourseBusiness {
	private CourseDao course = new CourseDao();

	public CourseBusiness() {
	}

	public void addCourse(CourseDTO newCourse) {
		System.out.print("\nCourseBusiness addCourse");
		course.addCourse(newCourse);
	}

}
