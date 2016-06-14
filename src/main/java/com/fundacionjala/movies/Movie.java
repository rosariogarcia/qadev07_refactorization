package com.fundacionjala.movies;

public abstract class Movie {

    protected final String title;
    protected double priceRent;
    protected int daysAllowed;
    protected double priceDelay;
    protected int points;

    public Movie(String title) {
        this.title = title;
    }

    public abstract double calculateChargeMovie(int daysRented);

    public abstract int calculatePoints(int daysRented);

    public String getTitle() {
        return title;
    }

    public double getPriceRent() {
        return priceRent;
    }

    public void setPriceRent(double priceRent) {
        this.priceRent = priceRent;
    }

    public int getDaysAllowed() {
        return daysAllowed;
    }

    public void setDaysAllowed(int daysAllowed) {
        this.daysAllowed = daysAllowed;
    }

    public double getPriceDelay() {
        return priceDelay;
    }

    public void setPriceDelay(double priceDelay) {
        this.priceDelay = priceDelay;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }
}
