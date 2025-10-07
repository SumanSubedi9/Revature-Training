package com.revature.spring.ioc;

public class PaymentProcessor {
    private PaymentInterface paymentMethod;

    public PaymentProcessor(PaymentInterface paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void executePayment() {
        paymentMethod.processPayment();
    }

}
