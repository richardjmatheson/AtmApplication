package org.example;

import org.example.model.Account;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * AtmMenuHandler implements the root level ATM menu handler.
 */
public class AtmMenuHandler {
    private Accounts accounts;

    /**
     * initializeAccountData provisions a hashmap of accounts for use with the Atm
     */
    public void initializeAccountData(){
        accounts = new Accounts();

        accounts.initializeAccountData();

    }

    /**
     * doATMMenuHandler executes the command loop to present ATM menu options and process
     * user responses
     */
    public void doATMMenuHandler() {

        char userEntry;

        boolean exit = false;

        // Loop Menu to log in or exit
        do {
            String command;

            // Present menu options
            System.out.println();
            System.out.println("ATM Menu");
            System.out.println("Enter \"L\" to Log in or \"Q\" to Quit");
            System.out.println();

            // Get user response
            Scanner scanner = new Scanner(System.in);
            userEntry = scanner.next().charAt(0);

            command = (String.valueOf(userEntry));

            if (0 == command.compareToIgnoreCase("Q")) {
                // User response is to Quit ATM
                exit = true;
            } else if (0 == command.compareToIgnoreCase("L")) {
                // User response is to log in to an account
                Account account = null;
                Integer acctNumber = null;
                Integer userPIN = null;

                // Prompt user to get an account number and return
                // the account object
                try {
                    acctNumber = getAccountNumber();
                    account = getAccount(acctNumber);
                    acctNumber = account.getAcctNumber();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                // If user provided an account # prompt user to get a PIN
                if (null != acctNumber){
                    try {
                        userPIN = getPINNumber();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    // If user has provided a PIN, validate it is the PIN for the
                    // account object
                    if (null != userPIN){
                        if (userPIN.equals(account.getPIN())){
                            // Account is authenticated.
                            // Enter transaction menu.
                            System.out.println("Welcome " + account.getFName() +
                                    " " + account.getSName());
                            AccountTransactionMenuHandler accountTransactionMenuHandler = new AccountTransactionMenuHandler();
                            accountTransactionMenuHandler.doAccountTransactionMenuHandler(account);
                        } else {
                            System.out.println("Unable to authenticate account.");
                        }
                    }
                }

            } else {
                System.out.println("Invalid option " + command + " selected");
            }
        } while (!exit );
    }

    /**
     * getAccountNumber Prompts user for an account #, reads the user response and returns
     * an Account instance for the account if one exists.
     * @return Integer holding account number
     * @throws Exception Thrown if the account number entered isn't a number
     */
    private Integer getAccountNumber() throws Exception {

        // Prompts user for account #
        System.out.println();
        System.out.println("Enter account number: ");

        // Read user input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = bufferedReader.readLine();

        try {
            // Convert input to Integer and retrieve the account object
            // identified by acctNumber
            return new Integer(userInput);
        } catch (NumberFormatException e){
            // Throw an exception if the user input isn't a number
            System.out.println("Account numbers are four digit strings " + e.getMessage());
            throw(new Exception("Invalid Account Number entered"));
        }
    }

    /**
     * getAccount Returns an Account instance for the account if one exists.
     * @param acctNumber Account number for looking up account object
     * @return Account object corresponding to the user response
     * @throws Exception Thrown if acctNumber doesn't identify an Account
     */
    private Account getAccount(Integer acctNumber) throws Exception {

        // Convert input to Integer and retrieve the account object
        // identified by acctNumber
        Account account = accounts.get(acctNumber);
        if (null != account){
            return (account);
        } else {
            // Throw an exception if user response doesn't represent an account
            throw(new Exception("Invalid Account Number entered"));
        }
    }

    /**
     * getPINNumber prommpts the user for a PIN number, reads the input and returns an
     * Integer representation of the PIN number.
     * @return User PIN number as Integer
     * @throws Exception Thrown if PIN number entry is invalid
     */
    private Integer getPINNumber() throws Exception {

        // Prompt user for input
        System.out.println();
        System.out.println("Enter User PIN: ");

        // Read user input
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = bufferedReader.readLine();

        // Convert response to Integer and return
        try {
            return (new Integer(userInput));
        } catch (NumberFormatException e){
            System.out.println("User PIN can only contain numbers " + e.getMessage());
            throw(new Exception("Invalid User PIN entered"));
        }
    }


}
