package com.lld.loggingFramework;

/**
 * @author tania.gupta
 * @date 12/07/20
 */
public enum Environment {

    Production("Production"), Staging("Staging"), Development("Development");

    String environment;

    Environment(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }
}
