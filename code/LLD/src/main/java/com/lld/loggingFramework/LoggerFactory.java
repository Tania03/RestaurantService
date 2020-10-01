package com.lld.loggingFramework;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class LoggerFactory {


    public static LoggerType getLogger(Environment production) {

        switch (production) {

            case Production:
                return new ProductionLoggers();
            case Staging:
                return new StagingLoggers();
            default:
                throw new IllegalStateException("Unexpected value: " + production);
        }

    }
}
