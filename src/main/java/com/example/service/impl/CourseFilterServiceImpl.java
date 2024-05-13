package com.example.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Course;
import com.example.repo.ICourseRepo;
import com.example.repo.IProfessorRepo;
import com.example.repo.IStudentRepo;
import com.example.service.ICourseFilterService;

@Service
public class CourseFilterServiceImpl implements ICourseFilterService {

	@Autowired
	private ICourseRepo courseRepo;
	@Autowired
	private IProfessorRepo profRepo;
	@Autowired
	private IStudentRepo studRepo;

	@Override
	public ArrayList<Course> selectCoursesByCreditPoinrs(int creditpoints) throws Exception {
		if (creditpoints < 1 || creditpoints > 20)
			throw new Exception("Problems with input args!");

		ArrayList<Course> result = courseRepo.findByCreditpoints(creditpoints);
		if (result.isEmpty())
			throw new Exception("Empty set!");

		return result;
	}

	@Override
	public Course selectCourseByProfessorId(int id) throws Exception {
		if (id < 1)
			throw new Exception("ID should be positive!");
		if (!profRepo.existsById(id))
			throw new Exception("Professor with this id does not exist!");
		Course result = courseRepo.finByProfessorIdp(id);
		if (result == null)
			throw new Exception("There is no course linkage to this Professor");
		return result;
	}

	@Override
	public ArrayList<Course> selectCoursesByStudentId(int id) throws Exception {
		if (id < 1)
			throw new Exception("ID should be positive!");
		if (!studRepo.existsById(id))
			throw new Exception("Student with this id does not exist!");
		
		ArrayList<Course> result = courseRepo.findByGradesStudentIds(id);
		
		if(result.isEmpty()) throw new Exception("There is no course linkage to this Student!");
		
		return result;
	}

}
