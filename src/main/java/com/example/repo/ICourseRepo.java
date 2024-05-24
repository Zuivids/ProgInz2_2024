package com.example.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

	ArrayList<Course> findByCreditPoints(int creditpoints);

	Course findByProfessorIdpe(int id);

	ArrayList<Course> findByGradesStudentIdpe(int id);

}
