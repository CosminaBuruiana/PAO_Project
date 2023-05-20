package ro.pao.model.cure;
import java.util.*;


import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Builder


public class Cure {

    private UUID idCure;
    private String name;
    private Date start_date;
    private Date end_date;
    private List<Medicine> medicineList;

    @Override
    public String toString() {
        return "Cure" + name + ", start_date:" + start_date+ ": " + ", end_date: " + end_date
                + ", Medicines: " + medicineList;
    }


}
