package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Professor;

public interface IProfessorRepo extends CrudRepository<Professor,Integer>{

}
