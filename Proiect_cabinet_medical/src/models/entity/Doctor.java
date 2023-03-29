package models.entity;
import java.time.LocalDate;
import java.util.List;
import lombok.experimental.SuperBuilder;
import models.administration.Appointment;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder

public class Doctor extends Person {

    private LocalDate hire_date;
    private Integer experience;
    private Double salary;
    private List<Appointment> appointmentList;

}
