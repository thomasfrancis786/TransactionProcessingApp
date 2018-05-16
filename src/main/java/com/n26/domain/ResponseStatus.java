package com.n26.domain;

import java.io.Serializable;

// TODO: Auto-generated Javadoc
/**
 * The Class ResponseStatus.
 */
public class ResponseStatus implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 5240377480321814613L;

	/** The status code. */
	int statusCode;

	/**
	 * Instantiates a new response status.
	 *
	 * @param statusCode the status code
	 */
	public ResponseStatus(int statusCode) {
		this.statusCode = statusCode;
	}

	/**
	 * Gets the status code.
	 *
	 * @return the status code
	 */
	public int getStatusCode() {
		return statusCode;
	}

	/**
	 * Sets the status code.
	 *
	 * @param statusCode the new status code
	 */
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

}
