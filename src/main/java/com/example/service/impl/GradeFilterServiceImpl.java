package com.example.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Grade;
import com.example.repo.IGradeRepo;
import com.example.service.IGradeFilterService;

@Service
public class GradeFilterServiceImpl implements IGradeFilterService {

	@Autowired
	private IGradeRepo gradeRepo;

	@Override
	public ArrayList<Grade> selectFailedGrades() throws Exception {

		ArrayList<Grade> result = gradeRepo.findByGrvalueLessThan(4);
		if (result.isEmpty())
			throw new Exception("There is no failed grades");

		return null;
	}

	@Override
	public ArrayList<Grade> selectGradesByStudnetId(int id) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public float calculateAVGGradeCourseId(int id) throws Exception {
		// TODO Auto-generated method stub
		return 0;
	}

}
