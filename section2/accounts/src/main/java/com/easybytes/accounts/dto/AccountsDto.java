package com.easybytes.accounts.dto;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class AccountsDto {
    @NotEmpty(message = "Account number must not be empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Account Number must be 10 digits")
    private Long accountNumber;
    @NotEmpty(message = "AccountType number must not be empty")
    private String accountType;
    @NotEmpty(message = "BranchAddress number must not be empty")
    private String branchAddress;



}