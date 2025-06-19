package com.SystemHestia.dto;

import com.SystemHestia.model.MedicineType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class MedicineDTO {
    private Integer id;
    private String identification;
    private String name;
    private String sideEffects;
    private String instructions;
    private LocalDate expirationDate;
    private BigDecimal quantity;
    private MedicineType medicineType;
}
