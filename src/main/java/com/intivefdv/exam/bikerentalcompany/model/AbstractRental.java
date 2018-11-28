package com.intivefdv.exam.bikerentalcompany.model;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public abstract class AbstractRental implements Rental {

	private int timeUnitAmount;

	public AbstractRental(int timeUnitAmount) {
		this.timeUnitAmount = timeUnitAmount;
	}
	
	protected abstract ChronoUnit getTimeUnit();

	protected abstract BigDecimal getTimeUnitCost();

	@Override
	public BigDecimal getTotalCost() {
		return getTimeUnitCost().multiply(BigDecimal.valueOf(timeUnitAmount));
	}

	@Override
	public String toString() {
		return "[" + getClass().getSimpleName() + "] worth " + timeUnitAmount + " " + getTimeUnit();
	}

}
