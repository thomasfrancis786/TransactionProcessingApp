package com.n26.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.n26.domain.ResponseStatus;
import com.n26.domain.StatisticsDetail;
import com.n26.domain.TransactionDetail;
import com.n26.exception.NotEnoughTransactionsException;
import com.n26.service.TransactionService;

/**
 * The Class TransactionController.
 */
@RestController
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	/**
	 * Adds the transaction.
	 *
	 * @param transactionDetail the transaction detail
	 * @return the response status
	 */
	@PostMapping("/transactions")
	public ResponseStatus addTransaction(@RequestBody TransactionDetail transactionDetail) {
		return transactionService.add(transactionDetail);
	}

	/**
	 * Gets the statistics.
	 *
	 * @return the statistics
	 * @throws NotEnoughTransactionsException the not enough transactions exception
	 */
	@GetMapping("/statistics")
	public StatisticsDetail getStatistics() throws NotEnoughTransactionsException {
		return transactionService.getStatistics();
	}

}
