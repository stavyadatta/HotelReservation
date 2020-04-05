package com.company;

public class Cash extends Bill{
    private double cash;

    public Cash(double cash) {
        this.cash = cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    public double change(double given_money){
        return given_money - this.cash;
    }
}
