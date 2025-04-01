package Coding_Challenge;

public class Arrays {
    public static void main (String[] args) {
        // initializing array of numbers
        int [] numbers = {5, 10, 15, 20, 25};
        int sum = 0;
        
        //using an enhanced for loop for every elements in the numbers array
        for (int num : numbers) {
            sum += num;
        }
        
        //display the output
        System.out.println("Sum of elements: " + sum);
    }
}
