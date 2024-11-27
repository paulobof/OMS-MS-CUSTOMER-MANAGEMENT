package br.com.paulobof.customermanagement.interfaces.controller;

import br.com.paulobof.customermanagement.application.usecases.customer.*;
import br.com.paulobof.customermanagement.domain.entities.Customer;
import br.com.paulobof.customermanagement.interfaces.controller.mapper.CustomerMapperDto;
import br.com.paulobof.customermanagement.interfaces.dto.CustomerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CreateCustomer createCustomerUseCase;
    private final GetByCustomerCode getByCustomerCodeUseCase;
    private final GetAllCustomer getAllCustomerUseCase;
    private final UpdateCustomer updateCustomerUseCase;
    private final DeleteCustomer deleteCustomerUseCase;
    /*
    private final ExistsCustomer existsCustomerUseCase;*/

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer (
            @RequestBody CustomerDto customerDto) {

        Customer customer = createCustomerUseCase.createCustomer(
                new Customer(customerDto.name(), customerDto.documentNumber(),customerDto.email(), customerDto.postalCode(), customerDto.address()));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new CustomerDto(customer.getCustomerCode(), customer.getName(), customer.getDocumentNumber(), customer.getEmail(), customer.getPostalCode(), customer.getAddress()));
    }

    @GetMapping("/{customerCode}")
    public ResponseEntity<CustomerDto> getByCustomerCode (
            @PathVariable Long customerCode) {

        Customer customer = getByCustomerCodeUseCase.getByCustomerCode(customerCode);
        CustomerDto  customerDto = CustomerMapperDto.toCustomerDto(customer);

        return ResponseEntity.status(HttpStatus.OK).body(customerDto);
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> getAllCustomer() {

        List<Customer> customers = getAllCustomerUseCase.getAllCustomer();
        List<CustomerDto> customerDtos = customers.stream()
                .map(CustomerMapperDto::toCustomerDto)
                .collect(Collectors.toList());

        return ResponseEntity.status(HttpStatus.OK).body(customerDtos);
    }

    @PutMapping("/{customerCode}")
    public ResponseEntity<CustomerDto> updateCustomer(
            @PathVariable Long customerCode,
            @RequestBody Customer customer) {

        Customer updatedCustomer = updateCustomerUseCase.updateCustomer(customerCode, customer);
        CustomerDto updatedCustomerDto = CustomerMapperDto.toCustomerDto(updatedCustomer);

        return ResponseEntity.status(HttpStatus.OK).body(updatedCustomerDto);
    }

    @DeleteMapping("/{customerCode}")
    public ResponseEntity<String> deleteCustomer(
            @PathVariable Long customerCode) {

        deleteCustomerUseCase.deleteCustomer(customerCode);

        return ResponseEntity.status(HttpStatus.OK).body("");
    }
}
