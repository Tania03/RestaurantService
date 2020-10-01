package com.example.demo.model;

import com.example.demo.enums.AccountType;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
public class CurrentAccount extends BankAccount{


    public CurrentAccount() {
        this.minimumBalance = 20000.0;
        this.interestRate = 0.0;
    }

     public String getType() {
        return AccountType.CURRENT.getAccountType();
    }
}
