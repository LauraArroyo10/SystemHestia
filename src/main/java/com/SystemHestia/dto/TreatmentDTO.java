package com.SystemHestia.dto;

import com.SystemHestia.model.Disease;
import com.SystemHestia.model.Medicine;
import com.SystemHestia.model.Patient;
import com.SystemHestia.model.Status;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class TreatmentDTO {
    @NotBlank(message = "El campo es obligatorio")
    private Integer id;
    private Patient patient;
    private Medicine medicine;
    private Disease disease;
    private String dosage;
    private String frequency;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Status status;
    private String observations;
}
