package br.com.paulobof.customermanagement.LIXO.interfaces.controller.mapper;

import br.com.paulobof.customermanagement.LIXO.interfaces.dto.CustomerDto;
import br.com.paulobof.customermanagement.domain.entities.Customer;

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

