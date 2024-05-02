package org.jog.crudinventory.persistence.repository;

import org.jog.crudinventory.persistence.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
