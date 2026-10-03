package com.easybytes.cards.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import jakarta.validation.constraints.Pattern;

//this is a lomobok annotation generated setters and getters 
@Data
public class CardsDto {

    @NotEmpty(message = "Mobile Number can not be a null or empty")
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    private String mobileNumber;
    private String cardNumber;
    private String cardType;
    private int totalLimit;
    private int amountUsed;
    private int availableAmount;

}
