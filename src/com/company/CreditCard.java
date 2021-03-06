package com.company;

import java.util.Date;

public class CreditCard extends PaymentMethod {
    private String credit_card_number;
    private Date expiry_date;
    private String billing_address;
    // The name from the guest class will be used here for the name of the holder right now just using string

    public CreditCard(){
        super();
        // when there is no payment info
    }

    public CreditCard(String credit_card_number, Date expiry_date, String billing_address) {
        super();
        this.credit_card_number = credit_card_number;
        this.expiry_date = expiry_date;
        this.billing_address = billing_address;
    }

    public String getCredit_card_number() {
        return credit_card_number;
    }

    public Date getExpiry_date() {
        return expiry_date;
    }


    public void setCredit_card_number(String credit_card_number) {
        this.credit_card_number = credit_card_number;
    }

    public void setExpiry_date(Date expiry_date) {
        this.expiry_date = expiry_date;
    }

    public String getBilling_address() {
        return billing_address;
    }

    public void setBilling_address(String billing_address) {
        this.billing_address = billing_address;
    }
}
