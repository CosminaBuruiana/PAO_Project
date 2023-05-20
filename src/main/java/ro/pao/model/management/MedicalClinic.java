package ro.pao.model.management;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import ro.pao.model.entity.Doctor;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder

public class MedicalClinic {

    private UUID Id;
    private String name;

    private String adress;

    private List<Doctor> Doctors;

    public MedicalClinic(String name,String adress) {

        this.adress = adress;
        this.name = name;
        Doctors = new ArrayList<Doctor>();
    }

}
