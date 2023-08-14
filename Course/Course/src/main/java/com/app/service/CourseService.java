package com.app.service;

import java.util.List;


import com.app.dto.ApiResponse;
import com.app.entities.Course;


public interface CourseService {
	
	//get
	List<Course> getAllCourses();

	//add
	ApiResponse addCourseDetail(Course transientCourse);

	//update
	ApiResponse updateCourse(Course detachedCourse);
	
	//delete by id
	String removeCourse(Long id);

	//get course by id
	Course getCourseById(Long id);
	
	

}
