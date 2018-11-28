package com.intivefdv.exam.bikerentalcompany.test.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.intivefdv.exam.bikerentalcompany.exception.IllegalRentalAmountException;
import com.intivefdv.exam.bikerentalcompany.model.DailyRental;
import com.intivefdv.exam.bikerentalcompany.model.FamilyRental;
import com.intivefdv.exam.bikerentalcompany.model.HourlyRental;
import com.intivefdv.exam.bikerentalcompany.model.Rental;
import com.intivefdv.exam.bikerentalcompany.model.WeeklyRental;

public class MockDataGenerator {

	public static Rental getHourlyRental(int hours) {
		return new HourlyRental(hours);
	}

	public static Rental getDailyRental(int days) {
		return new DailyRental(days);
	}

	public static Rental getWeeklyRental(int weeks) {
		return new WeeklyRental(weeks);
	}

	public static Rental getHealthyFamilyRental() throws IllegalRentalAmountException {
		return new FamilyRental(Arrays.asList(getHourlyRental(1), getDailyRental(1), getWeeklyRental(1)));
	}

	public static Rental getEmptyFamilyRental() throws IllegalRentalAmountException {
		return new FamilyRental(new ArrayList<>());
	}

	public static Rental getTwoElementsFamilyRental() throws IllegalRentalAmountException {
		return new FamilyRental(Arrays.asList(getHourlyRental(1), getDailyRental(1)));
	}

	public static Rental getSixElementsFamilyRental() throws IllegalRentalAmountException {
		final List<Rental> threeRentals = Arrays.asList(getHourlyRental(1), getDailyRental(1), getWeeklyRental(1));
		final List<Rental> sixRentals = new ArrayList<>(threeRentals);
		sixRentals.addAll(threeRentals);

		return new FamilyRental(sixRentals);
	}

}
