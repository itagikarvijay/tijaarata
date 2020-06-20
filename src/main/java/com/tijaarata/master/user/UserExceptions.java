/**
 * 
 */
package com.tijaarata.master.user;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.tijaarata.exceptions.ErrorDetails;

/**
 * @author User
 *
 */
@ControllerAdvice
public class UserExceptions extends ResponseEntityExceptionHandler {

	@ExceptionHandler({ AuthenticationException.class })
	public ResponseEntity<ErrorDetails> handleBadCredentialException(BadCredentialsException ex, WebRequest request) {
		System.out.println("Bad credentials");
		ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(),"Bad credentials.!");
		return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
