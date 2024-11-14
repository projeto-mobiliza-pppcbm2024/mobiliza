package dev.bcgcompany.mobiliza.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=20, nullable=false, unique=true)
    private String name;

    @Column(length=7, nullable=false, unique=true)
    private String plate;

    @Enumerated(EnumType.STRING)
    private Gear gear;

    @Column(length=1, nullable=false)
    private Integer doors;

    @Column(length=1, nullable=false)
    private Integer seats;

    @Column(length=11, nullable=false, unique=true)
    private String phone;

    @Column(length=5, nullable=false)
    private Double price;
}
