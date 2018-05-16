package com.n26.service;

import com.n26.domain.StatisticsDetail;
import com.n26.domain.ResponseStatus;
import com.n26.domain.TransactionDetail;
import com.n26.exception.NotEnoughTransactionsException;

// TODO: Auto-generated Javadoc
/**
 * The Interface TransactionService.
 */
public interface TransactionService {

	/**
	 * Adds the Transactions.
	 *
	 * @param transactionDetail the transaction detail
	 * @return the response status
	 */
	ResponseStatus add(TransactionDetail transactionDetail);

	/**
	 * Gets the statistics.
	 *
	 * @return the statistics
	 * @throws NotEnoughTransactionsException the not enough transactions exception
	 */
	StatisticsDetail getStatistics() throws NotEnoughTransactionsException;

	
}
