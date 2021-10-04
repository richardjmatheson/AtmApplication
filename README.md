# AtmApplication
This repository contains the code solution for my SailPoint coding exercise.

The project is implemented as a Maven project in IntelliJ.  You should be able to build it with any Maven-enabled Java environment, such as Eclipse.  I was able to import the export the project to Eclipse and use it there.

I made a slight modification to the requirements, and added an Account number to the Account data model.  A PIN isn't usually a unique value, but one that is user supplied.  The resulting workflow is that if a user wants to Log in to the ATM, they are prompted for an Account number, and then a PIN.  If an account that corresponds to the account number exists and has a matching PIN, the user is successfully logged in and can perform transactions to View their balance, Deposit funds, or Withdraw funds.

There are Spock/Groovy unit tests for the Account model.  The solution can be executed from IntelliJ or Eclipse.

Also, an executable Jar is provided in targets/AtmApplication.jar
Use java -jar AtmApplication.jar to execute it.  Note that the jar was built using openjdk version "16.0.2" 2021-07-20, and will require at least that version to execute.

There is a 'canned' Accounts collection that is provisioned when the ATM application is started up.  Note that account balances are stored as cents, rather than dollars and sense.  

Acct Number | PIN   | First Name  | Surname   | Balance

1111        | 1234  | Adam        | Adams     | 123456

2222        | 2345  | Bob         | Billings  | 234567 

3333        | 3456  | Carly       | Collins   | 345678

4444        | 4567  | Debbie      | Davis     | 456789

5555        | 5678  | Earl        | Evans     | 567890


