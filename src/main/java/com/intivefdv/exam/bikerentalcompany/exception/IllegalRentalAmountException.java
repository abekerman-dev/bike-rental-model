package com.intivefdv.exam.bikerentalcompany.exception;

@SuppressWarnings("serial")
public class IllegalRentalAmountException extends Exception {

	public IllegalRentalAmountException(int rentalAmount) {
		super(rentalAmount + " of rentals not allowed. It must be between 3 and 5");
	}

}
