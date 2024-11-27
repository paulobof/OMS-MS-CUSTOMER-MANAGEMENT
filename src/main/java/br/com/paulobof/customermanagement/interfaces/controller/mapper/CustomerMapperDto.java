package br.com.paulobof.customermanagement.interfaces.controller.mapper;

import br.com.paulobof.customermanagement.domain.entities.Customer;
import br.com.paulobof.customermanagement.interfaces.dto.CustomerDto;

public class CustomerMapperDto {

    public static CustomerDto toCustomerDto(Customer customer) {
        return new CustomerDto(
                customer.getCustomerCode(),
                customer.getName(),
                customer.getDocumentNumber(),
                customer.getEmail(),
                customer.getPostalCode(),
                customer.getAddress()
                );
    }



}

