package com.fundacionjala.movies;

public abstract class Movie {

    private String title;
    private int code;

    public Movie(String title, int code) {
        this.title = title;
        this.code = code;
    }

    public abstract double calculateChargeMovie(int daysRented);

    public abstract int calculatePoints(int daysRented);

    public String getTitle() {
        return title;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
