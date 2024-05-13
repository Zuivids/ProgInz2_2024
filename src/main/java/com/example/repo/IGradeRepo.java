package com.example.repo;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer> {

	ArrayList<Grade> findByGrvalueLessThan(int i);

}
