package br.com.paulobof.customermanagement.adapters.mapper;

import br.com.paulobof.customermanagement.adapters.controller.dto.CustomerDto;
import br.com.paulobof.customermanagement.domain.entities.Customer;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto(Customer customer);

    Customer toEntity(CustomerDto customerDto);
}
