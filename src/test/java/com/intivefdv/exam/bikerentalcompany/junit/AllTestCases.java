package com.intivefdv.exam.bikerentalcompany.junit;

import static com.intivefdv.exam.bikerentalcompany.test.util.MockDataGenerator.getDailyRental;
import static com.intivefdv.exam.bikerentalcompany.test.util.MockDataGenerator.getEmptyFamilyRental;
import static com.intivefdv.exam.bikerentalcompany.test.util.MockDataGenerator.getHealthyFamilyRental;
import static com.intivefdv.exam.bikerentalcompany.test.util.MockDataGenerator.getHourlyRental;
import static com.intivefdv.exam.bikerentalcompany.test.util.MockDataGenerator.getSixElementsFamilyRental;
import static com.intivefdv.exam.bikerentalcompany.test.util.MockDataGenerator.getTwoElementsFamilyRental;
import static com.intivefdv.exam.bikerentalcompany.test.util.MockDataGenerator.getWeeklyRental;
import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Test;

import com.intivefdv.exam.bikerentalcompany.exception.IllegalRentalAmountException;
import com.intivefdv.exam.bikerentalcompany.model.Rental;

/**
 * 
 */

/**
 * @author andres
 *
 */
public class AllTestCases {

	// Happy path tests begin

	@Test
	public void When_RentalIs10Hours_Expect_TotalCostToBe50Dollars() {
		final Rental tenHourRental = getHourlyRental(10);
		assertEquals("Total cost for " + tenHourRental + " should be 50", BigDecimal.valueOf(50),
				tenHourRental.getTotalCost());
	}

	@Test
	public void When_RentalIs3Days_Expect_TotalCostToBe60Dollars() {
		final Rental threeDayRental = getDailyRental(3);
		assertEquals("Total cost for " + threeDayRental + " should be 60", BigDecimal.valueOf(60),
				threeDayRental.getTotalCost());
	}

	@Test
	public void When_RentalIs1Week_Expect_TotalCostToBe60Dollars() {
		final Rental oneWeekRental = getWeeklyRental(1);
		assertEquals("Total cost for " + oneWeekRental + " should be 60", BigDecimal.valueOf(60),
				oneWeekRental.getTotalCost());
	}

	@Test
	public void When_RentalIsHealthyFamilyRental_Expect_TotalCostToHave30PercentDiscount()
			throws IllegalRentalAmountException {
		final Rental familyRentalOk = getHealthyFamilyRental();

		// Total cost for familyRentalOk is sum of individual rentals minus 30%
		BigDecimal finalCostWithDiscount = BigDecimal.valueOf(85 * 0.7).setScale(1, RoundingMode.CEILING);

		assertEquals("Final Cost With 30% Discount for " + familyRentalOk + " should be " + finalCostWithDiscount,
				finalCostWithDiscount, familyRentalOk.getTotalCost());
	}

	// Happy path tests end

	// Exception tests begin

	@Test(expected = IllegalRentalAmountException.class)
	public void When_RentalIsEmptyFamilyRental_Expect_Exception() throws IllegalRentalAmountException {
		getEmptyFamilyRental();
	}

	@Test(expected = IllegalRentalAmountException.class)
	public void When_RentalIsLessThanThreeElementsFamilyRental_Expect_Exception() throws IllegalRentalAmountException {
		getTwoElementsFamilyRental();
	}

	@Test(expected = IllegalRentalAmountException.class)
	public void When_RentalIsMoreThanFiveElementsFamilyRental_Expect_Exception() throws IllegalRentalAmountException {
		getSixElementsFamilyRental();
	}
	// Exception tests end

}
