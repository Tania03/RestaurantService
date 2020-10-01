package com.lld.loggingFramework;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class MainLogger {

    public static void main(String[] args) {

        Environment environment = Environment.Staging;

        LoggerType loggerType = LoggerFactory.getLogger(environment);
        Logger logger = loggerType.createLogger();

        System.out.println("Current Environment : " + environment);
        System.out.println();

        logger.log(Level.TRACE, "This is trace");
        System.out.println();

        logger.log(Level.DEBUG, "This is a debugger");
        System.out.println();

        logger.log(Level.INFO, "This is an information");
        System.out.println();

        logger.log(Level.ERROR, "This is an error");
        System.out.println();

        logger.log(Level.SEVERE, "This is a severe");
    }


}
