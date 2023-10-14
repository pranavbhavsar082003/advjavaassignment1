package com.example.advjavaassignment1;


public class LaunchData {
    private int year;
    private String country;
    private int launchCount;

    public LaunchData(int year, String country, int launchCount) {
        this.year = year;
        this.country = country;
        this.launchCount = launchCount;
    }

    public int getYear() {
        return year;
    }
/**
 * @person pranav
 * method to set year.
 * */
    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }
    /**
     * @person pranav
     * method to set country name.
     * */
    public void setCountry(String country) {
        this.country = country;
    }

    public int getLaunchCount() {
        return launchCount;
    }

    /**
     * @person pranav
     * method to set launch count.
     * */
    public void setLaunchCount(int launchCount) {
        this.launchCount = launchCount;
    }
}