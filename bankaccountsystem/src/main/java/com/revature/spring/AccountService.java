package com.revature.spring;

public class AccountService {
    private TransactionService transactionService;
    private InterestCalculator interestCalculator;
    private double balance = 100.0;

    // Dependency Injection via Constructor
    public AccountService(TransactionService transactionService, InterestCalculator interestCalculator) {
        this.transactionService = transactionService;
        this.interestCalculator = interestCalculator;
    }

    public void deposit(double amount) {
        balance += amount;
        transactionService.recordTransaction("Deposit", amount);
        System.out.println("Deposited: $" + amount + ", New Balance: $" + balance);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds for withdrawal of: $" + amount);
            return;
        }
        balance -= amount;
        transactionService.recordTransaction("Withdrawal", amount);
        System.out.println("Withdrew: $" + amount + ", New Balance: $" + balance);
    }

    public void applyInterest() {
        double interest = interestCalculator.calculateInterest(balance);
        balance += interest;
        System.out.println("Applied Interest: $" + interest + ", New Balance: $" + balance);
    }

    public void printBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public void printTransactionHistory() {
        transactionService.printAllTransactions();
    }

}
