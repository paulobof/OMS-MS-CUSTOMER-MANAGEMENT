package br.com.paulobof.customermanagement.application.usecase;


import br.com.paulobof.customermanagement.application.port.ICustomerRepositoryPort;
import br.com.paulobof.customermanagement.domain.entities.Customer;
import br.com.paulobof.customermanagement.domain.exceptions.CustomerNotFoundException;

import java.util.List;

public class CustomerCrudUseCase {

    private final ICustomerRepositoryPort repository;

    public CustomerCrudUseCase(ICustomerRepositoryPort repository) {
        this.repository = repository;
    }

    public Customer createCustomer(Customer customer) {
        return repository.save(customer);
    }

    public Customer findCustomerByCode(Long customerCode) {
        return repository.findCustomerByCode(customerCode)
                .orElseThrow(() -> new CustomerNotFoundException(customerCode));
    }

    public List<Customer> listCustomers() {
        return repository.findAll();
    }

    public Customer updateCustomer(Long customerCode, Customer updatedCustomer) {
        Customer customer = findCustomerByCode(customerCode);

        // Usando um padrão builder com record
        customer = customer.toBuilder()
                .name(updatedCustomer.getName())
                .documentNumber(updatedCustomer.getDocumentNumber())
                .email(updatedCustomer.getEmail())
                .postalCode(updatedCustomer.getPostalCode())
                .address(updatedCustomer.getAddress())
                .build();

        return repository.save(customer);
    }

    public void deleteCustomer(Long customerCode) {
        if (!repository.findCustomerByCode(customerCode).isPresent()) {
            throw new CustomerNotFoundException(customerCode);
        }
        repository.deleteByCode(customerCode);
    }
}
