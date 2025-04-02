import java.util.Scanner;

public class WithdrawalSystem {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        //initialize the bank accounts with balances
        int[] balances = {5000, 3000, 1000, 2000, 7500};

        // Call method to display available accounts
        displayAccounts(balances);

        //account selection
        int selectedAccount = getAccount(scanner);

        // show the current balance of the selected account
        showBalance(balances, selectedAccount);

        //ask for transaction type (withdraw or deposit)
        int transactionType = getTransactionType(scanner);

        if (transactionType == 1) {
            // Handle withdrawal transaction
            int withdrawAmount = getWithdrawalAmount(scanner);
            // Continue asking for a valid withdrawal amount until the user provides a valid amount
            while (!isValidWithdrawal(balances[selectedAccount], withdrawAmount)) {
                System.out.println("Insufficient funds! Please enter a valid amount.");
                withdrawAmount = getWithdrawalAmount(scanner);
            }
            // Process the withdrawal once the amount is valid
            processWithdrawal(balances, selectedAccount, withdrawAmount);
        } else if (transactionType == 2) {
            int depositAmount = getDepositAmount(scanner);
            processDeposit(balances,selectedAccount, depositAmount);
        }
        //close scanner
        scanner.close();
    }
    //method to display all available accounts
    public static void displayAccounts(int[] balances) {
        System.out.println("Available accounts: ");
        for (int i = 0; i < balances.length; i++) {
            System.out.println("["+ i + "] Account " + (i + 1));
        }
    }
    //method to get the account index selected by the user
    public static int getAccount(Scanner scanner) {
        System.out.println();//newline
        System.out.print("Enter account index (0-4):" );
        int selectedAccount = scanner.nextInt();
        return selectedAccount;
    }
    //method to show the balance of the selected account
    public static void showBalance(int[] balances, int selectedAccount) {
        System.out.println("Current balance: " + balances[selectedAccount]);
        System.out.println();//newline
    }
    //method to get the transaction type (withdraw or deposit)
    public static int getTransactionType(Scanner scanner) {
        System.out.print("Enter transaction type (1-Withdraw, 2-Deposit): ");
        int transactionType = scanner.nextInt();
        return transactionType;
    }
    //method to get the withdrawal amount
    public static int getWithdrawalAmount(Scanner scanner) {
        System.out.print("Enter amount to withdraw: ");
        int withdrawAmount = scanner.nextInt();
        return withdrawAmount;
    }
    //method to validate withdrawal
    public static boolean isValidWithdrawal(int balance, int withdrawAmount) {
        return withdrawAmount <= balance; // to check if withdrawal is valid
    }
    // method to process withdrawal
    public static void processWithdrawal(int[] balances, int selectedAccount, int withdrawAmount) {
        balances[selectedAccount] -= withdrawAmount;
        System.out.println();//newline
        System.out.println("Transaction successful!");
        System.out.println("New balance: " + balances[selectedAccount]);
    }
    //method to get the deposit amount
    public static int getDepositAmount(Scanner scanner) {
        System.out.print("Enter amount to deposit: ");
        int depositAmount = scanner.nextInt();
        return depositAmount;
    }
    //method to process deposit
    public static void processDeposit(int[] balances, int selectedAccount, int depositAmount){
        balances[selectedAccount] += depositAmount;
        System.out.println();//newline
        System.out.println("Transaction successful!");
        System.out.println("New balance: " + balances[selectedAccount]);
    }
}
