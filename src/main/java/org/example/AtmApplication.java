package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


/**
 * AtmApplication class provides main method to launch AtmApplication logic
 *
 */
public class AtmApplication
{
    /**
     * main method invoked by Java to start program logic.
     * @param args No command line args are expected
     */
    public static void main( String[] args )
    {
        System.out.println("Starting ATM");

        // Instantiate root level ATM menu handler
        AtmMenuHandler atmMenuHandler = new AtmMenuHandler();

        // Initialize canned list of accounts for ATM to operate on.
        atmMenuHandler.initializeAccountData();
        // Start the ATM menu handler
        atmMenuHandler.doATMMenuHandler();

        System.out.println("ATM Application finished");
    }
}
