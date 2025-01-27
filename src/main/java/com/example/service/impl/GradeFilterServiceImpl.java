package com.example.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.example.model.Grade;
import com.example.repo.ICourseRepo;
import com.example.repo.IGradeRepo;
import com.example.repo.IStudentRepo;
import com.example.service.IGradeFilterService;

@Service
public class GradeFilterServiceImpl implements IGradeFilterService {

	@Autowired
	private IGradeRepo gradeRepo;

	@Autowired
	private IStudentRepo studRepo;

	@Autowired
	private ICourseRepo courseRepo;

	@Override
	public ArrayList<Grade> selectFailedGrades() throws Exception {

		ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);
		if (result.isEmpty())
			throw new Exception("There is no failed grades");

		return result;
	}

	@Override
	public ArrayList<Grade> selectGradesByStudnetId(int id) throws Exception {

		if (id < 1)
			throw new Exception("Id should be positive");
		if (!studRepo.existsById(id))
			throw new Exception("Student with " + id + " does not exist! ");

		ArrayList<Grade> result = gradeRepo.findByStudentIds(id);

		if (result.isEmpty())
			throw new Exception("There is no grade for this student!");

		return result;
	}

	@Override
	public float calculateAVGGradeCourseId(int id) throws Exception {

		if (id < 1)
			throw new Exception("Id should be positive");

		if (!courseRepo.existsById(id))
			throw new Exception("Course id does not exist! ");

		float result = gradeRepo.calculateAVGGradeInCourseById(id);

		if (result == 0)
			throw new Exception("There is no grade for this course!");

		return result;
	}

}
