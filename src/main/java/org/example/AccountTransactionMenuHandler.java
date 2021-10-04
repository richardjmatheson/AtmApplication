package org.example;

import org.example.model.Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

/**
 * AccountTransactionMenuHandler implements logic to present a list of menu options
 * to the user, allow the user to make menu selections and execute those options
 */
public class AccountTransactionMenuHandler {
    /**
     * doAccountTransactionMenuHandler implements logic to present a list of menu options
     *  * to the user, allow the user to make menu selections and execute those options
     * @param account The account on which we apply selected menu options
     */
    public void doAccountTransactionMenuHandler(Account account){
        char userEntry;

        boolean exit = false;
        // Begin loop to present menu and respond to user input
        do {
            String command;
            // Loop to log in or exit
            System.out.println("Account Transaction Menu");
            System.out.println("Enter \"B\" to view account balance");
            System.out.println("Enter \"D\" to make a deposit ");
            System.out.println("Enter \"W\" to make a withdrawal");
            System.out.println("Enter  \"X\" to Logout of this account");
            Scanner scanner = new Scanner(System.in);
            userEntry = scanner.next().charAt(0);

            command = (String.valueOf(userEntry));

            if (0 == command.compareToIgnoreCase("X")) {
                // Handle Exit command
                exit = true;
                System.out.println();
                System.out.println("Thank you " + account.getFName() + " " + account.getSName());
                System.out.println("Goodbye");
                System.out.println();
            } else if (0 == command.compareToIgnoreCase("B")) {
                // Handle View balance command
                viewBalance(account);
            } else if (0 == command.compareToIgnoreCase("D")) {
                // Handle Deposit command
                makeDeposit(account);
            } else if (0 == command.compareToIgnoreCase("W")) {
                // Handle Withdrawal command
                makeWithdrawal(account);
            } else {
                // Invalid command handler.
                System.out.println("Invalid option " + command + " selected");
                System.out.println();
            }
        } while (!exit );
    }

    /**
     * viewBalance retrieves a string representation of the Account balance and displays it.
     * @param account The account object providing the balance
     */
    private void viewBalance(Account account){
        System.out.println();
        System.out.println("Account balance: " + account.getBalanceAsString());
        System.out.println();
    }

    /**
     * makeDeposit prompts the user to enter a dollar amount to deposit, converts the input
     * to a double value as cents and calls the Account instance to update the account balance
     * @param account
     */
    private void makeDeposit(Account account){

        // Prompt user for input
        System.out.println();
        System.out.println("Enter amount to deposit: ");

        String depositInput = null;

        // Read the input value
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            depositInput = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return;
        }


        Double dblDepositAmt = null;
        try {
            // Convert the input string to a Double
            dblDepositAmt = new Double(depositInput);

            // Convert the value to cents
            dblDepositAmt *= 100;

            // Convert to long and update the account balance
            long depositAmt = dblDepositAmt.longValue();
            account.depositFunds(depositAmt);
        } catch (NumberFormatException e){
            // NumberFormatException is caught if String is not a number.
            System.out.println("Deposit input was invalid " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // IllegalArgumentException is thrown by Account.depositFunds()
            System.out.println(e.getMessage());
        }
    }

    /**
     * makeWithdrawal prompts the user to enter a dollar amount to deposit, converts the input
     * to a double value as cents and calls the Account instance to update the account balance
     * @param account
     */
    private Account makeWithdrawal(Account account){

        // Prompt user for input
        System.out.println();
        System.out.println("Enter amount to withdraw: ");

        String withdrawalInput;

        // Read the input value
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            withdrawalInput = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return account;
        }

        Double dblWithdrawalAmt = null;
        try {
            // Convert string dollar value to a Double
            dblWithdrawalAmt = new Double(withdrawalInput);

            // Convert dollar amount to cents
            dblWithdrawalAmt *= 100;

            // Update Account balance
            long withdrawalAmt = dblWithdrawalAmt.longValue();
            account.withdrawFunds(withdrawalAmt);
        } catch (NumberFormatException e){
            // NumberFormatException is caught if String is not a number.
            System.out.println("Withdrawal input was invalid " + e.getMessage());
        } catch (IllegalArgumentException e) {
            // IllegalArgumentException is thrown by Account.withdrawFunds()
            System.out.println(e.getMessage());
        }
        return account;
    }

}
