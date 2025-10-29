package com.bankapp;

import java.util.Scanner;

public class Console {
    Scanner scanner = new Scanner(System.in);
    Bank bank = new Bank();

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
        String accNum = scanner.next();
        scanner.nextLine(); //consume nextLine left by entering an int

        System.out.println("Enter account holder name: ");
        String holder = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = getDoubleInput();

        System.out.println("Select account type:");
        System.out.println("1. Savings Account");
        System.out.println("2. Checking Account");
        int type = getIntInput();

        Account account = null;

        if (type == 1){
            System.out.print("Enter interest rate (eg 5 for 5%: ");
            double rate = getDoubleInput();
            System.out.print("Enter minimum balance: ");
            double minBalance = getDoubleInput();
            account = new SavingsAccount(accNum, holder, balance, rate, minBalance);
        } else if(type == 2){
            System.out.print("Enter overdraft limit: ");
            double overdraft = getDoubleInput();
            account = new CheckingAccount(accNum, holder,balance,overdraft);
        } else {
            System.out.println("Invalid Account type");
            return;
        }
        bank.addAccount(account);
    }

    public void deposit(){
        System.out.print("Enter accountNum: ");
        String accNum = scanner.next();
        System.out.print("Enter amount to deposit: ");
        double amount = getDoubleInput();
        bank.deposit(accNum, amount);
    }
    public void withdraw(){
        System.out.print("Enter accountNum: ");
        String accNum = scanner.next();
        System.out.print("Enter amount to withdraw: ");
        double amount = getDoubleInput();
        bank.withdraw(accNum, amount);
    }

    public void transfer(){
        System.out.print("Enter sender account no");
        String from = scanner.next();
        System.out.print("Enter receiver account no");
        String to = scanner.next();
        System.out.print("Enter amount to send");
        double amount = getDoubleInput();
        bank.transfer(from, to, amount);
    }

    public void viewAccount(){
        System.out.print("Enter account number: ");
        String accNum = scanner.next();
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

    public int getIntInput(){
        while (!scanner.hasNextInt()) {
            System.out.println("⚠️ Please enter a valid number!");
            scanner.next();
        }
        return scanner.nextInt();
    }

    private  double getDoubleInput() {
        while (!scanner.hasNextDouble()) {
            System.out.println("⚠️ Please enter a valid amount!");
            scanner.next();
        }
        return scanner.nextDouble();
    }

}
