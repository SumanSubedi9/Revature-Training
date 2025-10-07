package com.revature.spring;

import org.springframework.stereotype.Component;

@Component("paypalPayment")
public class PaypalPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing payment through PayPal. Paid: $100");
    }

}
