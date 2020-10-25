package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.model.Person;
import com.example.demo.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repo;
	
	public List<Person> prelode() {
		
		return (List<Person>) repo.findAll();
	}
	public void save(Person person) {
		repo.save(person);
	}

	/*
	 * public void update(Person person) { repo.update(person); }
	 */
	@Transactional
	public Iterable<Person> removeByUser(int id) {
		return repo.deleteByid(id);
	}
	@Transactional
	public Person editPerson(int id){
		return repo.findById(id);
	}
}
