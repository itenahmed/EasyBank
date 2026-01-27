package com.easybytes.accounts.Exception;

import com.easybytes.accounts.dto.ErrorResponseDto;
import com.easybytes.accounts.dto.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

//when ever I have an exception in any controller now or in the future i should invoke a method written in this
//class

@ControllerAdvice
public class GlobalExceptionHandler {

    // Web request gets the url that causing the exception
    // webRequest.getDescription is false i only want url not the session details
    // session tells us who are we (remebers login info )

@ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorResponseDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException exception, WebRequest webRequest) {

        ErrorResponseDto errorResponseDto = new ErrorResponseDto(
                webRequest.getDescription(false),
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto, HttpStatus.BAD_REQUEST);

    }
}



