package dev.bcgcompany.mobiliza.repositories;

import dev.bcgcompany.mobiliza.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
}