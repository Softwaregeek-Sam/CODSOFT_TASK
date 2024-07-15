package com.StudentManagementSystem;

import java.util.Scanner;

public class StudentManagementSystem {
    public static void main(String[] args) {
        StudentManagementServices services = new StudentManagementServices();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("Welcome to Student Management!!");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Update Student");
            System.out.println("4. Find Student details:");
            System.out.println("5. Display Student");
            System.out.println("6. Exit");
            System.out.println();
            System.out.print("Enter your choice ");

            int choice = getIntInput(scanner);
            switch (choice) {
                case 1:
                    addStudent(services, scanner);
                    break;
                case 2:
                    removeStudent(services, scanner);
                    break;
                case 3:
                    updateStudent(services, scanner);
                    break;
                case 4:
                    findStudent(services, scanner);
                    break;
                case 5:
                    services.displayAllStudent();
                    break;
                case 6:
                    System.out.println("Exiting program bye");
                    services.close();
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice please enter a valid choice!");
            }

        }
    }

    private static void addStudent(StudentManagementServices services, Scanner scanner) {
        System.out.print("Enter Student Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter branch Name: ");
        String branchName = scanner.nextLine();
        String phoneNumber;
        while (true) {
            System.out.print("Enter your 10 digit phone phoneNumber: ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.matches("\\d{10}")) {
                break;
            } else {
                System.out.println("Invalid phone Number. Please enter 10 digit phone number: ");
            }
        }

        Student newStudent = new Student(name, branchName, phoneNumber);
        int rollNo = services.addStudent(newStudent);
        if (rollNo != -1) {
            System.out.println("Student added successfully. Your Roll No is: " + rollNo);
        } else {
            System.out.println("Failed to enroll student");
        }

    }

    private static void removeStudent(StudentManagementServices services, Scanner scanner) {
        System.out.print("Enter student's roll number to remove: ");
        int rollNo = getIntInput(scanner);
        boolean isRemoved = services.removeStudent(rollNo);
        if (isRemoved) {
            System.out.println("Student remove successful!");
        } else {
            System.out.println("No record found");
        }
    }

    private static void updateStudent(StudentManagementServices services, Scanner scanner) {
        System.out.print("Enter student roll number to update: ");
        int rollNo = getIntInput(scanner);
        Student existingStudent = services.findStudent(rollNo);

        if (existingStudent == null) {
            System.out.println(" No such student exist ");
            return;
        }
        String phoneNumber;
        while (true) {
            System.out.print("Enter new Phone number: ");
            phoneNumber = scanner.nextLine();
            if (phoneNumber.isEmpty()) {
                phoneNumber = existingStudent.getPhoneNumber();
                break;
            } else if (phoneNumber.matches("\\d{10}")) {
                break;
            } else {
                System.out.println("Invalid Phone Number. Please enter valid phone number: ");
            }
        }
        boolean isUpdated = services.updateStudent(rollNo, phoneNumber);
        if (isUpdated) {
            System.out.println("Phone number updated successfully. ");
        } else {
            System.out.println("Failed to update number");
        }
    }

    private static void findStudent(StudentManagementServices services, Scanner scanner) {
        System.out.print("Enter student's roll number to find: ");
        int rollNo = getIntInput(scanner);
        Student foundStudent = services.findStudent(rollNo);

        if (foundStudent != null) {
            System.out.println("The student details are: ");
            System.out.println(foundStudent);
        } else {
            System.out.println("No record found!!");
        }
    }

    private static int getIntInput(Scanner scanner) {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input please enter a valid roll number");
            scanner.next();
        }
        int input = scanner.nextInt();
        scanner.nextLine();
        return input;
    }

}
