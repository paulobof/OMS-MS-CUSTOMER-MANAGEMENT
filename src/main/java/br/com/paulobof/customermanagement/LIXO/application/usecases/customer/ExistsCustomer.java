package br.com.paulobof.customermanagement.LIXO.application.usecases.customer;

import br.com.paulobof.customermanagement.application.gateway.ICustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ExistsCustomer {

    private final ICustomerRepository customerRepository;

    public boolean existsCustomer(Long customerCode){
        return customerRepository.existsCustomer(customerCode);
    }

}
