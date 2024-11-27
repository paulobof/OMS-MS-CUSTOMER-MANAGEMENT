package br.com.paulobof.customermanagement.infrastructure.database;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Objects;
@Entity
@Table(name = "customers")
@Data
public class CustomerEntity {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PostgreSQL suporta sequence automaticamente
    private Long customerCode;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(nullable = false, unique = true, length = 14)
    private String documentNumber;

    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @Column(nullable = true, length = 20)
    private String postalCode;

    @Column(nullable = true, length = 255)
    private String address;

}
