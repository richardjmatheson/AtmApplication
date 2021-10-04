package org.example.model;

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
     * The balance is stored in cents, not dollars and sense.
     * This is to prevent loss and rounding errors.
     */
    private long balance;

    /**
     * Constructor for Account class
     * @param acctNumber Account number of the account
     * @param pin PIN number for the account
     * @param fName Account holder first name
     * @param sName Account holder surname
     * @param balance Account balance in cents
     */
    public Account (Integer acctNumber, Integer pin, String fName, String sName, long balance) {
        this.acctNumber = acctNumber;
        this.pin = pin;
        this.fName = fName;
        this.sName = sName;
        this.balance = balance;
    }

    /**
     * getAcctNumber returns an Integer representation of the account #
     * @return Account number
     */
    public Integer getAcctNumber() {
        return acctNumber;
    }

    /**
     * getPIN returns an Integer representation of the account PIN
     * @return PIN Number
     */
    public Integer getPIN() {
        return pin;
    }

    /**
     * getFName returns the First Name for the account
     * @return Account holder first name
     */
    public String getFName() {
        return (fName);
    }

    /**
     * getSName returns the Surname Name for the account
     * @return Account holder surname
     */
    public String getSName () {
        return (sName);
    }

    /**
     * depositFunds acts as a setter for the balance of the account
     * depositFunds accepts a positive value for cents and adds that value
     * to the current balance
     * @param depositAmount Positive value of the deposit in cents
     * @return Updated balance
     * @throws IllegalArgumentException Thrown if depositAmount is negative
     */
    public long depositFunds(long depositAmount) throws IllegalArgumentException {
        if (0 > depositAmount){
            throw new IllegalArgumentException("Can't deposit a negative value");
        } else {
            balance = balance + depositAmount;
        }
        return balance;
    }

    /**
     * withdrawFunds acts as a setter for the balance of the account
     * withdrawFunds accepts a positive value for cents and subtracts that
     * from the current balance.
     *
     * @param withdrawalAmount Positive value of the deposit in cents.  Must not exceed the current balance.
     * @return Updated balance
     * @throws IllegalArgumentException Thrown if withdrawal amount is negative or exceeds balance
     */
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
     * Generates a String representation of the balance value formatted as a dollar value with 2 decimal places.
     * @return String representation of balance formatted as $XXX.XX
     */
    public String getBalanceAsString(){
        double value = (double)balance / 100;
        return ("$\t" + String.format("%.2f", value));
    }
}
