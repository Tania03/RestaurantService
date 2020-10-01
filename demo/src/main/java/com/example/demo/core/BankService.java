package com.example.demo.core;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
public interface BankService {

    public boolean validateWithdrawal(Double amount, Double minimumBalance, Double currentBalance);

    boolean validateDeposit(Double amount);
}
