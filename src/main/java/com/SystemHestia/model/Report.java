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

   @ManyToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "patient_id", nullable = false)
   private Patient patient;
   private Medicine medicine;

   // Si luego vas a usar estas relaciones
   // @ManyToOne(fetch = FetchType.EAGER)
   // @JoinColumn(name = "treatment_id", nullable = true)
   // private Treatment treatment;

   // @ManyToOne(fetch = FetchType.EAGER)
   // @JoinColumn(name = "medicine_id", nullable = true)
   // private Medicine medicine;

}
