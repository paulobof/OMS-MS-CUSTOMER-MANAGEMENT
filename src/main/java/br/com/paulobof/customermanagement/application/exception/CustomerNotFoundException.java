package br.com.paulobof.customermanagement.application.exception;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long custumerCode) {
        super("Customer with code " + custumerCode + " was not found");
    }
}
