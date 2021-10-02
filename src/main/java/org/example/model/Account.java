package org.example.model;

import lombok.*;
import java.math.BigDecimal;
import java.math.RoundingMode;


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
    private BigDecimal balance;

    public BigDecimal depositFunds(BigDecimal depositAmount) throws IllegalArgumentException {
        if (0 > depositAmount.doubleValue()){
            throw new IllegalArgumentException("Can't deposit a negative value");
        } else {
            balance = balance.add(depositAmount);
        }
        return balance;
    }

    public BigDecimal withdrawFunds(BigDecimal withdrawalAmount)  throws IllegalArgumentException {
        if ( 0 > (balance.doubleValue() - withdrawalAmount.doubleValue())){
            throw new IllegalArgumentException("Insufficient funds");
        } else {
            balance = balance.subtract(withdrawalAmount);
        }
        return balance;
    }

    public String getBalanceAsString(){
        double value = balance.setScale(2, RoundingMode.HALF_UP).doubleValue();
        return ("$\t" + String.format("%.2f", value));
    }



}
