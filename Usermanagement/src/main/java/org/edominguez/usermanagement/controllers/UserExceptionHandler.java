
package org.edominguez.usermanagement.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import org.edominguez.usermanagement.exception.InvalidInputException;
import org.edominguez.usermanagement.exception.InvoiceAllreadyExistException;
import org.edominguez.usermanagement.exception.InvoiceNotFoundException;
import org.edominguez.usermanagement.exception.UserNotFoundException;
import org.edominguez.usermanagement.exception.UserAllreadyExistException;

@RestControllerAdvice
public class UserExceptionHandler {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserExceptionHandler.class);

	@ExceptionHandler(InvalidInputException.class)
	public ResponseEntity<String> handleInvalidInput(InvalidInputException ie) {
		LOGGER.info(ie.getMessage());

		return new ResponseEntity<String>(ie.getMessage(), HttpStatus.BAD_REQUEST);

	}

	@ExceptionHandler(UserAllreadyExistException.class)
	public ResponseEntity<String> handleUserAllreadyExist(UserAllreadyExistException cae) {
		LOGGER.info(cae.getMessage());
		
		return new ResponseEntity<String>(cae.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> handleUserNotFound(UserNotFoundException cnfe) {
		LOGGER.info(cnfe.getMessage());

		return new ResponseEntity<String>(cnfe.getMessage(), HttpStatus.NOT_FOUND);

	}
	@ExceptionHandler(InvoiceAllreadyExistException.class)
	public ResponseEntity<String> handleInvoiceAllreadyExist(InvoiceAllreadyExistException cae) {
		LOGGER.info(cae.getMessage());
		
		return new ResponseEntity<String>(cae.getMessage(), HttpStatus.CONFLICT);
	}

	@ExceptionHandler(InvoiceNotFoundException.class)
	public ResponseEntity<String> handleInvoiceNotFound(InvoiceNotFoundException infe) {
		LOGGER.info(infe.getMessage());

		return new ResponseEntity<String>(infe.getMessage(), HttpStatus.NOT_FOUND);

	}

}
