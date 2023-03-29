package models.entity;
import models.cure.Cure;


import lombok.*;
import models.entity.Person;

import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class Patient extends Person {

    private String status;
    private String disease;
    private String bloodType;
    private Boolean medical_insurance;
    private Cure cure;

    public Patient(String disease, String bloodType, Cure cure, String status, Boolean medical_insurance){

        this.disease = disease;
        this.bloodType = bloodType;
        this.cure = cure;
        this.status =status;
        this.medical_insurance = medical_insurance;

    }

}
