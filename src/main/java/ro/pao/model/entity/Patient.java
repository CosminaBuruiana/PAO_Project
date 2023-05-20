package ro.pao.model.entity;
import ro.pao.model.administration.Appointment;
import ro.pao.model.cure.Cure;

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

    private Appointment appointment;

    @Override
    public String toString() {
        return "Patient " + getLast_name() + " " + getName() + ": " + ", email: " + getEmail()
                + ", CNP: " + getCNP() + ", phone_number: " + getPhone_number() + ", adress: "
                + ", status: " + status + ", disease: " + disease
                + "bloodType: " + bloodType + ", medical insurance:" + medical_insurance
                + "cure: " + cure;
    }


    public Patient(String disease, String bloodType, Cure cure, String status, Boolean medical_insurance){

        this.disease = disease;
        this.bloodType = bloodType;
        this.cure = cure;
        this.status =status;
        this.medical_insurance = medical_insurance;

    }

}
