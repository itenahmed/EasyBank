package com.easybytes.accounts.Service;


import com.easybytes.accounts.dto.CustomerDto;
import org.springframework.http.ResponseEntity;

public interface IAccountsService {

    /**
     * @param customerDto customerDto;as paramater expected to this method
     */
    void createAccount(CustomerDto customerDto) ;


    CustomerDto fetchAccountDetails(String mobileNumber);

    boolean updateAccount(CustomerDto customerDto);
}