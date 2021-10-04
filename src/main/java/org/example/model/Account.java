package org.example.model;

import lombok.*;

@AllArgsConstructor
@Data
/**
 * Account model represents data items describing a bank account
 */
public class Account {
    /**
     * Account number
     */
    private final Integer acctNumber;

    /**
     * Account PIN
     */
    private final Integer pin;

    /**
     * First Name
     */
    private final String fName;

    /**
     * Surname
     */
    private final String sName;

    /**
     * Account Balance.  Can't drop below 0.
     * Lombok overrides to prevent lombok generated setter
     */
    @Setter(value=AccessLevel.NONE)
    private long balance;

    public long depositFunds(long depositAmount) throws IllegalArgumentException {
        if (0 > depositAmount){
            throw new IllegalArgumentException("Can't deposit a negative value");
        } else {
            balance = balance + depositAmount;
        }
        return balance;
    }

    public long withdrawFunds(long withdrawalAmount)  throws IllegalArgumentException {
        if (0 > withdrawalAmount){
            throw new IllegalArgumentException("Can't withdraw a negative value");
        } else if ( 0 > (balance - withdrawalAmount)){
            throw new IllegalArgumentException("Insufficient funds");
        } else {
            balance = balance - withdrawalAmount;
        }
        return balance;
    }

    /**
     * Returns the balance value formatted as a dollar value with 2 decimal places.
     * @return
     */
    public String getBalanceAsString(){
        double value = (double)balance / 100;
        return ("$\t" + String.format("%.2f", value));
    }
}
