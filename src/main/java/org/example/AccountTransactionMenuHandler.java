package org.example;

import org.example.model.Account;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Scanner;

public class AccountTransactionMenuHandler {
    public void doAccountTransactionMenuHandler(Account account){
        char userEntry;

        boolean exit = false;
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
                exit = true;
                System.out.println();
                System.out.println("Thank you " + account.getFName() + " " + account.getSName());
                System.out.println("Goodbye");
                System.out.println();
            } else if (0 == command.compareToIgnoreCase("B")) {
                account = viewBalance(account);
            } else if (0 == command.compareToIgnoreCase("D")) {
                makeDeposit(account);
            } else if (0 == command.compareToIgnoreCase("W")) {
                makeWithdrawal(account);
            } else {
                System.out.println("Invalid option " + command + " selected");
                System.out.println();
            }
        } while (!exit );
    }

    private Account viewBalance(Account account){
        System.out.println();
        System.out.println("Account balance: " + account.getBalanceAsString());
        System.out.println();

        return account;
    }

    private Account makeDeposit(Account account){


        System.out.println();
        System.out.println("Enter amount to deposit: ");

        String depositInput;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            depositInput = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return account;
        }

        BigDecimal bigDecimal = null;
        try {
            bigDecimal = new BigDecimal(depositInput, new MathContext(2, RoundingMode.HALF_UP));
            account.depositFunds(bigDecimal);
        } catch (NumberFormatException e){
            System.out.println("Deposit input was invalid " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return account;
    }

    private Account makeWithdrawal(Account account){


        System.out.println();
        System.out.println("Enter amount to withdraw: ");

        String withdrawalInput;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        try {
            withdrawalInput = bufferedReader.readLine();
        } catch (IOException e) {
            System.out.println("Exception caught: " + e.getMessage());
            return account;
        }

        BigDecimal bigDecimal = null;
        try {
            bigDecimal = new BigDecimal(withdrawalInput, new MathContext(2, RoundingMode.HALF_UP));
            account.withdrawFunds(bigDecimal);
        } catch (NumberFormatException e){
            System.out.println("Withdrawal input was invalid " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return account;
    }

}
