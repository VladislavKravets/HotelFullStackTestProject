package com.example.hotelfullstack.models;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "employees")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    //String uuid = UUID.randomUUID().toString();
    private String fullName;
    private LocalDate dateOfBirth;
    private char sex;
    private String phone;
    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position positionId;
}
