package br.com.paulobof.customermanagement.infrastructure.database;

import br.com.paulobof.customermanagement.adapters.mapper.CustomerMapper;
import br.com.paulobof.customermanagement.application.port.ICustomerRepositoryPort;
import br.com.paulobof.customermanagement.domain.entities.Customer;
import org.checkerframework.common.value.qual.EnsuresMinLenIf;

import java.util.Optional;
import java.util.stream.Collectors;

public class CustomerRepositoryAdapter implements ICustomerRepositoryPort {

    private final ICustomerJpaRepository jpaRepository;
    private final CustomerMapper mapper;

    public CustomerRepositoryAdapter(ICustomerJpaRepository jpaRepository, CustomerMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Customer save(Customer customer) {
        CustomerEntity entity = mapper.toDto(customer);
        return mapper.toEntity(jpaRepository.save(entity));
    }

    @Override
    public Optional<Customer> findByCode(Long customerCode) {
        return jpaRepository.findById(customerCode).map(mapper::toEntity);
    }

    @Override
    public EnsuresMinLenIf.List<Customer> findAll() {
        return jpaRepository.findAll().stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteByCode(Long customerCode) {
        jpaRepository.deleteById(customerCode);
    }
}

