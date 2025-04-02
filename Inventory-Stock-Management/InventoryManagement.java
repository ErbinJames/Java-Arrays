import java.util.Arrays;
import java.util.Scanner;

public class InventoryManagement {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        //initialize the stock array
        int[] stock = {10, 25, 14, 30, 5, 18, 22, 40, 12, 8};

        //display initial stock levels
        displayStock(stock);

        //update stock
        updateStock(stock,scanner);

        int highest = findHighest(stock);
        int lowest = findLowest(stock);

        //display highest and lowest stock
        System.out.println("Highest stock: " + highest);
        System.out.println("Lowest Stock: " + lowest);
        
        //close scanner
        scanner.close();
    }
    // method to display stock levels
    public static void displayStock(int[] stock) {
        System.out.println("Current stock levels: ");
        System.out.println(Arrays.toString(stock));
        System.out.println();
    }
    
    //method to update stock levels
    public static void updateStock(int[] stock, Scanner scanner) {
        
        System.out.print("Enter the product index to update (0-9): ");
        int index = scanner.nextInt();

        //Ask for new stock value
        System.out.print("Enter the new stock value: ");
        int newStock = scanner.nextInt();
        System.out.println();

        //update the stock
        stock[index] = newStock;

        //dipslay the updated stock levels 
        System.out.println("Updated stock levels: ");
        System.out.println(Arrays.toString(stock));
        System.out.println(); //new line
    }
    
    //method to find the highest stock
    public static int findHighest(int[] stock) {
        int highest = stock[0];
        for (int i = 1; i < stock.length; i++){
            if (stock[i] > highest) {
                highest = stock[i];
            }
        }
        return highest;
    }
    //method to find the lowest stock
    public static int findLowest(int[] stock) {
        int lowest = stock[0];
        for (int i = 1; i < stock.length; i++) {
            if (stock[i] < lowest) {
                lowest = stock[i];
            }
        }
        return lowest;
    }
}
