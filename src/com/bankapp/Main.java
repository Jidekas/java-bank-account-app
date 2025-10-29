package com.bankapp;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Console console = new Console();
        boolean exit = false;

        System.out.println("Welcome to Kas Banking System");

        while (!exit){
            console.showMenu();
            System.out.println("Choose an option");
            int choice = console.getIntInput();

            switch (choice){
                case 1 -> console.createAccount();
                case 2 -> console.deposit();
                case 3 -> console.withdraw();
                case 4 -> console.transfer();
                case 5 -> console.viewAccount();
                case 6 -> console.displayAllAccounts();
                case 7 -> {
                    System.out.println("👋 Exiting... Thank you for using Simple Bank!");
                    exit = true;
                }
                default -> System.out.println("Invalid option. Please try again");
            }
        }
    }

}