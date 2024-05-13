package com.example.service;

import java.util.ArrayList;

import com.example.model.Course;

public interface ICourseFilterService {

	ArrayList<Course> selectCoursesByCreditPoinrs(int creditpoints) throws Exception;
	
	Course selectCourseByProfessorId(int id) throws Exception;
	
	ArrayList<Course> selectCoursesByStudentId(int id) throws Exception;
	
	
}
