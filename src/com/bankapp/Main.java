package com.bankapp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        var savingsAcct1 = new SavingsAccount(
                "001",
                "John Doe",
                5000,
                5,
                1000
        );

        var currentAcct1 = new CheckingAccount(
                "002",
                "Tonia Lawrence",
                10_000,
                3000
        );

        savingsAcct1.displayAccountDetails();
        savingsAcct1.deposit(1000);
        savingsAcct1.withdraw(3000);
        savingsAcct1.applyInterest();
        savingsAcct1.displayAccountDetails();

        currentAcct1.displayAccountDetails();
        currentAcct1.deposit(2000);
        currentAcct1.withdraw(16000);
        currentAcct1.displayAccountDetails();
    }
}