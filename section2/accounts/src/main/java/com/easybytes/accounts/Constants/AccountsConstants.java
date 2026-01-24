package com.easybytes.accounts.Constants;

public final class AccountsConstants {


    // in order not to make any one create any constants
    private AccountsConstants() {
        // restrict instantiation
    }

    // we usually make them captial
    // static to be used by class name
    public static final String SAVINGS = "Savings";
    public static final String ADDRESS = "123 Main Street, New York";
    public static final String STATUS_201 = "201";
    public static final String MESSAGE_201 = "Account created successfully";
    public static final String STATUS_200 = "200";
    public static final String MESSAGE_200 = "Request processed successfully";
    public static final String STATUS_417 = "417";
    public static final String MESSAGE_417_UPDATE = "Update operation failed. Please try again or contact Dev team";
    public static final String MESSAGE_417_DELETE = "Delete operation failed. Please try again or contact Dev team";
    public static final String STATUS_500 = "500";
    public static final String MESSAGE_500 = "An error occurred. Please try again or contact Dev team";

}
