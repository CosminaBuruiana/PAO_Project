package models.entity;
import lombok.experimental.SuperBuilder;
import models.cure.Medicine;
import java.util.List;
import lombok.*;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder


public class Cardiologist extends Doctor {

    public List<Patient> patientList;
    static List<Medicine> medicines;

}

