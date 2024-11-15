package dev.bcgcompany.mobiliza.repositories;

import dev.bcgcompany.mobiliza.entities.Payment;
import dev.bcgcompany.mobiliza.entities.PaymentStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByLeaseId(Long leaseId);
    List<Payment> findByStatus(PaymentStatus status);
}
