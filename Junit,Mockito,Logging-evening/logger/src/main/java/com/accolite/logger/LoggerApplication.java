package com.accolite.logger;

import org.apache.log4j.*;

import java.util.Scanner;

public class LoggerApplication {

    private static org.apache.log4j.Logger logger = Logger.getLogger(LoggerApplication.class);

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Scanner sc = new Scanner(System.in);
        System.out.println("Logger has been Initialize");
        System.out.println("Enter the Logger Level");
        System.out.println("Menu");
        System.out.println("1. ALL");
        System.out.println("2. DEBUG");
        System.out.println("3. INFO");
        System.out.println("4. WARN");
        System.out.println("5. ERROR");
        System.out.println("6. FATAL");
        System.out.println("7. OFF");
        System.out.println("Enter your choice");
        int ch = sc.nextInt();
        switch (ch) {
            case 1:
                logger.setLevel(Level.ALL);
                break;
            case 2:
                logger.setLevel(Level.DEBUG);
                break;
            case 3:
                logger.setLevel(Level.INFO);
                break;
            case 4:
                logger.setLevel(Level.WARN);
                break;
            case 5:
                logger.setLevel(Level.ERROR);
                break;
            case 6:
                logger.setLevel(Level.FATAL);
                break;
            case 7:
                logger.setLevel(Level.OFF);
                break;
        }
        logger.trace("Trace Message!");
        logger.debug("Debug Message!");
        logger.info("Info Message!");
        logger.warn("Warn Message!");
        logger.error("Error Message!");
        logger.fatal("Fatal Message!");
    }
}
