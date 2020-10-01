package com.example.demo.model;

import ch.qos.logback.classic.layout.TTLLLayout;
import com.example.demo.enums.TransactionType;
import lombok.Getter;
import lombok.Setter;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
@Getter
@Setter
public class Transaction {

    String transactionId;
    Double amount;
    TransactionType transactionType;

    public Transaction() {
    }

    public Transaction(String transactionId) {
        this.transactionId = transactionId;
    }
}
