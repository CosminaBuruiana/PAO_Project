package models.entity;
import models.cure.Medicine;
import java.util.List;
import lombok.experimental.SuperBuilder;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@SuperBuilder


public class Ophthalmologist extends Doctor{

    public List<Patient> patientList;
    static List<Medicine> medicines;



}
