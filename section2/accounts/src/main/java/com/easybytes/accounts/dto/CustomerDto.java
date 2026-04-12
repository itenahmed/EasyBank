package com.easybytes.accounts.dto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
@NotEmpty(message="Name can't be empty")
@Size(min =3 , max=30,message = "Name must be between 3 and 30")
    private String name;
@NotEmpty(message="Email can't be empty")
@Email(message = "Email must be in a valid format")
    private String email;
@Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    private String mobileNumber;
    private AccountsDto accountsDto;



}
