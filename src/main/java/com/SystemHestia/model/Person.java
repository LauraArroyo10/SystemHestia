package com.SystemHestia.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class Person {
    @JsonProperty("name")
    String name;
    @JsonProperty("role")
    @Enumerated(EnumType.STRING)
    Role role;

}//class end