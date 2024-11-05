package dev.bcgcompany.mobiliza.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class CarMaintenance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Cars Cars;

    @Column(length=6, nullable=false, unique=false)
    private Long km;

    @Column(nullable=false, unique=false)
    private LocalDate lastMaintenance;
}
