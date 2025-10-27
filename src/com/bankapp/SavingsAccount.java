package com.bankapp;

public class SavingsAccount extends Account{
    private double interestRate;
    private double minimumBalance;

    public SavingsAccount(String accountNumber, String accountHolderName, double initialBalance, double interestRate, double minimumBalance) {
        super(accountNumber, accountHolderName, initialBalance);
        this.interestRate = interestRate;
        this.minimumBalance = minimumBalance;
    }

    public void applyInterest(){
        double interest = balance * (interestRate/100);
        balance += interest;
        System.out.println("💰 Interest of ₦" + interest + " applied successfully!");
    }

    @Override
    public void withdraw(double amount){
        if(amount > 0 && (balance - amount) >= minimumBalance){
            balance -= amount;
            System.out.println("✅ Withdrawn ₦" + amount + " successfully.");
        } else
            System.out.println("❌ Withdrawal denied! Must maintain minimum balance of ₦");
    }

    @Override
    public void displayAccountDetails(){
        super.displayAccountDetails();
        System.out.println("Account Type: Savings");
        System.out.println("Interest Rate: " + interestRate + "%");
        System.out.println("Minimum Balance: ₦"+ minimumBalance);
        System.out.println("_____________________");
    }
}
