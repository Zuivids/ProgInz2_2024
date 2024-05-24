package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Person;

public interface PersonRepo extends CrudRepository<Person, Integer>{

}
