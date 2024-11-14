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

    @Column(nullable=false, unique=true)
    private String name;

    @Enumerated(EnumType.STRING)
    private Gear gear;

    @Column(nullable=false)
    private Integer doors;

    @Column(nullable=false)
    private Integer seats;

    @Column(nullable=false, unique=true)
    private String phone;

    @Column(nullable=false)
    private Double price;
}
