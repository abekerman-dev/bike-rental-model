package com.intivefdv.exam.bikerentalcompany.model;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public final class HourlyRental extends AbstractRental {

	public HourlyRental(int timeUnitAmount) {
		super(timeUnitAmount);
	}

	@Override
	public ChronoUnit getTimeUnit() {
		return ChronoUnit.HOURS;
	}

	@Override
	public BigDecimal getTimeUnitCost() {
		return BigDecimal.valueOf(5);
	}

}
