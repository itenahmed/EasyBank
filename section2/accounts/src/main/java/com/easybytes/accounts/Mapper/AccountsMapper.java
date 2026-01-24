package com.easybytes.accounts.Mapper;

import com.easybytes.accounts.Entity.Accounts;
import dto.AccountsDto;

public class AccountsMapper {



    public static AccountsDto maptoDtos(AccountsDto accountsDto, Accounts accounts) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
        return accountsDto;
    }
    public static Accounts maptoAccounts(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
        return accounts;
    }
}
