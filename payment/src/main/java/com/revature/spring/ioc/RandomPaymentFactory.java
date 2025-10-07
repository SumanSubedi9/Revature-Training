package com.revature.spring.ioc;

import java.util.Random;

public class RandomPaymentFactory {
    private PaymentInterface creditCardPayment;
    private PaymentInterface paypalPayment;

    public void setCreditCardPayment(PaymentInterface creditCardPayment) {
        this.creditCardPayment = creditCardPayment;
    }

    public void setPaypalPayment(PaymentInterface paypalPayment) {
        this.paypalPayment = paypalPayment;
    }

    // factory method used by XML: returns a PaymentProcessor wired with a randomly
    // chosen PaymentInterface
    public PaymentProcessor createPaymentProcessor() {
        Random random = new Random();
        boolean useCreditCard = random.nextBoolean();
        if (useCreditCard) {
            System.out.println("Using Credit Card Payment Method (factory)");
            return new PaymentProcessor(creditCardPayment);
        } else {
            System.out.println("Using PayPal Payment Method (factory)");
            return new PaymentProcessor(paypalPayment);
        }
    }
}
