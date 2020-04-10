package com.company;

import java.security.PublicKey;

public abstract class PaymentMethod {
    private double totalbill;
    private boolean payment_status;
    // here the total bill will be used from the


    public PaymentMethod() {
        this.payment_status = false;
    }

    public PaymentMethod(double totalbill) {
        this.totalbill = totalbill;
        this.payment_status = true;
    }

    public void setPayment_status(boolean payment_status) {
        this.payment_status = payment_status;
    }

    public boolean isPayment_status() {
        return payment_status;
    }

    public double getTotalbill() {

        return totalbill;
    }

    public void setTotalBill(double totalbill) {

        this.totalbill = totalbill;
    }

    public void PrintBillInvoice(){
        System.out.printf("The total bill for the service is going to be %.2f SGD ", this.totalbill);
    }

}
