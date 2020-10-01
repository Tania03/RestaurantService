package com.example.demo.core;

import org.springframework.stereotype.Service;

/**
 * @author tania.gupta
 * @date 07/08/20
 */

@Service
public class BankServiceImpl implements BankService{
    @Override
    public boolean validateWithdrawal(Double amount, Double minimumBalance, Double currentBalance) {

        return currentBalance - amount < minimumBalance;

    }

    @Override
    public boolean validateDeposit(Double amount) {
        return amount > 0;
    }
}
