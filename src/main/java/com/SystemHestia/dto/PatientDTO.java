package com.SystemHestia.dto;

import com.SystemHestia.model.Disease;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PatientDTO {
    private Integer id;
    private Integer age;
    private String conditions;
    private String allergies;
    private String description;
    private DiseaseDTO primaryDisease;
    private String name;
    private String role;
}//class end


