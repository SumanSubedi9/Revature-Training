package com.revature.spring;

import java.util.ArrayList;
import java.util.List;

public class TransactionService {
    private List<String> transactions = new ArrayList<>();

    public void recordTransaction(String type, double amount) {
        String transaction = type + ": $" + amount;
        transactions.add(transaction);
        System.out.println("Recorded Transaction - " + transaction);
    }

    public void printAllTransactions() {
        System.out.println("Transaction History:");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
