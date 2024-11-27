package br.com.paulobof.customermanagement.infrastructure.database;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerJpaRepository extends JpaRepository<CustomerEntity, Long> {
}
