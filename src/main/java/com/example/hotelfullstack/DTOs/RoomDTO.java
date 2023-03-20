package com.example.hotelfullstack.DTOs;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RoomDTO {
    Long id;
    int capacity;
    Long typeRoomId;
    Double cost;
    String description;
}
