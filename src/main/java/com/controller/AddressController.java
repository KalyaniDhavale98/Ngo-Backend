package com.controller;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.exception.DuplicateEmployeeException;
import com.exception.NoSuchEmployeeException;
import com.model.Address;
import com.model.Donor;
import com.model.Employee;
import com.model.RequestForHelp;
import com.service.AddressServiceImpl;
import com.service.DonorServiceImpl;

@RestController
@CrossOrigin
public class AddressController {

	@Autowired
	AddressServiceImpl addressService;

	// get donor address
	@GetMapping("/donor/get/address/{addressId}")
	public ResponseEntity<Address> getDonorAddressById(@PathVariable int addressId) {
		Address lcl = addressService.getDonorAddressById(addressId);
		ResponseEntity<Address> re = new ResponseEntity<Address>(lcl, HttpStatus.OK);
		return re;
	}

	// get employee address
	@GetMapping("/employee/get/address/{addressId}")
	public ResponseEntity<Address> getEmpAddressById(@PathVariable int addressId) {
		Address lcl = addressService.getEmpAddressById(addressId);
		ResponseEntity<Address> re = new ResponseEntity<Address>(lcl, HttpStatus.OK);
		return re;
	}
	
	// get needyPeople address
		@GetMapping("/needypeople/get/address/{addressId}")
		public ResponseEntity<Address> getNeedyAddressById(@PathVariable int addressId) {
			Address lcl = addressService.getNeedyAddressById(addressId);
			ResponseEntity<Address> re = new ResponseEntity<Address>(lcl, HttpStatus.OK);
			return re;
		}
	//add address
	// add employee
		@PostMapping("/employee/address/add")
		public ResponseEntity<Address> addEmpAddress( @RequestBody Address address)
		{
			Address add = addressService.addEmpAddress(address);
			
			return new ResponseEntity<Address>(add, HttpStatus.CREATED);
		}
		@PostMapping("/needyPeople/address/add")
		public ResponseEntity<Address> addNeedyPeopleAddress( @RequestBody Address address)
		{
			Address add = addressService.addEmpAddress(address);
			
			return new ResponseEntity<Address>(add, HttpStatus.CREATED);
		}


}