package com.test.employee.exception;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseStatus;


public class EmployeeIdNotFountException extends Exception  {
	
	public  EmployeeIdNotFountException(String message) {
		super(message);
	}

	public EmployeeIdNotFountException(String string, int id) {
		super(string);
	}

	public EmployeeIdNotFountException() {
		super();
	}
}

