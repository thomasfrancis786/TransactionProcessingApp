package com.n26.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "No transaction avalable for calculating statistics")
public class NotEnoughTransactionsException extends Exception {

	private static final long serialVersionUID = -3972421791136797070L;

	public NotEnoughTransactionsException() {
		super();
	}
}
