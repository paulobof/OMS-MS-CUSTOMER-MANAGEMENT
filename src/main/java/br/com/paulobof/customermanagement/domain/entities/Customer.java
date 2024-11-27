package br.com.paulobof.customermanagement.domain.entities;

import lombok.Builder;

@Builder
public record Customer (

    Long customerCode,

    String name,

    String documentNumber,

    String email,

    String postalCode,

    String address

) {

}
