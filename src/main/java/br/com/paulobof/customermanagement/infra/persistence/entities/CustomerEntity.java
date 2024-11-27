package br.com.paulobof.customermanagement.infra.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "customer")
@Table(name = "customers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerCode;

    private  String name;

    private String documentNumber;

    private String email;

    private String postalCode;

    private String address;

    public CustomerEntity(String name, String documentNumber, String email, String postalCode, String address) {
        this.name = name;
        this.documentNumber = documentNumber;
        this.email = email;
        this.postalCode = postalCode;
        this.address = address;
    }
}
