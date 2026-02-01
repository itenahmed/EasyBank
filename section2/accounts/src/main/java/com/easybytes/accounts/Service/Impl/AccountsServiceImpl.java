package com.easybytes.accounts.Service.Impl;
import com.easybytes.accounts.Constants.AccountsConstants;
import com.easybytes.accounts.Entity.Customer;
import com.easybytes.accounts.Entity.Accounts;
import com.easybytes.accounts.Exception.CustomerAlreadyExistsException;
import com.easybytes.accounts.Exception.ResourceNotFoundException;
import com.easybytes.accounts.Mapper.AccountsMapper;
import com.easybytes.accounts.Mapper.CustomerMapper;
import com.easybytes.accounts.Repository.AccountsRepository;
import com.easybytes.accounts.Repository.CustomerRepository;
import com.easybytes.accounts.Service.IAccountsService;
import com.easybytes.accounts.dto.AccountsDto;
import com.easybytes.accounts.dto.CustomerDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountsServiceImpl implements IAccountsService {

    private AccountsRepository  accountsRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if(optionalCustomer.isPresent()){
            throw new CustomerAlreadyExistsException("customer Already exists with this mobile number"+" "+customer.getMobileNumber());
        }
        Customer savedCustomer =customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }



    public Accounts createNewAccount(Customer customer){
        Accounts account = new Accounts();
        account.setCustomerId(customer.getCustomerId());
        account.setAccountType(AccountsConstants.SAVINGS);
      /*  Long accNumber =1000000000L+ new Random().nextInt(900000000);
        account.setAccountNumber(accNumber); */
        account.setBranchAddress(AccountsConstants.ADDRESS);
        account.setCreatedBy("admin");

  return account;
    }

    @Override
    public CustomerDto fetchAccountDetails(String mobileNumber) {
       Customer customer= customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                ()-> new ResourceNotFoundException("Customer","mobile number", mobileNumber));

     Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
             ()-> new ResourceNotFoundException("Account","CustomerId", customer.getCustomerId().toString()));

       CustomerDto customerDto = CustomerMapper.mapToCustomerDto(new CustomerDto(), customer);
        AccountsDto accountsDto= AccountsMapper.maptoDtos(new AccountsDto(),accounts);
        customerDto.setAccountsDto(accountsDto);

        return customerDto;
    }
}
