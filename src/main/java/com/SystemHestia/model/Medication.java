package com.SystemHestia.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "medications")
public class Medication{
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String identification;
    private String name;
    private String sideEffects;
    private String instructions;
    private String type;
    private LocalDate expirationDate;
    private BigDecimal quantity;


}