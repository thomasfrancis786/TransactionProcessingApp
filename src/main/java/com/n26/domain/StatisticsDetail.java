package com.n26.domain;

import java.io.Serializable;

/**
 * The Class StatisticsDetail.
 */
public class StatisticsDetail implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -4675085480664691671L;

	/** The sum. */
	private Double sum;

	/** The avg. */
	private Double avg;

	/** The max. */
	private Double max;

	/** The min. */
	private Double min;

	/** The count. */
	private Long count;

	/**
	 * Gets the sum.
	 *
	 * @return the sum
	 */
	public Double getSum() {
		return sum;
	}

	/**
	 * Sets the sum.
	 *
	 * @param sum the new sum
	 */
	public void setSum(Double sum) {
		this.sum = sum;
	}

	/**
	 * Gets the avg.
	 *
	 * @return the avg
	 */
	public Double getAvg() {
		return avg;
	}

	/**
	 * Sets the avg.
	 *
	 * @param avg the new avg
	 */
	public void setAvg(Double avg) {
		this.avg = avg;
	}

	/**
	 * Gets the max.
	 *
	 * @return the max
	 */
	public Double getMax() {
		return max;
	}

	/**
	 * Sets the max.
	 *
	 * @param max the new max
	 */
	public void setMax(Double max) {
		this.max = max;
	}

	/**
	 * Gets the min.
	 *
	 * @return the min
	 */
	public Double getMin() {
		return min;
	}

	/**
	 * Sets the min.
	 *
	 * @param min the new min
	 */
	public void setMin(Double min) {
		this.min = min;
	}

	/**
	 * Gets the count.
	 *
	 * @return the count
	 */
	public Long getCount() {
		return count;
	}

	/**
	 * Sets the count.
	 *
	 * @param count the new count
	 */
	public void setCount(Long count) {
		this.count = count;
	}

}
