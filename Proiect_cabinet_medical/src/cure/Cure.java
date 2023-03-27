package cure;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


//import lombok.AllArgsConstructor;
//import lombok.Getter;


//@Getter
//@AllArgsConstructor

public class Cure {

    private Integer idCure = 0;
    private Calendar start_date;
    private Calendar end_date;
    private List<Medicine> medicineList;

    public Cure(){

    }

    public Cure(Integer idCure,Calendar start_date, Calendar end_date){

        this.idCure = idCure;
        this.start_date = start_date;
        this.end_date = end_date;
        this.medicineList = new ArrayList<Medicine>();
    }

    public Integer getIdCure() {
        return idCure;
    }

    public void setIdCure(Integer idCure) {
        this.idCure = idCure;
    }

    public List<Medicine> getMedicineList() {
        return medicineList;
    }

    public void setMedicineList(List<Medicine> medicineList) {
        this.medicineList = medicineList;
    }

    public void addMedicine(Medicine medicine){
        this.medicineList.add(medicine);
    }
}

//import lombok.*;
//
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.util.Calendar;
//import java.util.List;
//import java.util.UUID;
//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@EqualsAndHashCode
//@ToString
//@Builder
//public class Cure {
//    private UUID ID;
//
//    private LocalDate start_date;
//    private LocalDate end_date;
//    private List<Medicine> medicineList;
//
//}