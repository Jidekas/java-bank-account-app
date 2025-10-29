package com.bankapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleHelper {
    Scanner scanner = new Scanner(System.in);

    public int readInt(){
        while(true){
            try{
               int value =  scanner.nextInt();
               scanner.nextLine();
               return value;
            } catch (InputMismatchException e){
                System.out.println("Invalid Input. Enter a number");
                scanner.nextLine();
            }
        }
    }
    public double readDouble(){
        while(true){
            try{
                double value =  scanner.nextDouble();
                scanner.nextLine();
                return value;
            } catch (InputMismatchException e){
                System.out.println("Invalid Input. Enter a valid Amount");
                scanner.nextLine();
            }
        }
    }

    public String readLine(){
        return scanner.nextLine();
    }

    public void close(){
        scanner.close();
    }


}