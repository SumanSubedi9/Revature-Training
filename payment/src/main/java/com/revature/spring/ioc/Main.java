package com.revature.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        PaymentProcessor processor = context.getBean("paymentProcessor", PaymentProcessor.class);
        processor.executePayment();
        ((org.springframework.context.ConfigurableApplicationContext) context).close();
    }
}
