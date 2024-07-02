package com.app.bankinc.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long customerId) {
        super("Customer with ID " + customerId + " not found");
    }
}
