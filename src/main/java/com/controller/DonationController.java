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
import org.springframework.web.bind.annotation.RestController;

import com.exception.NoSuchEmployeeException;
import com.model.Donation;
import com.service.IDonationService;

@RestController
@CrossOrigin
public class DonationController {

	@Autowired
	IDonationService donationSer;

	// add donation
	@PostMapping("/donation/add")
	public ResponseEntity<Donation> addDonation(@RequestBody Donation donation) {
		Donation d = donationSer.addDonation(donation);
		return new ResponseEntity<Donation>(d, HttpStatus.CREATED);
	}

	// get all donations
	@GetMapping("/donation/get")
	public ResponseEntity<List<Donation>> getDonations() {
		List<Donation> l = donationSer.getDonations();
		ResponseEntity<List<Donation>> re = new ResponseEntity<List<Donation>>(l, HttpStatus.OK);
		return re;
	}

	// get donation by id
	@GetMapping("/donation/get/{donationId}")
	public ResponseEntity<Donation> getDonationById(@PathVariable int donationId) {
		Donation d = donationSer.getDonationById(donationId);
		ResponseEntity<Donation> re = new ResponseEntity<Donation>(d, HttpStatus.OK);
		return re;
	}

//	// modify donation details
//	@PutMapping(path = "/donation/update/{donationId}")
//	public ResponseEntity<Donation> updateDonation(@PathVariable("employeeId") int donationId,
//			@RequestBody Donation donation) throws Exception {
//		Donation e1 = donationSer.updateDonation(donationId, donation);
//
//		ResponseEntity<Donation> re = new ResponseEntity<Donation>(e1, HttpStatus.OK);
//		return re;
//	}
//
	// delete donation details
	@DeleteMapping(path = "/donation/delete/{donationId}")
	public ResponseEntity<String> removeDonation(@PathVariable int donationId) throws NoSuchEmployeeException {
		donationSer.removeDonation(donationId);

		ResponseEntity<String> re = new ResponseEntity<String>("Deleted", HttpStatus.OK);
		return re;
	}
}