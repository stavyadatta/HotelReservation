package com.company;

public class Cash extends PaymentMethod {

    public Cash() {
        super();
    }
    public double change(double given_money){
        return given_money - super.getTotalbill();
    }
}
