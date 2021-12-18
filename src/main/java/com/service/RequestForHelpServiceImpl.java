package com.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dto.RequestForHelpDto;
import com.exception.DuplicateEmployeeException;
import com.exception.DuplicateRequestException;
import com.exception.NoSuchEmployeeException;
import com.exception.NoSuchRequestException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.model.DonationType;
import com.model.NeedyPeople;
import com.model.RequestForHelp;
import com.repository.RequestForHelpRepository;

@Service
public class RequestForHelpServiceImpl implements IRequestForHelpService {
	
	@Autowired
	RequestForHelpRepository requestRepo;

	@Override
	public RequestForHelp addRequest(RequestForHelp help) throws DuplicateRequestException, SQLException {
		int id = help.getRequestId();
		if (id != 0) {
			throw new DuplicateRequestException();
		} else {
			RequestForHelp req=new RequestForHelp();
			req.setNeedyPersonName(help.getNeedyPersonName());
			req.setPhone(help.getPhone());
            req.setItem(help.getItem());
            req.setStatus(help.getStatus());
			requestRepo.save(help);
		}
		return help;
	}
	@Override
	public List<RequestForHelp> getRequest() {
		List<RequestForHelp> r =  requestRepo.findAll();
		return r;
	}

	@Override
	public RequestForHelpDto findRequestId(int requestId) throws NoSuchRequestException {
		Optional<RequestForHelp> help = Optional.ofNullable(requestRepo.findById(requestId).get());
		if(!help.isPresent()) {
			throw new NoSuchRequestException("request is not found with given requestId "+requestId);
		}
		
		RequestForHelp req= help.get();
		
		// Create dto obj
	      RequestForHelpDto dto = new RequestForHelpDto();
		
		// update dto with request details	
	     dto.setRequestId(req.getRequestId());
		dto.setNeedyPersonName(req.getNeedyPersonName());
		dto.setPhone(req.getPhone());
		dto.setStatus(req.getStatus());
		dto.setItem(req.getItem());
		return dto;
	}



	@Override
	public RequestForHelp removeRequest(int requestId) throws NoSuchRequestException {
		RequestForHelp help = requestRepo.findById(requestId).get();
		requestRepo.deleteById(requestId);
		return help;
	}
	@Override
	public RequestForHelp modifyRequestForHelp(int requestId, RequestForHelp help) {
		Optional< RequestForHelp> optional = requestRepo.findById(requestId);
		if (optional.isPresent()) {
			 RequestForHelp r = optional.get();
			 
			 r.setNeedyPersonName(help.getNeedyPersonName());
			 r.setPhone(help.getPhone());
			 r.setItem(help.getItem());
			r.setStatus(help.getStatus());
			return requestRepo.save(r);
		}
		return help;
	}
	
	}


