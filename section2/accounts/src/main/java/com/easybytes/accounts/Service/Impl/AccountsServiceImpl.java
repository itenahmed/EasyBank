package com.easybytes.accounts.Service.Impl;

import com.easybytes.accounts.Repository.AccountsRepository;
import com.easybytes.accounts.Repository.CustomerRepository;
import com.easybytes.accounts.Service.IAccountsService;
import dto.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository  accountsRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
