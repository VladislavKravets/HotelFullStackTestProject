package com.example.hotelfullstack.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    @Setter(AccessLevel.NONE)
    private Long id;
    private int capacity;
    private Long typeRoomId;
    private Double cost;
    private String description;
}
