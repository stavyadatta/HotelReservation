package com.company;

public class Cash extends PaymentMethod {
    private double cash;

    public Cash(double cash) {
        super(cash);
        this.cash = cash;
    }

    public void setCash(double cash) {

        this.cash = cash;
    }

    public double change(double given_money){
        return given_money - this.cash;
    }

    public double getCash() {
        return cash;
    }
}
