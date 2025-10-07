package com.revature.spring.ioc;


public class PaypalPayment implements PaymentInterface {
    @Override
    public void processPayment() {
        System.out.println("PayPal Payment Processed: Paid $100");
    }
}

