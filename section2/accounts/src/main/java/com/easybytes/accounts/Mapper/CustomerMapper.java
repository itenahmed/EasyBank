package com.easybytes.accounts.Mapper;

import com.easybytes.accounts.Entity.Customer;
import com.easybytes.accounts.dto.CustomerDto;

public class CustomerMapper {


    public static CustomerDto mapToCustomerDto(CustomerDto customerDto, Customer customer) {

        customerDto.setEmail(customer.getEmail());
        customerDto.setName(customer.getName());
        customerDto.setMobileNumber(customer.getMobileNumber());
        return customerDto;


    }

    public static Customer mapToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setEmail(customerDto.getEmail());
        customer.setName(customerDto.getName());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}