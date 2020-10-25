package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.model.Person;

public interface UserRepository extends CrudRepository<Person, Integer>{

	public Iterable<Person> deleteByid(int id);
	
	public Person findById(int id);
	
	//public Person update(Person person);
}
