package dev.bcgcompany.mobiliza.repositories;

import dev.bcgcompany.mobiliza.entities.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarsRepository extends JpaRepository<Cars, Long> {
    List<Cars> findByName(String name);
}
