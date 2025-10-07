package com.revature.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfiguration {

    // Creating TransactionService bean
    @Bean
    public TransactionService transactionService() {
        return new TransactionService();
    }

    // Creatin InterestCalculator bean
    @Bean
    public InterestCalculator interestCalculator() {
        return new InterestCalculator();
    }

    // Creating AccountService bean and injecting dependencies
    @Bean
    public AccountService accountService() {
        return new AccountService(transactionService(), interestCalculator());
    }

}
