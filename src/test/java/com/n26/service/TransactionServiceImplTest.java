package com.n26.service;

import static org.junit.Assert.assertThat;

import java.util.DoubleSummaryStatistics;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.n26.domain.TransactionDetail;
import com.n26.exception.NotEnoughTransactionsException;

public class TransactionServiceImplTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddForStatusCode201() {
		TransactionDetail transactionDetail = new TransactionDetail();
		transactionDetail.setAmount(123.5d);
		transactionDetail.setTimestamp(System.currentTimeMillis());
		TransactionService transactionService = new TransactionServiceImpl();
		assertThat(transactionService.add(transactionDetail).getStatusCode(), CoreMatchers.equalTo(201));
	}
	
	@Test
	public void testAddForStatusCode204() {
		TransactionDetail transactionDetail = new TransactionDetail();
		transactionDetail.setAmount(123.5d);
		transactionDetail.setTimestamp(System.currentTimeMillis() - 180000);
		TransactionService transactionService = new TransactionServiceImpl();
		assertThat(transactionService.add(transactionDetail).getStatusCode(), CoreMatchers.equalTo(204));
	}
	
	@Test(expected = NotEnoughTransactionsException.class)
	public void testGetStatisticsForException() throws NotEnoughTransactionsException {
		new TransactionServiceImpl().getStatistics();
	}
	
	@Test
	public void testGetStastics() throws NotEnoughTransactionsException {
		TransactionDetail transactionDetail = new TransactionDetail();
		transactionDetail.setAmount(123.5d);
		transactionDetail.setTimestamp(System.currentTimeMillis());
		TransactionService transactionService = new TransactionServiceImpl();
		transactionService.add(transactionDetail);
		
		Assert.assertThat(transactionService.getStatistics(), CoreMatchers.notNullValue());
	}
}
