package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Person;
import com.example.demo.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@GetMapping("/display")
	@CrossOrigin
	public Iterable<Person> display() {
		System.out.println("get a person");
		return service.prelode();
	}

	@PostMapping("/save-person")
	@CrossOrigin
	public void person(@RequestBody Person person) {

		if(person.getId() > 0) {
			System.out.println("Person successfully update");
			service.save(person);
		}else {
			System.out.println("Person successfully saved");
			service.save(person);
		}
		
	}

	@GetMapping("/remove-person/{id}")
	@CrossOrigin
	public Iterable<Person> removePerson(@PathVariable("id") int id) {
		System.out.println("person is deleted");
		return service.removeByUser(id);
	}

	@GetMapping("edit-person/{id}")
	@CrossOrigin
	public Person editPerson(@PathVariable("id") int id) {

		Person p = service.editPerson(id);
		return p;
	}
}
