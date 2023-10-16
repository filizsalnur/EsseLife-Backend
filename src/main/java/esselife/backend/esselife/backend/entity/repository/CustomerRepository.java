package esselife.backend.esselife.backend.entity.repository;

import esselife.backend.esselife.backend.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
    Customer findByName(String name);
}