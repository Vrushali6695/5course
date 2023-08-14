package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dto.ApiResponse;
import com.app.entities.Course;
import com.app.repository.CourseRepository;

@Service
@Transactional
public class CourseServiceImpl implements  CourseService {
	
	@Autowired
	private CourseRepository courserepo;

	@Override
	public List<Course> getAllCourses() {
		// TODO Auto-generated method stub
		return courserepo.findAll();
	}

	@Override
	public ApiResponse addCourseDetail(Course transientCourse) {
		String msg="Adding course Failed";
		Course course=courserepo.save(transientCourse);
		if(course != null)
		{
			msg="Course added Successflly";
		}
		return new ApiResponse(msg);
	}

	@Override
	public ApiResponse updateCourse(Course detachedCourse) {
		String msg="Updating Course  Failed";
		Course course=courserepo.save(detachedCourse);
		if(course != null)
		{
			msg="Course details updated Successflly";
		}
		return new ApiResponse(msg);
	}

	@Override
	public String removeCourse(Long id) {
		String mesg="Id invalid cannot delete record";
		if(courserepo.existsById(id))
		{
			courserepo.deleteById(id);
			mesg="Deleted Successfully";
		}
		
		return mesg;
	
	}

	@Override
	public Course getCourseById(Long id) {
		// TODO Auto-generated method stub
		return courserepo.findById(id).orElse(null);
	}
	
	
}
