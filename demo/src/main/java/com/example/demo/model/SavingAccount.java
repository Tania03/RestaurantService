package com.example.demo.model;

import com.example.demo.enums.AccountType;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
public class SavingAccount extends BankAccount{
    @Override
    public String getType() {
        return AccountType.SAVING.getAccountType();
    }
}
