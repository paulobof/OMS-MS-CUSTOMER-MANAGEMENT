package br.com.paulobof.customermanagement.LIXO.application.usecases.customer;

import br.com.paulobof.customermanagement.application.gateway.ICustomerRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DeleteCustomer {

    private final ICustomerRepository customerRepository;

    public void deleteCustomer(Long customerCode){
        customerRepository.deleteCustomer(customerCode);
    }
}
