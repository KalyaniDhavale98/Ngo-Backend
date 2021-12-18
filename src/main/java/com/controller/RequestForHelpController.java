package com.controller;

import java.sql.SQLException;
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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.dto.EmployeeDto;
import com.dto.RequestForHelpDto;
import com.exception.DuplicateRequestException;
import com.exception.NoSuchEmployeeException;
import com.exception.NoSuchRequestException;
import com.model.Employee;
import com.model.NeedyPeople;
import com.model.RequestForHelp;
import com.repository.RequestForHelpRepository;
import com.service.IRequestForHelpService;

@RestController
@CrossOrigin
public class RequestForHelpController {

	@Autowired
	IRequestForHelpService requestService;

	@Autowired
	RequestForHelpRepository requestRepo;

	// add request
	@PostMapping("/request/add")
	@ResponseStatus(HttpStatus.CREATED)
	public ResponseEntity<RequestForHelp> addRequest(@RequestBody RequestForHelp help)
			throws DuplicateRequestException, SQLException {
		RequestForHelp req = requestService.addRequest(help);
		return new ResponseEntity<RequestForHelp>(req, HttpStatus.CREATED);
	}

	// get request by id
	@GetMapping("/request/id/{requestId}")
	public ResponseEntity<RequestForHelpDto> findRequestId(@PathVariable("requestId") int requestId)
			throws NoSuchRequestException {
		RequestForHelpDto e1 = requestService.findRequestId(requestId);
		ResponseEntity<Employee> re = new ResponseEntity<Employee>(HttpStatus.OK);
		return new ResponseEntity<>(e1, HttpStatus.OK);
	}

	// get all request
	@GetMapping("/request/getrequest")
	public ResponseEntity<List<RequestForHelp>> getRequest() {
		List<RequestForHelp> lcl = requestService.getRequest();
		ResponseEntity<List<RequestForHelp>> re = new ResponseEntity<List<RequestForHelp>>(lcl, HttpStatus.OK);
		return re;
	}

	@DeleteMapping(path = "/request/remove/{requestId}")
	public ResponseEntity<RequestForHelp> removeRequest(@PathVariable int requestId) throws NoSuchRequestException {
		RequestForHelp help = requestService.removeRequest(requestId);

		ResponseEntity<RequestForHelp> re = new ResponseEntity<RequestForHelp>(HttpStatus.OK);
		return re;
	}

	// update needy person
	@PutMapping(path = "/update/{requestId}")
	public ResponseEntity<RequestForHelp> modifyNeedyPerson(@PathVariable("requestId") int requestId,@RequestBody RequestForHelp help) {
		RequestForHelp p = requestService.modifyRequestForHelp(requestId, help);

		ResponseEntity<RequestForHelp> re = new ResponseEntity<RequestForHelp>(p, HttpStatus.OK);
		return re;
	}

}
