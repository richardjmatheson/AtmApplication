package org.example;

import org.example.model.*;

import java.util.HashMap;

/**
 * Accounts is an extension of HashMap, providing a list of accounts
 * the ATM can operate on.
 * Account Number is the value used to look up accounts
 */
public class Accounts extends HashMap<Integer, Account> {
    /**
     * initializeAccountData provisions a hashmap of accounts for use with the Atm
     * Five accounts are created for use in the program
     */
    public void initializeAccountData(){


        Integer acctNum;
        Integer acctPIN;
        String fName;
        String sName;
        long initialBalance;

        acctNum = 1111;
        acctPIN = 1234;
        fName = "Adam";
        sName = "Adams";
        initialBalance = 123456;

        this.put(acctNum, new Account(acctNum, acctPIN, fName, sName, initialBalance));

        acctNum = 2222;
        acctPIN = 2345;
        fName = "Bob";
        sName = "Billings";
        initialBalance = 234567;

        this.put(acctNum, new Account(acctNum, acctPIN, fName, sName, initialBalance));

        acctNum = 3333;
        acctPIN = 3456;
        fName = "Carly";
        sName = "Collins";
        initialBalance = 345678;

        this.put(acctNum, new Account(acctNum, acctPIN, fName, sName, initialBalance));

        acctNum = 4444;
        acctPIN = 4567;
        fName = "Debbie";
        sName = "Davis";
        initialBalance = 456789;

        this.put(acctNum, new Account(acctNum, acctPIN, fName, sName, initialBalance));

        acctNum = 5555;
        acctPIN = 5678;
        fName = "Earl";
        sName = "Evans";
        initialBalance = 567890;

        this.put(acctNum, new Account(acctNum, acctPIN, fName, sName, initialBalance));
    }


}
