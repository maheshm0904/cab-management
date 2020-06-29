package com.cab.cabmanagement.common;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ NotFoundException.class })
	public ResponseEntity<Object> handleResourceNotFoundException(
			Exception ex, WebRequest request) {
		return new ResponseEntity<Object>(
				"Requested ressource not found", new HttpHeaders(), HttpStatus.NOT_FOUND);
	}
}