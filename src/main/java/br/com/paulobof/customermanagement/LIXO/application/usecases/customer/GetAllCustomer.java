package br.com.paulobof.customermanagement.LIXO.application.usecases.customer;

import br.com.paulobof.customermanagement.application.gateway.ICustomerRepository;
import br.com.paulobof.customermanagement.domain.entities.Customer;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
public class GetAllCustomer {

    private final ICustomerRepository customerRepository;

    public List<Customer> getAllCustomer() {
        return customerRepository.getAllCustomer();
    }

}
