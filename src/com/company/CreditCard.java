package com.company;

import java.util.Date;

public class CreditCard extends PaymentMethod {
    private String credit_card_number;
    private Date expiry_date;
    // The name from the guest class will be used here for the name of the holder right now just using string
    private boolean payment_status;

    public CreditCard(){
        super();
        // when there is no payment info
        payment_status = false;
    }

    public CreditCard(String credit_card_number, Date expiry_date) {
        super();
        this.credit_card_number = credit_card_number;
        this.expiry_date = expiry_date;
        this.payment_status = true;
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


    public boolean checkPayment(){
        return payment_status;
    }
}
