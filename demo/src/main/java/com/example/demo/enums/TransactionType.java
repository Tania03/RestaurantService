package com.example.demo.enums;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
public enum TransactionType {

    DEPOSIT("Deposit"), WITHDRAW("Withdraw");

    String transactionType;

    TransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getTransactionType() {
        return transactionType;
    }
}
