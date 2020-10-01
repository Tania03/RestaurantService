package com.example.demo.core;

import com.example.demo.enums.AccountType;
import com.example.demo.model.BankAccount;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
public interface BranchService {


    BankAccount validateMinimumAmount(AccountType accountType, double amount) throws Exception;
}
