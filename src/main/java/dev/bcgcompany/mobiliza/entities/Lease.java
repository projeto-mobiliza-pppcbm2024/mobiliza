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
public class Lease {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private Cars Cars;

    @ManyToOne
    @JoinColumn(name = "id")
    private Users Users;

    @Column(name="INITIAL_DATE", nullable=false, unique=false)
    private LocalDate initial_date;

    @Column(name="FINAL_DATE", nullable=false, unique=false)
    private LocalDate final_date;
}
