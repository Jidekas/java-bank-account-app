package com.bankapp;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        var bank = new Bank();
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

        bank.addAccount(savingsAcct1);
        bank.addAccount(currentAcct1);

        bank.deposit("001",3000);
        bank.deposit("002",50_000);
        bank.transfer("002","001",15_000);
        bank.displayAllAccounts();

    }
}