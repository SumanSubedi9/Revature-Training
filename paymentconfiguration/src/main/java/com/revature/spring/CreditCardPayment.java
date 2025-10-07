package com.revature.spring;

import org.springframework.stereotype.Component;

@Component("creditCardPayment")
public class CreditCardPayment implements Payment {
    @Override
    public void processPayment() {
        System.out.println("Processing payment through Credit Card. Paid: $100");
    }

}
