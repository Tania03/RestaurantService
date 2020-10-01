package com.example.demo.enums;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
public enum AccountType {

    CURRENT("Current"), SAVING("Saving");

    String accountType;

    AccountType(String accountType) {
        this.accountType = accountType;
    }

    public String getAccountType() {
        return accountType;
    }
}
