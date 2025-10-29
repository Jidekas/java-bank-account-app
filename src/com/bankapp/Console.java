package com.bankapp;

import java.util.Scanner;

public class Console {
    private final ConsoleHelper helper = new ConsoleHelper();
    private final Bank bank = new Bank();

    public void showMenu(){
        System.out.println("\n===== BANK MENU =====");
        System.out.println("1. Create Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transfer");
        System.out.println("5. View Account Details");
        System.out.println("6. View All Accounts");
        System.out.println("7. Exit");
        System.out.println("=====================");
    }

    public void createAccount(){
        System.out.println("Enter account number");
        String accNum = helper.readLine();

        System.out.println("Enter account holder name: ");
        String holder = helper.readLine();

        System.out.print("Enter initial balance: ");
        double balance = helper.readDouble();

        System.out.println("Select account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        int type = helper.readInt();

        Account account = null;

        if (type == 1){
            System.out.print("Enter interest rate (eg 5 for 5%: ");
            double rate = helper.readDouble();
            System.out.print("Enter minimum balance: ");
            double minBalance = helper.readDouble();
            account = new SavingsAccount(accNum, holder, balance, rate, minBalance);
        } else if(type == 2){
            System.out.print("Enter overdraft limit: ");
            double overdraft = helper.readDouble();
            account = new CheckingAccount(accNum, holder,balance,overdraft);
        } else {
            System.out.println("Invalid Account type");
            return;
        }
        bank.addAccount(account);
    }

    public void deposit(){
        System.out.print("Enter accountNum: ");
        String accNum = helper.readLine();
        System.out.print("Enter amount to deposit: ");
        double amount = helper.readDouble();
        bank.deposit(accNum, amount);
    }
    public void withdraw(){
        System.out.print("Enter accountNum: ");
        String accNum = helper.readLine();
        System.out.print("Enter amount to withdraw: ");
        double amount = helper.readDouble();
        bank.withdraw(accNum, amount);
    }

    public void transfer(){
        System.out.print("Enter sender account no: ");
        String from = helper.readLine();
        System.out.print("Enter receiver account no: ");
        String to = helper.readLine();
        System.out.print("Enter amount to send");
        double amount = helper.readDouble();
        bank.transfer(from, to, amount);
    }

    public void viewAccount(){
        System.out.print("Enter account number: ");
        String accNum = helper.readLine();
        Account acc = bank.findAccount(accNum);
        if(acc != null){
            acc.displayAccountDetails();
        } else{
            System.out.println("Account not found");
        }
    }

    public void displayAllAccounts(){
        bank.displayAllAccounts();
    }

}
