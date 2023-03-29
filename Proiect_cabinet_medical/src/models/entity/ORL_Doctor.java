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

public class ORL_Doctor extends Doctor{

    private List<Patient> patientList;

    static List<Medicine> medicines;


}
