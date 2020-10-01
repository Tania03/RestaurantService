package com.lld.loggingFramework;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public class ProductionLoggers implements LoggerType {

    public Logger createLogger() {
        WebsiteLogger websiteLogger = new WebsiteLogger(Level.ERROR.getLevel());
        ArchiveLogger archiveLogger = new ArchiveLogger(Level.TRACE.getLevel());

        websiteLogger.setNextHandler(archiveLogger);

        return websiteLogger;
    }
}
