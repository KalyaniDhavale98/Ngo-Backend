package com.exception;

import com.model.RequestForHelp;

public class DuplicateRequestException extends Exception{

	public DuplicateRequestException() {}
	public DuplicateRequestException(String request) 
	{
		super(request);
	}
}
