package com.ATM_Interface;

public class Users {
    private final String accountHolderName;
    private final String accountType;
    private final String accountNumber;
    private final String userPin;
    private double availableBalance;

    public Users(String accountHolderName, String accountType, String accountNumber, String userPin, double availableBalance) {
        this.accountHolderName = accountHolderName;
        this.accountType = accountType;
        this.accountNumber = accountNumber;
        this.userPin = userPin;
        this.availableBalance = availableBalance;


    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getAccountNumber() {
        return accountNumber;
    }


    public double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public boolean validatePin(String inputPin) {
        return this.userPin.equals(inputPin);
    }
}
//