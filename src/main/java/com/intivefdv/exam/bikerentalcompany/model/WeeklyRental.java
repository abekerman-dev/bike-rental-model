package com.intivefdv.exam.bikerentalcompany.model;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;

public class WeeklyRental extends AbstractRental {

	public WeeklyRental(int timeUnitAmount) {
		super(timeUnitAmount);
	}

	@Override
	public ChronoUnit getTimeUnit() {
		return ChronoUnit.WEEKS;
	}

	@Override
	public BigDecimal getTimeUnitCost() {
		return BigDecimal.valueOf(60);
	}

}
