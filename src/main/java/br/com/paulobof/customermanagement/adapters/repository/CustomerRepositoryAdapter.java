package br.com.paulobof.customermanagement.adapters.repository;


import br.com.paulobof.customermanagement.domain.entities.Customer;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerRepositoryAdapter implements ICustomerRepositoryPort {

    private final CustomerJpaRepository jpaRepository;
    private final CustomerMapper mapper;

    public CustomerRepositoryAdapter(CustomerJpaRepository jpaRepository, CustomerMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Customer save(Customer customer) {
        var entity = mapper.toDto(customer);
        return mapper.toEntity(jpaRepository.save(entity));
    }

    @Override
    public Optional<Customer> findByCode(Long customerCode) {
        return jpaRepository.findById(customerCode).map(mapper::toEntity);
    }

    @Override
    public List<Customer> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByCode(Long customerCode) {
        jpaRepository.deleteById(customerCode);
    }
}
