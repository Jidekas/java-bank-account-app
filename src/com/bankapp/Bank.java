package com.bankapp;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    //add account to list.
    public void addAccount(Account account){
        accounts.add(account);
        System.out.println("Account created successfully for " + account.getAccountHolderName());
    }

    //find account by acct number
    public Account findAccount(String accountNumber){
        for(Account acc: accounts){
            if(acc.getAccountNumber().equals(accountNumber)){
                return acc;
            }
        }

        return null;
    }

    //implement deposit
    public void deposit(String accountNumber, double amount){
        Account acc = findAccount(accountNumber);
        if(acc != null){
            acc.deposit(amount);
        } else
            System.out.println("❌ Account not found!");
    }

    //implement withdraw
    public void withdraw(String accountNumber, double amount){
        Account acc = findAccount(accountNumber);
        if(acc != null){
            acc.withdraw(amount);
        } else
            System.out.println("❌ Account not found!");
    }

    //implement transfers btw accounts
    public void transfer(String fromAccount, String toAccount, double amount){
        var sender = findAccount(fromAccount);
        var receiver = findAccount(toAccount);

        if(sender == null || receiver == null) {
            System.out.println("One or both accounts not found");
            return;
        }
        double senderOldbalance = sender.getBalance();
        sender.withdraw(amount);

        if(sender.getBalance() < senderOldbalance && (senderOldbalance-sender.getBalance()) == amount){
            receiver.deposit(amount);
            System.out.println("Transfer of ₦" + amount + " successful!");
        }

    }

    public void displayAllAccounts(){
        if(accounts.isEmpty()){
            System.out.println("No accounts found!");
            return;
        }

        System.out.println("======= Accounts ======");
        for(Account acc: accounts){
            acc.displayAccountDetails();
        }
    }

}
