package com.company;

import java.security.PublicKey;

public abstract class Bill {
    private double totalbill;
    // here the totoal bill will be used from the

    public double getTotalbill() {
        return totalbill;
    }

    public void getTotalBill(double totalbill) {
        this.totalbill = totalbill;
    }

    public void PrintBillInvoice(){
        System.out.printf("The total bill for the service is going to be %.2f SGD ", this.totalbill);
    }
}
