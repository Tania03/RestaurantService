package com.example.demo.model;

import com.example.demo.core.BankService;
import com.example.demo.enums.TransactionType;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.constant.ErrorCode.NOT_VALID_DEPOSIT_TRANSACTION;
import static com.example.demo.constant.ErrorCode.NOT_VALID_WITHDRAWAL_TRANSACTION;

/**
 * @author tania.gupta
 * @date 07/08/20
 */

@Getter
public abstract class BankAccount {

    String accountNumber;
    Double minimumBalance;
    Double currentBalance;
    Double interestRate;
    List<Transaction> transactionList;

    @Autowired
    BankService bankService;

    public synchronized void withdraw(Double amount) throws Exception{

        if(!bankService.validateWithdrawal(amount, minimumBalance, currentBalance))
            throw new Exception(NOT_VALID_WITHDRAWAL_TRANSACTION);

        currentBalance -=amount;
        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.WITHDRAW);
        transaction.setAmount(amount);

        if(transactionList.isEmpty()) {
            transaction.setTransactionId("1");
        } else {
            int transactionId = Integer.parseInt(transactionList.get(transactionList.size() - 1).transactionId) + 1;
            transaction.setTransactionId(String.valueOf(transactionId));
        }

    }

    public synchronized void deposit(Double amount) throws Exception{

        if(!bankService.validateDeposit(amount))
            throw new Exception(NOT_VALID_DEPOSIT_TRANSACTION);

        currentBalance +=amount;

        Transaction transaction = new Transaction();
        transaction.setTransactionType(TransactionType.DEPOSIT);
        transaction.setAmount(amount);

        if(transactionList.isEmpty()) {
            transaction.setTransactionId("1");
        } else {
            int transactionId = Integer.parseInt(transactionList.get(transactionList.size() - 1).transactionId) + 1;
            transaction.setTransactionId(String.valueOf(transactionId));
        }

    }

    public List<Transaction> getTransactionHistory(){
        return transactionList;
    }

    public List<Transaction> getMiniStatement(){

        List<Transaction> miniStatement = new ArrayList<>();

        int i = transactionList.size() - 1;
        int count = 10;

        while(count > 0){
            miniStatement.add(transactionList.get(i));
            i--;
            count--;
        }

        return  miniStatement;

    }

    public abstract String getType();
}
