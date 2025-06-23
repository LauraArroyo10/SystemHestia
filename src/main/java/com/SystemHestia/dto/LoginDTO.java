package com.SystemHestia.dto;

import jakarta.persistence.Column;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class LoginDTO {
    @Column(unique = true)
    private String email;
    private String password;

}
