package br.com.paulobof.customermanagement.LIXO.infra.gateway;

import br.com.paulobof.customermanagement.application.gateway.ICustomerRepository;
import br.com.paulobof.customermanagement.domain.entities.Customer;
import br.com.paulobof.customermanagement.infra.mapper.CustomerMapper;
import br.com.paulobof.customermanagement.infra.persistence.entities.CustomerEntity;
import br.com.paulobof.customermanagement.LIXO.infra.persistence.repository.CustomerRepository;
import br.com.paulobof.customermanagement.LIXO.interfaces.controller.mapper.CustomerMapperDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class CustomerRepositoryImpl  implements ICustomerRepository {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    private final CustomerMapperDto customerMapperDto;

    public Customer createCustomer(Customer customer) {
        CustomerEntity customerEntity = customerMapper.toEntity(customer);
        return customerMapper.toCustomer( customerRepository.save(customerEntity));
    }

    public Customer getByCustomerCode(Long customerCode) {
        CustomerEntity customerEntity = customerRepository.findById(customerCode)
                .orElseThrow( () -> new EntityNotFoundException("Customer not found"));
        return customerMapper.toCustomer(customerEntity);
    }

    public List<Customer> getAllCustomer() {
        List<CustomerEntity> customers  = customerRepository.findAll();
        return customers.stream()
                .map(customerMapper::toCustomer)
                .collect(Collectors.toList());
    }

    public Customer updateCustomer(Long customerCode, Customer customer) {
        CustomerEntity customerEntity = customerMapper.toEntity(customer);
        customerEntity.setCustomerCode(customerCode);
        CustomerEntity updatedEntity = customerRepository.save(customerEntity);
        return customerMapper.toCustomer(updatedEntity);
    }

    public void deleteCustomer(Long customerCode) {
        customerRepository.deleteById(customerCode);
    }

    public  Boolean existsCustomer(Long customerCode) {
        return customerRepository.existsById(customerCode);
    }

}
