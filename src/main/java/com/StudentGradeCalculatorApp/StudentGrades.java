package com.StudentGradeCalculatorApp;

import java.util.HashMap;
import java.util.Map;

public class StudentGrades {
    private final Map<Subjects, Integer> studentMarks ;

   public StudentGrades(){
        studentMarks = new HashMap<>();
    }

    public void addMarks(Subjects subject, int marks){
          studentMarks.put(subject, marks);
    }
    public int calculateTotalMarks(){
        int totalMarks =0;
        for(int marks : studentMarks.values()){
            totalMarks += marks;
        }
        return totalMarks;
    }
    public double calculateAverageMarks(int totalMarks){

       return (double) totalMarks / studentMarks.size();
    }

    public char calculatedGrade(double averageMarks){

           if(averageMarks >90){
               return 'A';
           }else if(averageMarks>= 80){
               return 'B';
           } else if (averageMarks >= 70) {
                return 'C';
           }else if(averageMarks >= 60 ){
               return 'D';
           } else if(averageMarks >= 50){
               return 'E';
           } else return 'F';
    }
    public void displayResult(){
        int totalMarks = calculateTotalMarks();
        System.out.println("Total marks of the Student: "+ totalMarks);
        double average = calculateAverageMarks(totalMarks);
        System.out.println("Average percentage marks of the student is: "+average);

        System.out.println("Final Grade: "+calculatedGrade(average));

    }


}
