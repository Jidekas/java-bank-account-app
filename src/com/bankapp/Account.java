package com.bankapp;

public class Account {
    private String accountNumber;
    private String accountHolderName;


    protected double balance;

    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            System.out.println("✅ Deposited ₦" + amount + " successfully.");
        } else
            System.out.println("❌ Invalid amount");

    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            System.out.println("✅ Withdrawn ₦" + amount + " successfully.");
        } else
            System.out.println("❌ Insufficient funds or invalid amount!");
    }


    public void displayAccountDetails(){
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₦" + balance);
        System.out.println("------------------------");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }
}
