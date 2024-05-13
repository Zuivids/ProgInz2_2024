package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Grade;

public interface IGradeRepo extends CrudRepository<Grade, Integer> {

}
