package dev.bcgcompany.mobiliza.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable=false, unique=true)
    private String name;

    @Enumerated(STRING)
    private Gear gear;

    @Column(nullable=false)
    private Integer doors;

    @Column(nullable=false)
    private Integer seats;

    @Column(nullable=false, unique=true)
    private String phone;

    @Column(nullable=false, precision = 10, scale = 2)
    private BigDecimal price;
}