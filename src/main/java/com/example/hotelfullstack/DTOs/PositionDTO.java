package com.example.hotelfullstack.DTOs;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PositionDTO {
    private Long id;
    private String name;
    private Double salary;
    private String responsibilities;
}
