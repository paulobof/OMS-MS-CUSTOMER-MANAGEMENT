package br.com.paulobof.customermanagement.application.usecases.customer;

import br.com.paulobof.customermanagement.application.gateway.ICustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteCustomer {

    private final ICustomerRepository customerRepository;

    public void deleteCustomer(Long customerCode){
        customerRepository.deleteCustomer(customerCode);
    }
}
