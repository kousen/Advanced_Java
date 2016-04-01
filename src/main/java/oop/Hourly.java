package oop;

public class Hourly extends Employee {
    public static final double DEFAULT_RATE = 100;
    public static final int DEFAULT_HOURS = 80;

    private double rate = DEFAULT_RATE;
    private double hours = DEFAULT_HOURS;

    public Hourly() {
        this(DEFAULT_NAME, DEFAULT_RATE);
    }

    public Hourly(String name) {
        this(name, DEFAULT_RATE);
    }

    public Hourly(String name, double rate) {
        super(name);
        this.rate = rate;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public double getHours() {
        return hours;
    }

    public void setHours(double hours) {
        this.hours = hours;
    }

    @Override
    public double getPay() {
        return rate * hours;
    }
}
