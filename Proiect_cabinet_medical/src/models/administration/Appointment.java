package models.administration;
import java.time.LocalDate;
import java.util.Date;
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
    private String data;
    private Double price;


    @Override
    public String toString() {
        return "Appointment: " + data +  ", Price: " + price;
    }

}
