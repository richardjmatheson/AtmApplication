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
@SpringBootApplication
public class AtmApplication implements CommandLineRunner
{
    private static Logger logger = LoggerFactory.getLogger(AtmApplication.class);

    public static void main( String[] args )
    {
        logger.info("Starting ATM");
        SpringApplication.run(AtmApplication.class, args);
        logger.info("ATM Application finished");
    }

    @Override
    public void run (String ... args) {
        logger.info("Executing Command Line Runner");

        for (int i = 0; i < args.length; ++i) {
            logger.info("args[{}]: {}", i, args[i]);
        }
        AtmMenuHandler atmMenuHandler = new AtmMenuHandler();

        atmMenuHandler.initializeAccountData();
        try {
            atmMenuHandler.doATMMenuHandler();
        } catch (IOException ioe){
            System.out.println("Caught Exception: " + ioe.getMessage());
        }
   }
}
