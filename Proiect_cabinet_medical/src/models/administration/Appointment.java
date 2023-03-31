package models.administration;
import java.time.LocalDate;
import java.util.UUID;

import models.entity.Doctor;
import models.entity.Patient;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder
public class Appointment {

    private UUID idAppointment;
    private LocalDate data;
    private Patient patient;
    private Doctor doctor;
    private Double price;

    public Appointment(LocalDate data, Patient patient, Doctor doctor, Double price){

        this.data = data;
        this.patient = patient;
        this.doctor = doctor;
        this.price = price;

    }

}
