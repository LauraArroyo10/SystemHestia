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
    private String age;
    private String conditions;
    private Disease diseases;
    private String allergies;
}
