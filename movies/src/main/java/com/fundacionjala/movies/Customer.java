package com.fundacionjala.movies;

import java.util.Enumeration;
import java.util.Vector;

class Customer {
	private String _name;
	private Vector<Rental> _rentals = new Vector<Rental>();

	public Customer(String name) {
		_name = name;
	}

	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		Enumeration<Rental> rentals = _rentals.elements();

		String result = printHeader(getName());

		while (rentals.hasMoreElements()) {
			double thisAmount = 0;
			Rental each = (Rental) rentals.nextElement();
			if (each.getDaysRented() == 0) {
				result += printMovieDetails(0, each.getMovie().getTitle());
			} else {
				// determine amounts
				thisAmount = selectMovie(thisAmount, each);
				// add frequent renter points
				frequentRenterPoints++;
				// add bonus for a two day new release rental
				if ((each.getMovie().getPriceCode() == Movie.NEW_RELEASE) && each.getDaysRented() > 1)
					frequentRenterPoints++;
				// show figures for this rental
				result += printMovieDetails(thisAmount, each.getMovie().getTitle());
				totalAmount += thisAmount;
			}
		}
		result += printFooterLines(totalAmount, frequentRenterPoints);
		return result;
	}

	/**
	 * @param totalAmount
	 * @param frequentRenterPoints
	 * @return Footer Lines
	 */
	private String printFooterLines(double totalAmount, int frequentRenterPoints) {
		// add footer lines
		return "Amount owed is " + String.valueOf(totalAmount) + "\n" + "You earned "
				+ String.valueOf(frequentRenterPoints) + " frequent renter points";
	}

	/**
	 * @param thisAmount
	 * @return
	 */
	private String printMovieDetails(double thisAmount, String title) {
		if (thisAmount == 0)
			return "\t" + title + "\t" + "The days to rent should be major than 1" + "\n";
		return "\t" + title + "\t" + String.valueOf(thisAmount) + "\n";
	}

	/**
	 * @param thisAmount
	 * @param each
	 * @return
	 */
	public double selectMovie(double thisAmount, Rental each) {
		// determine amounts for each line
		switch (each.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (each.getDaysRented() > 2)
				thisAmount += (each.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += each.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (each.getDaysRented() > 3)
				thisAmount += (each.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}

	private String printHeader(String name) {
		return "Rental Record for " + name + "\n";
	}
}
