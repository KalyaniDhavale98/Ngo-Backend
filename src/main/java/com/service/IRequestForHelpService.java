package com.service;

import java.sql.SQLException;
import java.util.List;

import com.dto.RequestForHelpDto;
import com.exception.DuplicateRequestException;
import com.exception.NoSuchRequestException;
import com.model.NeedyPeople;
import com.model.RequestForHelp;

public interface IRequestForHelpService {
	public RequestForHelp addRequest(RequestForHelp help) throws DuplicateRequestException, SQLException ;
	public RequestForHelpDto  findRequestId(int requestId) throws NoSuchRequestException;
	List<RequestForHelp>getRequest();
	public RequestForHelp removeRequest(int requestId) throws NoSuchRequestException;
	public RequestForHelp modifyRequestForHelp(int requestId, RequestForHelp help);
}
