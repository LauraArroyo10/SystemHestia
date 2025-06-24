package com.SystemHestia.model;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medications")

public class Medicine {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identification;
    private String name;
    private String sideEffects;
    private String instructions;
    private LocalDate expirationDate;
    private Double quantity;
    @Enumerated(EnumType.STRING)
    private MedicineType medicineType;



}