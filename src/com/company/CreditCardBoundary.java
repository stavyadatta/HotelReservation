package com.company;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class CreditCardBoundary {

    public static CreditCard enterCreditCardDetails() throws ParseException {
        Scanner sc = new Scanner(System.in);
        System.out.print("Credit card number: ");
        String credit_card_num = sc.nextLine();

        System.out.print("Expiry date in \"dd/MM/yyyy\": ");
        String date_getter = sc.nextLine();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date date = formatter.parse(date_getter);
        System.out.println("Please put the billing address here:");
        String address = sc.nextLine();

        CreditCard creditCard = new CreditCard(credit_card_num, date, address);
        return creditCard;
    }
}
