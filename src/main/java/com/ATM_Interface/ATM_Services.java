package com.ATM_Interface;

import java.util.ArrayList;
import java.util.List;

public class ATM_Services {
    private final List<Users> users;

    public ATM_Services() {
        users = new ArrayList<>();
        users.add(new Users("Shaurya Verma", "Current", "C2409999", "4549", 150000));
        users.add(new Users("Tilak Verma", "Saving", "S2407999", "9292", 50000));
        users.add(new Users("Rohit Sharma", "Saving", "S2408899", "8765", 50000));
        users.add(new Users("Sumit Kashyap", "Current", "C2402025", "4549", 2500000));
        users.add(new Users("Rani Devi", "Saving", "S2401765", "2003", 50000));
        users.add(new Users("Saloni Kumari", "Current", "C2401055", "2580", 150000));
    }

    public Users validateUser(String accountNumber) {
        for (Users user : users) {
            if (user.getAccountNumber().equals(accountNumber)) {
                return user;
            }

        }
        return null;
    }

    public void deposit(Users user, double amount) {
        user.setAvailableBalance(user.getAvailableBalance() + amount);
        System.out.println("Sum of amount " + amount + " added successfully");

    }

    public void withdraw(Users user, double amount) {
        if (user.getAvailableBalance() >= amount) {
            user.setAvailableBalance(user.getAvailableBalance() - amount);
            System.out.println("Withdrawal successful.");
        } else {
            System.out.println("Insufficient balance.");
        }
    }

    public void checkBalance(Users user) {
        System.out.println("Current Balance: " + user.getAvailableBalance());
    }

}
