package com.example.demo.core;

import com.example.demo.enums.AccountType;
import com.example.demo.model.BankAccount;
import com.example.demo.model.CurrentAccount;
import com.example.demo.model.SavingAccount;
import org.springframework.stereotype.Service;

import static com.example.demo.constant.ErrorCode.INSUFFICIENT_OPENING_BALANCE;

/**
 * @author tania.gupta
 * @date 07/08/20
 */
@Service
public class BranchServiceImpl implements BranchService {

    @Override
    public BankAccount validateMinimumAmount(AccountType accountType, double amount) throws Exception{

        BankAccount bankAccount = null;

        String openingAccountType = accountType.getAccountType();
        if(openingAccountType.equals(AccountType.CURRENT.getAccountType())){
            bankAccount = new CurrentAccount();
            if(amount < bankAccount.getMinimumBalance())
                throw new Exception(INSUFFICIENT_OPENING_BALANCE);
        }else if(openingAccountType.equals(AccountType.SAVING.getAccountType())) {
            bankAccount = new SavingAccount();
            if (amount < bankAccount.getMinimumBalance())
                throw new Exception(INSUFFICIENT_OPENING_BALANCE);

        }

        return bankAccount;
    }
}
