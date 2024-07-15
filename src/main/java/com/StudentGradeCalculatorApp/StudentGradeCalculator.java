package com.StudentGradeCalculatorApp;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         StudentGrades studentGrades = new StudentGrades();
//            reading user input
         for(Subjects subject : Subjects.values()){
             int marks = -1;
             while(marks < 0 || marks >100){
                 System.out.println("Enter marks for "+subject +" ( 0 - 100 )");
                 if(scanner.hasNextInt()){
                     marks = scanner.nextInt();
                     if(marks < 0 || marks >100){
                         System.out.println("Invalid input!! Marks must be in the range");
                     } else{

                     studentGrades.addMarks(subject, marks);
                     }
                 }
             }
         }

         studentGrades.displayResult();
         scanner.close();

    }
}
