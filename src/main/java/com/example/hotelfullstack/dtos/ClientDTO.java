package com.example.hotelfullstack.dtos;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ClientDTO {
//    @Null
//    @Setter(AccessLevel.NONE)
//    private Long id;
    @NotNull(message = "Not null full name")
    private String fullName;
    @NotNull(message = "Not null passport")
    private String passport;
    @NotNull(message = "Not null phone")
    private String phone;
}
