package com.intivefdv.exam.bikerentalcompany.model;

import java.math.BigDecimal;
import java.util.List;

import com.intivefdv.exam.bikerentalcompany.exception.IllegalRentalAmountException;

public class FamilyRental implements Rental {
	
	private static final BigDecimal DISCOUNT_FACTOR = BigDecimal.valueOf(0.7);

	List<Rental> rentals;

	public FamilyRental(List<Rental> rentals) throws IllegalRentalAmountException {
		if (rentals.size() < 3 || rentals.size() > 5) {
			throw new IllegalRentalAmountException(rentals.size());
		}
		this.rentals = rentals;
	}

	@Override
	public BigDecimal getTotalCost() {
		return rentals
			.stream()
			.map(Rental::getTotalCost)
			.reduce(BigDecimal.ZERO, BigDecimal::add)
			.multiply(DISCOUNT_FACTOR);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("FamilyRental made up of:\n");
		rentals.stream().forEach(rental -> sb.append(rental + "\n"));
		
		return sb.toString();
	}

}
