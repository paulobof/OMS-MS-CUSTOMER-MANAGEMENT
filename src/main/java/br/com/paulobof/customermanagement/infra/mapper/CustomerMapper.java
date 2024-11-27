package br.com.paulobof.customermanagement.infra.mapper;

import br.com.paulobof.customermanagement.domain.entities.Customer;
import br.com.paulobof.customermanagement.infra.persistence.entities.CustomerEntity;

public class CustomerMapper {

    public CustomerEntity toEntity(Customer customer) {
        return new CustomerEntity(
                customer.getName(),
                customer.getDocumentNumber(),
                customer.getEmail(),
                customer.getPostalCode(),
                customer.getAddress()
        );
    }

    public Customer toCustomer(CustomerEntity customerEntity) {
        return new Customer(
                customerEntity.getCustomerCode(),
                customerEntity.getName(),
                customerEntity.getDocumentNumber(),
                customerEntity.getEmail(),
                customerEntity.getPostalCode(),
                customerEntity.getAddress()
        );
    }

}
