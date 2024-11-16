package dev.bcgcompany.mobiliza.repositories;

import dev.bcgcompany.mobiliza.entities.Lease;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LeaseRepository extends JpaRepository<Lease, Long> {
}