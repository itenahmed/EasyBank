package com.easybytes.accounts.Service;


import com.easybytes.accounts.dto.CustomerDto;

public interface IAccountsService {

    /**
     * @param customerDto customerDto;as paramater expected to this method
     */
    void createAccount(CustomerDto customerDto) ;


}