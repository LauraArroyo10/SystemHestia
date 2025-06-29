package com.SystemHestia.dto;

import com.SystemHestia.model.Medicine;
import com.SystemHestia.model.Patient;
import com.SystemHestia.model.Report;
import com.SystemHestia.model.Treatment;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;



    @Getter
    @Setter
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    @Entity
    public class ReportDTO {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;

        private String title;
        private String date;
        private String category;
        private  String  description;

//        private Treatment treatment;

        private Integer patientId;
//        private String patientName;
//
//        private Medicine medicine;







    }



