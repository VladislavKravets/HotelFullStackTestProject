package com.example.hotelfullstack.DTOs;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EmployeeDTO {
    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private char sex;
    private String phone;
    private Long positionId;
}
