/**
 * 
 */
package com.tijaarata.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author User
 *
 */

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NotFoundException(String exceptionMessage) {
		super(exceptionMessage);
	}

}
