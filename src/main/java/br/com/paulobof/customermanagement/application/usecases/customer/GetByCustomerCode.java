package br.com.paulobof.customermanagement.application.usecases.customer;

import br.com.paulobof.customermanagement.application.gateway.ICustomerRepository;
import br.com.paulobof.customermanagement.domain.entities.Customer;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class GetByCustomerCode {

    private final ICustomerRepository customerRepository;

    public Customer getByCustomerCode(Long customerCode){
        return customerRepository.getByCustomerCode(customerCode);
    }
}
