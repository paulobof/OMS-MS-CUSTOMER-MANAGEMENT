package br.com.paulobof.customermanagement.LIXO;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Customer {
    
    private Long customerCode;
    private String name;
    private String documentNumber;
    private String email;
    private String postalCode;
    private String address;

    public Customer(Long customerCode, String name, String documentNumber, String email, String postalCode, String address) {
        this.customerCode = customerCode;
        this.name = name;
        this.documentNumber = documentNumber;
        this.email = email;
        this.postalCode = postalCode;
        this.address = address;
    }

    public Customer(String name, String documentNumber, String email, String postalCode, String address) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.email = email;
        this.postalCode = postalCode;
        this.address = address;
    }
}
