package dev.bcgcompany.mobiliza.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Payment {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "lease_id", nullable = false)
    private Lease lease;

    @Column(nullable = false)
    private Integer installments;

    @Column(nullable=false, precision = 10, scale = 2)
    private BigDecimal instalmentAmount;

    @Column(nullable=false)
    private LocalDate paymentDate;

    @Enumerated(STRING)
    @Column(nullable = false)
    private PaymentMethod paymentMethod;
}