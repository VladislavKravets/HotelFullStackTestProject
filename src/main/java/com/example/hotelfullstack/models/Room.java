package com.example.hotelfullstack.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;
    private int capacity;
    @ManyToOne
    @JoinColumn(name = "type_room_id")
    private TypeRoom typeRoom;
    private Double cost;
    private String description;
}
