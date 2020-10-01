package com.example.demo.model;

import jdk.internal.dynalink.linker.LinkerServices;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
@Getter
public class Customer {

    List<BankAccount> bankAccounts;
    String panNumber;

    public Customer() {
        this.bankAccounts = new ArrayList<>();
    }
}
