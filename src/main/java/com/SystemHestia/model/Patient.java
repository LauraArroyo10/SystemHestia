package com.SystemHestia.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Patient{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer age;
    private String conditions;
    private String allergies;
    private String description;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "disease_id", nullable = false)
    private Disease primaryDisease;

    @JsonProperty("name")
    private String name;


    @JsonProperty("role")
    @Enumerated(EnumType.STRING)
    private Role role;


}
