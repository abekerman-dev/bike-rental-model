package com.intivefdv.exam.bikerentalcompany.model;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class DailyRental extends AbstractRental {

	public DailyRental(int timeUnitAmount) {
		super(timeUnitAmount);
	}

	@Override
	public ChronoUnit getTimeUnit() {
		return ChronoUnit.DAYS;
	}

	@Override
	public BigDecimal getTimeUnitCost() {
		return BigDecimal.valueOf(20);
	}

}
