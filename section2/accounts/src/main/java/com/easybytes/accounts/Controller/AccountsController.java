package com.easybytes.accounts.Controller;

import com.easybytes.accounts.Constants.AccountsConstants;
import com.easybytes.accounts.Entity.Customer;
import com.easybytes.accounts.Service.IAccountsService;
import com.easybytes.accounts.dto.CustomerDto;
import com.easybytes.accounts.dto.ResponseDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/accounts",produces ={MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
public class AccountsController {
    private IAccountsService iAccountsService;
    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        iAccountsService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201))
                ;
    }
@GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchAccountDetails(@RequestParam String mobileNumber) {

      CustomerDto customerDto = iAccountsService.fetchAccountDetails(mobileNumber);
     return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateAccountDetails(@RequestBody CustomerDto customerDto) {
       boolean isUpdated = iAccountsService.updateAccount(customerDto);
       if(isUpdated) {
           return ResponseEntity.status(HttpStatus.OK).
                   body(new ResponseDto(AccountsConstants.STATUS_200, AccountsConstants.MESSAGE_200));
       }
       else{
               return  ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).
                       body(new ResponseDto(AccountsConstants.MESSAGE_500,AccountsConstants.MESSAGE_500));
           }

    }



}

