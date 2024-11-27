package br.com.paulobof.customermanagement.adapters.controller;

import br.com.paulobof.customermanagement.adapters.controller.dto.CustomerDto;
import br.com.paulobof.customermanagement.adapters.mapper.CustomerMapper;
import br.com.paulobof.customermanagement.application.usecase.CustomerCrudUseCase;
import br.com.paulobof.customermanagement.domain.entities.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerCrudUseCase useCase;
    private final CustomerMapper mapper;

    public CustomerController(CustomerCrudUseCase useCase, CustomerMapper mapper) {
        this.useCase = useCase;
        this.mapper = mapper;
    }

    @PostMapping
    public ResponseEntity<CustomerDto> createCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer = mapper.toEntity(customerDto);
        Customer createdCustomer = useCase.createCustomer(customer);
        return ResponseEntity.ok(mapper.toDto(createdCustomer));
    }

    @GetMapping("/{customerCode}")
    public ResponseEntity<CustomerDto> getCustomer(@PathVariable Long customerCode) {
        Customer customer = useCase.findCustomerByCode(customerCode);
        return ResponseEntity.ok(mapper.toDto(customer));
    }

    @GetMapping
    public ResponseEntity<List<CustomerDto>> listCustomers() {
        List<Customer> customers = useCase.listCustomers();
        List<CustomerDto> customerDtos = customers.stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(customerDtos);
    }

    @PutMapping("/{customerCode}")
    public ResponseEntity<CustomerDto> updateCustomer(
            @PathVariable Long customerCode,
            @RequestBody CustomerDto customerDto) {
        Customer customer = mapper.toEntity(customerDto);
        Customer updatedCustomer = useCase.updateCustomer(customerCode, customer);
        return ResponseEntity.ok(mapper.toDto(updatedCustomer));
    }

    @DeleteMapping("/{customerCode}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerCode) {
        useCase.deleteCustomer(customerCode);
        return ResponseEntity.noContent().build();
    }
}
