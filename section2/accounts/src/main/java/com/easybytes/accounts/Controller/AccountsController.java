package com.easybytes.accounts.Controller;

import com.easybytes.accounts.Constants.AccountsConstants;
import dto.CustomerDto;
import dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
public class AccountsController {
    @GetMapping("sayhello")
    public String sayHello() {
        return "hi World";
    }
    @PutMapping("/createaAccount")
    public ResponseEntity<ResponseDto> createAccount( @RequestBody CustomerDto customerDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201))
                ;
    }
}
