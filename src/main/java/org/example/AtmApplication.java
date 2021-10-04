package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;


/**
 * AtmApplication
 *
 */
public class AtmApplication
{
    private static Logger logger = LoggerFactory.getLogger(AtmApplication.class);

    public static void main( String[] args )
    {
        logger.info("Starting ATM");

        AtmMenuHandler atmMenuHandler = new AtmMenuHandler();

        atmMenuHandler.initializeAccountData();
        try {
            atmMenuHandler.doATMMenuHandler();
        } catch (IOException ioe){
            System.out.println("Caught Exception: " + ioe.getMessage());
        }


        logger.info("ATM Application finished");
    }
}
