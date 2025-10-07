package com.revature.spring.ioc;
public class CreditCardPayment implements PaymentInterface {
    @Override
    public void processPayment() {
        System.out.println("Credit Card Payment Processed: Paid $100");
    }

}

