package org.example;

import org.example.model.Account;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class AtmMenuHandler {
    private Accounts accounts;
    private Console console;

    /**
     * initializeAccountData provisions a hashmap of accounts for use with the Atm
     */
    public void initializeAccountData(){
        accounts = new Accounts();

        accounts.initializeAccountData();

    }

    public void doATMMenuHandler() throws IOException {


        char userEntry;

        boolean exit = false;
        do {
            String command;
            // Loop to log in or exit
            System.out.println();
            System.out.println("ATM Menu");
            System.out.println("Enter \"L\" to Log in or \"Q\" to Quit");
            System.out.println();
            Scanner scanner = new Scanner(System.in);
            userEntry = scanner.next().charAt(0);

            command = (String.valueOf(userEntry));

            if (0 == command.compareToIgnoreCase("Q")) {
                exit = true;
            } else if (0 == command.compareToIgnoreCase("L")) {
                Account account = null;
                Integer acctNumber = null;
                Integer userPIN = null;
                // Get an account number
                try {
                    account = getAccount();
                    acctNumber = account.getAcctNumber();
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }

                if (null != acctNumber){
                    try {
                        userPIN = getPINNumber();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }

                    if (null != userPIN){
                        if (userPIN.equals(account.getPin())){
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

    protected Account getAccount() throws Exception {

        System.out.println();
        System.out.println("Enter account number: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = bufferedReader.readLine();

        try {
            Integer acctNumber = new Integer(userInput);
            Account account = accounts.get(acctNumber);
            if (null != account){
                return (account);
            } else {
                throw(new Exception("Invalid Account Number entered"));
            }
        } catch (NumberFormatException e){
            System.out.println("Account numbers are four digit strings " + e.getMessage());
            throw(new Exception("Invalid Account Number entered"));
        }
    }

    protected Integer getPINNumber() throws Exception {

        System.out.println();
        System.out.println("Enter User PIN: ");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = bufferedReader.readLine();

        try {
            Integer userPIN = new Integer(userInput);
            return (userPIN);
        } catch (NumberFormatException e){
            System.out.println("User PIN can only contain numbers " + e.getMessage());
            throw(new Exception("Invalid User PIN entered"));
        }
    }


}
