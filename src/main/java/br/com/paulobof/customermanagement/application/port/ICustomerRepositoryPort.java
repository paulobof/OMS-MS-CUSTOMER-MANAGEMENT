package br.com.paulobof.customermanagement.application.port;

import br.com.paulobof.customermanagement.domain.entities.Customer;

import java.util.List;

public class ICustomerRepositoryPort {

    Customer save(Customer customer);

    Customer findCustomerByCode(Long customerCode);

    List<Customer> findAll();

    void deleteByCode(Long customerCode);

}

