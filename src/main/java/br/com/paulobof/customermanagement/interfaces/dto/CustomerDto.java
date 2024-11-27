package br.com.paulobof.customermanagement.interfaces.dto;


import lombok.Builder;

@Builder
public record CustomerDto (

    Long customerCode,
    String name,
    String documentNumber,
    String email,
    String postalCode,
    String address

) {}
