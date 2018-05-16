package com.n26.domain;

import java.io.Serializable;

/**
 * The Class TransactionDetail.
 */
public class TransactionDetail implements Comparable<TransactionDetail>, Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 4732281333419259695L;

	/** The amount. */
	private Double amount;

	/** The timestamp. */
	private Long timestamp;

	/**
	 * Gets the amount.
	 *
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}

	/**
	 * Sets the amount.
	 *
	 * @param amount the new amount
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}

	/**
	 * Gets the timestamp.
	 *
	 * @return the timestamp
	 */
	public Long getTimestamp() {
		return timestamp;
	}

	/**
	 * Sets the timestamp.
	 *
	 * @param timestamp the new timestamp
	 */
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(TransactionDetail o) {
		return this.amount.compareTo(o.amount);
	}
}
