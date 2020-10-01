package com.example.demo.constant;

import org.omg.CORBA.DynAnyPackage.Invalid;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
public class ErrorCode {

    public static final String INSUFFICIENT_OPENING_BALANCE = "Insufficient Opening Balance";
    public static final String NOT_VALID_WITHDRAWAL_TRANSACTION = "Invalid withdrawal transaction, balance cannot be negative";
    public static final String NOT_VALID_DEPOSIT_TRANSACTION = "Deposit Amount cannot be negative";
}
