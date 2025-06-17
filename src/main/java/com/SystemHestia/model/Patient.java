package com.SystemHestia.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient extends Person implements Identifiable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String age;
    private String conditions;
    @ManyToMany
    @JoinColumn(name = "disease_id")
    private Disease diseases;
    private String allergies;

}
