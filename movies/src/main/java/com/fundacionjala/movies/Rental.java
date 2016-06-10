package com.fundacionjala.movies;

class Rental {
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie, int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}

	public int getDaysRented() {
		if (_daysRented < 1)
			return 0;
		return _daysRented;
	}

	public Movie getMovie() {
		return _movie;
	}

}