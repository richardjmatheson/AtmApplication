package org.example;

import org.example.model.Account;

import java.math.BigDecimal;
import java.util.HashMap;

public class Accounts extends HashMap<Integer, Account> {
    /**
     * initializeAccountData provisions a hashmap of accounts for use with the Atm
     */
    public void initializeAccountData(){

        // Provision sample accounts
        Account account;

        Integer acctNum;
        Integer acctPIN;
        String fName;
        String sName;
        BigDecimal initialBalance;

        acctNum = 1111;
        acctPIN = 1234;
        fName = "Adam";
        sName = "Adams";
        initialBalance = new BigDecimal(1234.56);

        this.put(acctNum, new Account(acctNum, acctPIN, fName, sName, initialBalance));

        acctNum = 2222;
        acctPIN = 2345;
        fName = "Bob";
        sName = "Billings";
        initialBalance = new BigDecimal(2345.67);

        this.put(acctNum, new Account(acctNum, acctPIN, fName, sName, initialBalance));

        acctNum = 3333;
        acctPIN = 3456;
        fName = "Carly";
        sName = "Collins";
        initialBalance = new BigDecimal(3456.78);

        this.put(acctNum, new Account(acctNum, acctPIN, fName, sName, initialBalance));

        acctNum = 4444;
        acctPIN = 4567;
        fName = "Debbie";
        sName = "Davis";
        initialBalance = new BigDecimal(4567.89);

        this.put(acctNum, new Account(acctNum, acctPIN, fName, sName, initialBalance));

        acctNum = 5555;
        acctPIN = 5678;
        fName = "Earl";
        sName = "Evans";
        initialBalance = new BigDecimal(5678.90);

        this.put(acctNum, new Account(acctNum, acctPIN, fName, sName, initialBalance));
    }


}
