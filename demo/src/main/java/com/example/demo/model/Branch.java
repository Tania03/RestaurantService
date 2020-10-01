package com.example.demo.model;

import com.example.demo.core.BranchService;
import com.example.demo.entity.BankData;
import com.example.demo.entity.BranchData;
import com.example.demo.enums.AccountType;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
public class Branch {

    List<BankAccount> bankAccounts;
    List<Customer> customers;
    String branchId;

    @Autowired
    BankData bankData;

    @Autowired
    BranchService branchService;

    @Autowired
    BranchData branchData;


    public Branch(String branchId) {
        this.branchId = branchId;
        this.bankAccounts = new ArrayList<>();
        this.customers = new ArrayList<>();
    }

    public void createBankAccount(String panNumber, AccountType accountType, Double amount) throws Exception {

        BankAccount bankAccount = branchService.validateMinimumAmount(accountType, amount);
        bankAccount.currentBalance = amount;

        Customer customer = bankData.getPanNumberToCustomerMap().get(panNumber);


        if(customer != null && customers.contains(customer)){

            List<BankAccount> bankAccounts = customer.getBankAccounts();

            int bankAccountNumber = Integer.parseInt(customer.
                            getBankAccounts().get(bankAccounts.size() - 1).accountNumber) + 1;
            bankAccount.accountNumber = String.valueOf(bankAccountNumber);
            customer.getBankAccounts().add(bankAccount);
        }else{
            Customer newCustomer = new Customer();
            bankAccount.accountNumber = "1";
            customer.getBankAccounts().add(bankAccount);
            customers.add(newCustomer);
        }

    }

    public Customer getCustomerByPanNumber(String panNumber){

        return bankData.getPanNumberToCustomerMap().get(panNumber);
    }

    public BankAccount getAccountByAccountNumber(String accountNumber){

        return bankData.getBankAccountMap().get(accountNumber);
    }
}
