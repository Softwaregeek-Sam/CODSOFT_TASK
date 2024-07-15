package com.StudentManagementSystem;

public class Student {
    private final String studentName;
    private final String branchName;
    private int rollNo;
    private final String phoneNumber;


    public Student(String studentName, String branchName, String phoneNumber) {
        this.studentName = studentName;
        this.branchName = branchName;
        this.phoneNumber = phoneNumber;
    }

    public String getStudentName() {
        return studentName;
    }


    public String getPhoneNumber() {
        return phoneNumber;
    }


    public String getBranchName() {
        return branchName;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Student[" +
                "studentName='" + studentName + '\'' +
                ", branch= '" + branchName + '\'' +
                ", rollNo= " + rollNo +
                ", phoneNumber='" + phoneNumber + '\'' +
                ']';
    }
}
