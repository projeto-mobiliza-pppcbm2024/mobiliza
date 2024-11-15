package dev.bcgcompany.mobiliza.repositories;

import dev.bcgcompany.mobiliza.entities.CarMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarMaintenanceRepository extends JpaRepository<CarMaintenance, Long> {

    Optional<CarMaintenance> findByCarsId(Long carId);
}
