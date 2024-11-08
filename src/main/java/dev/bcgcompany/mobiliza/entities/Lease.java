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
    @JoinColumn(name = "car_id")
    private Cars cars;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @Column(nullable=false)
    private LocalDate initialDate;

    @Column(nullable=false)
    private LocalDate finalDate;
}
