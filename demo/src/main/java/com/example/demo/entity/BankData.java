package com.example.demo.entity;

import com.example.demo.model.BankAccount;
import com.example.demo.model.Customer;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

/**
 * @author tania.gupta
 * @date 07/08/20
 */

@Repository
@Getter
@Setter
public class BankData {

    Map<String, Customer> panNumberToCustomerMap;
    Map<String, BankAccount> bankAccountMap;

    public BankData() {
        this.panNumberToCustomerMap = new HashMap<>();
        this.bankAccountMap = new HashMap<>();
    }
}
