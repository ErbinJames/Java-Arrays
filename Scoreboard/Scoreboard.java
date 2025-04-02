package Scoreboard;

import java.util.Scanner;

public class Scoreboard {
    public static void main (String[] args) {
        //create scanner object
        Scanner scanner = new Scanner(System.in);

        //get user input for the number of students and subjects
        int numStudents = getValidInteger("Enter the number of students: ", scanner);
        int numSubjects = getValidInteger("Enter the number of subjects: ", scanner);

        //create a 2D array and fill the scores aray
        int scores[][] = getScores(numStudents, numSubjects, scanner);
        
        //process and display results
        displayResults(scores, numStudents, numSubjects);
        //closing scanner
        scanner.close();
    }

    //method to get user input for number of students/subjects with validation
    private static int getValidInteger(String message, Scanner scanner) {
        int number;
        while (true) {
            System.out.print(message); // Space after colon
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0) {
                    scanner.nextLine(); // Consume newline
                    return number;
                } else {
                    System.out.println("Please enter a positive number.");
                }
            } else {
                System.out.println("Invalid input! Please enter an integer.");
                scanner.next(); // Consume invalid input
            }
        }
    }

    //method to collect scores from user input
    private static int[][] getScores(int numStudents, int numSubjects, Scanner scanner) {
        System.out.println();//new line
        int[][] scores = new int[numStudents][numSubjects];

        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter scores for Student " + (i + 1) + ": ");
            for(int j = 0; j < numSubjects; j++) {
                scores[i][j] = scanner.nextInt();
            }
        }
        return scores;
    }

    //method to calculate and display total and average scores
    private static void displayResults(int[][] scores, int numStudents, int numSubjects) {
        System.out.println(); // newline

        for (int i = 0; i < numStudents; i++) {
            int total = calculateTotal(scores[i]);
            double average = calculateAverage(total, numSubjects);

            System.out.println("Student " + (i + 1) + " - Total: "+ total + ", Average: "+ String.format("%.2f", average));
        }
    }

    //method to calculate total score
    private static int calculateTotal(int[] studentScores) {
        int total = 0;
        for (int score: studentScores) {
            total += score;
        }
        return total;
    }

    //method to calculate average score
    private static double calculateAverage(int total, int numSubjects) {
        return (double) total / numSubjects;
    }
}
