package com.easybytes.accounts.Service;


import dto.CustomerDto;

public interface IAccountsService {

    /**
     * @param customerDto customerDto;as paramater expected to this method
     */
    void createAccount(CustomerDto customerDto) ;


}