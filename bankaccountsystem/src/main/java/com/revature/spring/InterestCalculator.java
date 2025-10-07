package com.revature.spring;

public class InterestCalculator {
    private double interestRate = 0.05; // 5% interest rate

    public double calculateInterest(double balance) {
        return balance * interestRate;
    }

}
