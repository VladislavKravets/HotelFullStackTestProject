package com.example.hotelfullstack.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

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
    private Long id;
    private String name;
}
