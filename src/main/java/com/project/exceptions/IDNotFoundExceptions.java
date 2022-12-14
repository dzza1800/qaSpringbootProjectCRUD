package com.project.exceptions;

import javax.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "ID is not valid (either been deleted already or does not exist)")
public class IDNotFoundExceptions extends EntityNotFoundException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2551706758657561918L;

	public IDNotFoundExceptions() {
		
	}

}
