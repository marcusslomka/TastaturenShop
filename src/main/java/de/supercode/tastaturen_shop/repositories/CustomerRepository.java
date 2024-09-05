package de.supercode.tastaturen_shop.repositories;

import de.supercode.tastaturen_shop.entities.kunde.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
