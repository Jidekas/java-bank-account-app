package com.bankapp;

public class CheckingAccount extends Account{
    private  double overdraftLimit;

    public CheckingAccount(String accountNumber, String accountHolderName, double initialBalance, double overdraftLimit) {
        super(accountNumber, accountHolderName, initialBalance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void withdraw(double amount){
        if(amount >0 && amount <= (balance + overdraftLimit)){
            balance -= amount;
            System.out.println("✅ Withdrawal Successful");
        }else
            System.out.println("❌ Withdrawal denied! Overdraft limit exceeded.");
    }

    @Override
    public  void  displayAccountDetails(){
        super.displayAccountDetails();
        System.out.println("Account Type: Checking");
        System.out.println("Overdraft Limit: ₦" + overdraftLimit);
        System.out.println("------------------------");
    }


}
