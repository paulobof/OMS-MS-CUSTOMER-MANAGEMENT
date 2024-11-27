package br.com.paulobof.customermanagement.LIXO.application.usecases.customer;

import br.com.paulobof.customermanagement.application.gateway.ICustomerRepository;
import br.com.paulobof.customermanagement.domain.entities.Customer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class UpdateCustomer {

    private final ICustomerRepository customerRepository;

    public Customer updateCustomer(Long customerCode, Customer customer){
        return customerRepository.updateCustomer(customerCode, customer);
    }
}
