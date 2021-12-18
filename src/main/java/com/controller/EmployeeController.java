package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.NeedyPeople;
import com.service.IEmployeeService;

@RestController
@RequestMapping(path="/needy")
@CrossOrigin
public class EmployeeController {
	
	@Autowired
	private IEmployeeService empService;
	
	// add needy person
	@PostMapping("/add")
	public ResponseEntity<NeedyPeople> addNeedyPerson(@RequestBody NeedyPeople person) {
		NeedyPeople p=empService.addNeedyPerson(person);
		return new ResponseEntity<>(p,HttpStatus.CREATED);
	}
	
	//delete needy person
	@DeleteMapping(path="/delete/{id}")
	public ResponseEntity<String> deleteNeedyPerson(@PathVariable("id")  int id) {
		empService.removeNeedyPerson(id);
		ResponseEntity re=new ResponseEntity<String>("Deleted",HttpStatus.OK);
		return re;
	}
	
	//update needy person
	@PutMapping(path = "/update/{id}")
	public ResponseEntity<NeedyPeople> modifyNeedyPerson(@PathVariable("id") int id,@RequestBody NeedyPeople person) {
		NeedyPeople p = empService.modifyNeedyPerson(id, person);

		ResponseEntity<NeedyPeople> re = new ResponseEntity<NeedyPeople>(p, HttpStatus.OK);
		return re;
	}

	//find needy person by id
	@GetMapping(path="/get/{id}")
	public ResponseEntity<NeedyPeople> getNeedyPeopleById(@PathVariable("id")  int id) {
		NeedyPeople p=empService.findNeedyPeopleById(id);
		return new ResponseEntity<NeedyPeople>(p, HttpStatus.OK);
	}
	
	//find all needy people 
	@GetMapping(path="/get")
	public ResponseEntity<List<NeedyPeople>> getAllNeedyPeople() {
		return new ResponseEntity<List<NeedyPeople>>(empService.findAllNeedyPeople(), HttpStatus.OK);
	}
}