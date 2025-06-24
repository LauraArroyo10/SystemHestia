package com.SystemHestia.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "reports")
public class Report {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id;
   private String title;
   private String date;
   private String category;
   private String description;

   @ManyToOne()
   @JoinColumn(name = "treatment_id", nullable = false)
   private Treatment treatment;

//   @ManyToOne()
//   @JoinColumn(name = "patient_id", nullable = false)
//   private Patient patient;
//
//   @ManyToOne()
//   @JoinColumn(name = "medicine_id", nullable = false)
//   private Medicine medicine;



}
