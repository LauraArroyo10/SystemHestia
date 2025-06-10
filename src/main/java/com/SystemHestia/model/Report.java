package com.SystemHestia.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

//es nuestra entidad

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Report implements  Identifiable {
@Id
@GeneratedValue  (strategy = GenerationType.IDENTITY)

   //atributos agregar mas
   private Integer Id;

   private String title;
   private String date;
   private String category;


}
