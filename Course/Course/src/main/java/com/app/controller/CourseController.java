package com.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.entities.Course;
import com.app.service.CourseService;

@RestController
@RequestMapping("/bus")
public class CourseController {
	
	@Autowired
	private CourseService courseService;
	
	public CourseController() {
		System.out.println("in ctor of "+getClass());
	}
	
	@GetMapping
	public List<Course> showAllCoursees()
	{
		return courseService.getAllCourses();
	}
	
	@PostMapping
	public ResponseEntity<?> addCourse(@RequestBody Course transientCourse)
	{
		return new ResponseEntity<>(courseService.addCourseDetail(transientCourse),HttpStatus.CREATED);
	}
	
	

	@PutMapping()
	public ResponseEntity<?> updateCourse(@RequestBody Course detachedCourse)
	{
		return new ResponseEntity<>(courseService.updateCourse(detachedCourse),HttpStatus.CREATED);
	}
	
	 @GetMapping("/{id}")
	    public Course getCourseById(@PathVariable Long id) {
	        return courseService.getCourseById(id);
	    }
	
	
	@DeleteMapping("/{id}")
	public String deleteCourse(@PathVariable Long id)
	{
		return courseService.removeCourse(id);
	}
	

}
