package br.com.paulobof.customermanagement.LIXO.application.gateway;

import br.com.paulobof.customermanagement.domain.entities.Customer;

import java.util.List;

public interface ICustomerRepository {

    Customer createCustomer(Customer customerEntity);

    List<Customer> getAllCustomer();

    Customer getByCustomerCode(Long customerCode);

    Customer updateCustomer(Long customerCode, Customer customerEntity);

    void deleteCustomer(Long customerCode);

    Boolean existsCustomer(Long customerCode);
}
