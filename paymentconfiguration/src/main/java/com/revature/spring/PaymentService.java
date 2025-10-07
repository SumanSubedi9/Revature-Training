package com.revature.spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    private final Payment payment;

    // Constructor injection - choose bean by qualifier name if multiple
    // implementations exist
    public PaymentService(@Qualifier("creditCardPayment") Payment payment) {
        this.payment = payment;
    }

    public void makePayment() {
        payment.processPayment();
    }

}
