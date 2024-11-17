package dev.bcgcompany.mobiliza.repositories;

import dev.bcgcompany.mobiliza.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Page<Car> findByRentedFalse(Pageable pageable);
}