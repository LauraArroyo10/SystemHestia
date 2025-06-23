package com.SystemHestia.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class UserDTO {

    @NotBlank(message = "El nombre no puede quedar vacío")
    private String name;

    @Email(message = "Correo no cumple la estructura") //estructura de email
    @NotBlank(message = "El correo no puede quedar vacío")
    private String email;

    @Pattern(
            regexp = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[!@#$%^&*()]).{8,}$",
            message = "Debe tener al menos 8 caracteres, incluyendo mayúsculas, minúsculas, números y caracteres especiales.")
    private String password;
    private String role;

}
