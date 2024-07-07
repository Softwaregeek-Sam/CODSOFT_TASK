package com.ATM_Interface;

import java.util.Scanner;

public class State_Bank_ATM {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ATM_Services atmServices = new ATM_Services();
        final int maxAttempt = 3;
        int attempt = 0;
        Users user = null;


        System.out.println("Welcome to the SBI ATM");
        while (attempt < maxAttempt) {
            System.out.print("Please enter you account Number: ");
            String accountNumber = scanner.nextLine();
            user = atmServices.validateUser(accountNumber);

            if (user == null) {
                attempt++;
                System.out.println("Invalid account number!! Retry");
                continue;
            }
            System.out.print("Please enter your PIN: ");
            String pin = scanner.nextLine();

            if (!user.validatePin(pin)) {
                attempt++;
                System.out.println("Invalid PIN.");
                continue;
            }
            break;

        }
        if (user == null || attempt >= maxAttempt) {
            System.out.println("Too many failed attempts. Try again later!! Exiting");
            return;
        }
        System.out.println("Welcome, " + user.getAccountHolderName());

        while (true) {
            System.out.println("Please choose an option: ");
            System.out.println("1. ->  Check Balance");
            System.out.println("2. ->  Deposit");
            System.out.println("3. ->  Withdraw");
            System.out.println("4. ->  Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    atmServices.checkBalance(user);
                    break;

                case 2:
                    System.out.print("Enter amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    atmServices.deposit(user, depositAmount);
                    break;
                case 3:
                    System.out.println("Enter amount to withdrawal: ");
                    double withdrawalAmount = scanner.nextDouble();
                    atmServices.withdraw(user, withdrawalAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using SBI ATM. ");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }


    }
}
