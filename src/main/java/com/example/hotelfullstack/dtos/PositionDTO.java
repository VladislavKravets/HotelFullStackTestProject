package com.example.hotelfullstack.dtos;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PositionDTO {
    @Setter(AccessLevel.NONE)
    private Long id;
    private String name;
    private Double salary;
    private String responsibilities;
}
