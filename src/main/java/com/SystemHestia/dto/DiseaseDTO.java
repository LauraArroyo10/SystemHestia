package com.SystemHestia.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DiseaseDTO {
    private Integer id;
    private String name;
    private String description;
    private String recommendation;
}
