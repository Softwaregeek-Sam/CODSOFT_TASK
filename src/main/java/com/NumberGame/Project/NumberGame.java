package com.NumberGame.Project;



import java.util.Random;
import java.util.Scanner;

public class NumberGame {
    static int attemptLimit = 5;

    public static void playGame(Scanner scanner) {
        Random random = new Random();
        int randomNum = random.nextInt(100);
        int currentAttempt = 0;
        int score = 0;

        System.out.println("Tell me the number you have guessed:");

        while (currentAttempt < attemptLimit) {
            int userGuess = -1;
            while (userGuess < 1 || userGuess > 100) {
                if (scanner.hasNextInt()) {
                    userGuess = scanner.nextInt();
                    if (userGuess < 1 || userGuess > 100) {
                        System.out.println("Please guess a number between 1 and 100.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and 100.");
                    scanner.next(); // Consume invalid input
                }
            }
            currentAttempt++;

            if (userGuess == randomNum) {
                score += 10;
                System.out.println("Bulls eye!! You got 10 points");
                break;
            } else if (Math.abs(randomNum - userGuess) <= 10) {
                score += 1;
                System.out.println("Close! You got 1 point.");
            }

            if (currentAttempt < attemptLimit) {
                System.out.println((attemptLimit - currentAttempt) + " more attempts left. Guess again:");
            } else {
                System.out.println("Oops!! No more attempts left.");
            }
        }

        System.out.println("Game Over!! \nYour final score: " + score);
        System.out.println("The correct number was: " + randomNum);

        // Validate play again input
        while (true) {
            System.out.println("Wanna play again? (Yes / No):");
            String play = scanner.next();
            if (play.equalsIgnoreCase("yes")) {
                playGame(scanner);
                break;
            } else if (play.equalsIgnoreCase("no")) {
                System.out.println("Exiting the Game. Goodbye!");
                break;
            } else {
                System.out.println("Invalid input. Please enter 'yes' or 'no'.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("<--- Welcome to the Number Game!!! --->");
        System.out.println();
        System.out.println("""
                Guess the number I have generated in the range 1 to 100 and score points!
                Correct guess means 10 points.
                If the difference is less than or equal to 10, you will get 1 point or none.
                """);
        System.out.println(""" 
                           ---- Let's get started! ----
                           Press yes to Start the Game
                           Press NO to exit !""");
        System.out.println();
            String option = scanner.next();
            if(option.equalsIgnoreCase("Yes")){
                playGame(scanner);
            }else{
                return;
            }

        scanner.close();
    }
}


