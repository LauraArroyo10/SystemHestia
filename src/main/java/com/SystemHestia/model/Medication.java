package com.SystemHestia.model;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor

public class Medication implements Identifiable{

    private Integer id;
    private String identification;
    private String name;
    private String expirationDate;
    private String quantity;
    private String sideEffects;
    private String instructions;
    private String type;

}
