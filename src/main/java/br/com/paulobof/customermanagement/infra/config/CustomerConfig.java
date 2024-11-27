package br.com.paulobof.customermanagement.infra.config;

import br.com.paulobof.customermanagement.application.gateway.ICustomerRepository;
import br.com.paulobof.customermanagement.application.usecases.customer.*;
import br.com.paulobof.customermanagement.infra.gateway.CustomerRepositoryImpl;
import br.com.paulobof.customermanagement.infra.mapper.CustomerMapper;
import br.com.paulobof.customermanagement.infra.persistence.repository.CustomerRepository;
import br.com.paulobof.customermanagement.interfaces.controller.mapper.CustomerMapperDto;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "br.com.paulobof.customermanagement.infra.persistence.repository")
public class CustomerConfig {

    @Bean
    CreateCustomer createCustomer(ICustomerRepository customerRepository) {
        return new CreateCustomer(customerRepository);
    }

    @Bean
    GetByCustomerCode getCustomerById(ICustomerRepository customerRepository) {
        return new GetByCustomerCode(customerRepository);
    }

    @Bean
    GetAllCustomer getAllCustomer(ICustomerRepository customerRepository) {
        return new GetAllCustomer(customerRepository);
    }

    @Bean
    UpdateCustomer updateCustomer(ICustomerRepository customerRepository) {
        return new UpdateCustomer(customerRepository);
    }
    @Bean
    DeleteCustomer deleteCustomer(ICustomerRepository customerRepository) {
        return new DeleteCustomer(customerRepository);
    }

    @Bean
    CustomerRepositoryImpl customCustomerRepositoryImpl (CustomerRepository customerRepository, CustomerMapper customerEntityMapper, CustomerMapperDto customerMapperDto) {
        return new CustomerRepositoryImpl(customerRepository, customerEntityMapper, customerMapperDto);
    }

    @Bean
    CustomerMapper customerMapper() {
        return new CustomerMapper();
    }
    @Bean
    public CustomerMapperDto customerMapperDto() {
        return new CustomerMapperDto();
    }

}

