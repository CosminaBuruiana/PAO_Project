package models.cure;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;


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
    private LocalDate start_date;
    private LocalDate end_date;
    private List<Medicine> medicineList;

    public Cure(LocalDate start_date, LocalDate end_date, String name){

        this.name = name;
        this.start_date = start_date;
        this.end_date = end_date;
        this.medicineList = new ArrayList<Medicine>();
    }
}
