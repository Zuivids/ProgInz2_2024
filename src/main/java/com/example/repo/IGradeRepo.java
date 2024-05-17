package com.example.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer> {

	ArrayList<Grade> findByGrvalueLessThan(int i);

	ArrayList<Grade> findByStudentIds(int id);
	
	
	@Query(nativeQuery = true, value = "(select avg(grvalue) from grade_table where idc=(?1);")
	float calculateAVGGradeInCourseById(int id);

}
