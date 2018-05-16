package com.n26.service;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import com.n26.domain.ResponseStatus;
import com.n26.domain.StatisticsDetail;
import com.n26.domain.TransactionDetail;
import com.n26.exception.NotEnoughTransactionsException;

/**
 * The Class TransactionServiceImpl.
 */
@Service
public class TransactionServiceImpl implements TransactionService {

	private List<TransactionDetail> transactionDetails = Collections.synchronizedList(new ArrayList<>());

	/* (non-Javadoc)
	 * @see com.n26.service.TransactionService#add(com.n26.domain.TransactionDetail)
	 */
	@Override
	public ResponseStatus add(TransactionDetail transactionDetail) {
		long difference = Instant.now().toEpochMilli() - transactionDetail.getTimestamp();
		if (difference > 60000) {
			return mapToResponse(204);
		}
		this.transactionDetails.add(transactionDetail);
		return mapToResponse(201);
	}

	/**
	 * Map to response.
	 *
	 * @param statusCode the status code
	 * @return the response status
	 */
	private ResponseStatus mapToResponse(int statusCode) {
		return new ResponseStatus(statusCode);
	}

	/* (non-Javadoc)
	 * @see com.n26.service.TransactionService#getStatistics()
	 */
	@Override
	public StatisticsDetail getStatistics() throws NotEnoughTransactionsException {
		Long threshold = Instant.now().toEpochMilli() - 60000;
		if (CollectionUtils.isEmpty(transactionDetails)) {
			throw new NotEnoughTransactionsException();
		} else {
			DoubleSummaryStatistics summaryStatistics = transactionDetails.stream()
					.filter(trx -> threshold >= trx.getTimestamp())
					.mapToDouble(TransactionDetail::getAmount)
					.summaryStatistics();
			return mapToStatisticsDetail(summaryStatistics);
		}
	}

	/**
	 * Map to statistics detail.
	 *
	 * @param statistics the statistics
	 * @return the statistics detail
	 */
	public StatisticsDetail mapToStatisticsDetail(DoubleSummaryStatistics statistics) {
		StatisticsDetail detail = new StatisticsDetail();
		detail.setSum(statistics.getSum());
		detail.setAvg(statistics.getAverage());
		detail.setCount(statistics.getCount());
		detail.setMax(statistics.getMax());
		detail.setMin(statistics.getMin());
		return detail;
	}
}
