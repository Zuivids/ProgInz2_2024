package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Course;

public interface ICourseRepo extends CrudRepository<Course, Integer>{

}
