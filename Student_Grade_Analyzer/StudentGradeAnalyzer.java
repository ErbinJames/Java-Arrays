//package Student_Grade_Analyzer;

import java.util.Scanner;

public class StudentGradeAnalyzer {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // prompt user for the number of students
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt(); // get user input

        //initialize an array to store grades
        int[] grades = new int[numStudents];
        //for loop 
        for (int i = 0; i < numStudents; i++) {
            System.out.print("Enter grade for student " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
        }

        //Initialize variables for the highest and lowest
        int highest = grades[0];
        int lowest = grades[0];
        int sum = grades[0];

        //loop through the grades array
        for (int i = 1; i < numStudents; i++) {
            if (grades[i] > highest) {
                highest = grades[i]; //update highest if grade is greater
            }
            if (grades[i] < lowest) {
                lowest = grades[i]; //update lowest if grade is smaller
            }
            sum += grades[i];
        }

        //computing average
        double average = (double)sum / numStudents;

        //display the results
        System.out.println("\nHighest Grade: " + highest);
        System.out.println("Lowest Grade: " + lowest);
        System.out.println("Average Grade: " + average);

        scanner.close();
    }
}
