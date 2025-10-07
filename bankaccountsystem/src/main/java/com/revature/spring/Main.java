package com.revature.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // Step 1: Load Spring Configuration
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfiguration.class);

        // Step 2: Get AccountService Bean from Spring Container
        AccountService accountService = context.getBean(AccountService.class);

        // Step 3: Use the Bank Account System
        System.out.println("=== Bank Account System ===");
        accountService.printBalance();

        // Perform some transactions
        accountService.deposit(200.0);
        accountService.withdraw(50.0);
        accountService.applyInterest();

        // Print final balance and transaction history
        accountService.printBalance();
        accountService.printTransactionHistory();

        // Step 4: Close the Spring Context
        context.close();

    }
}
