package ro.pao.model.administration;
import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import ro.pao.model.entity.Doctor;
import ro.pao.model.entity.Patient;
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
    private Date data;
    private Double price;
    private UUID id_doctor;


    @Override
    public String toString() {
        return "Appointment: " + data +  ", Price: " + price;
    }

}
