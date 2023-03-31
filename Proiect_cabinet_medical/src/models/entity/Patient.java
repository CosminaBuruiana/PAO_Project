package models.entity;
import models.cure.Cure;

import lombok.experimental.SuperBuilder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder

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
