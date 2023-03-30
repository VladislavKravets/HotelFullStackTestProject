package com.example.hotelfullstack.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "type_rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
}
