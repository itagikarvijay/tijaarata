/**
 * 
 */
package com.tijaarata.master.customer;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tijaarata.exceptions.ErrorDetails;
import com.tijaarata.exceptions.NotFoundException;

/**
 * @author User
 *
 */

@RestControllerAdvice
public class CustomerExceptions extends ResponseEntityExceptionHandler{

	@ExceptionHandler({ RuntimeException.class, NotFoundException.class, BadCredentialsException.class})
	public ResponseEntity<ErrorDetails> handleNotFoundException(NotFoundException ex, WebRequest request) {
		System.out.print("Customer not found exception");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),"Customer not found.!");
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}

}
