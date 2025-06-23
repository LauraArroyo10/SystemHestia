package com.SystemHestia.model;


import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "patients")
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private String conditions;
    private String allergies;
    private String description;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    //@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "disease_id", nullable = true)
    private Disease primaryDisease;



    private String name;



    @Column(name = "role")
    private String role;



}
