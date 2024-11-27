package br.com.paulobof.customermanagement.domain.exceptions;

public class CustomerNotFoundException extends RuntimeException {
    public CustomerNotFoundException(Long customerCode) {
        super("Customer not found with Code: " + customerCode);
    }
}
