package dev.bcgcompany.mobiliza.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length=50, nullable=false)
    private String name;

    @Column(length=50, nullable=false, unique=true)
    private String email;

    @Column(length=10, nullable=false, unique=true)
    private String cpf;

    @Column(length=256, nullable=false)
    private String password;

    @Column(length=10, nullable=false, unique=true)
    private String cnh;

    @Column(length=11, nullable=false, unique=true)
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
