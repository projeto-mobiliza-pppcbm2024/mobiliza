package dev.bcgcompany.mobiliza.repositories;

import dev.bcgcompany.mobiliza.entities.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    Page<Car> findByRentedFalse(Pageable pageable);

    @Query("""
        SELECT c FROM Car c
        WHERE c.rented = false
        AND c.id NOT IN (
            SELECT l.car.id FROM Lease l
            WHERE (l.initialDate <= :endDate AND l.finalDate >= :startDate)
        )
    """)
    Page<Car> findAvailableCars(@Param("startDate") LocalDate startDate,
                                @Param("endDate") LocalDate endDate,
                                Pageable pageable);
}