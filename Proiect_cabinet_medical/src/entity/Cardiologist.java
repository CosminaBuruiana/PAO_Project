package entity;

import cure.Medicine;

import java.util.ArrayList;
import java.util.List;

public class Cardiologist extends Doctor {

    public List<Patient> patientList;
    static List<Medicine> medicines;

    public Cardiologist(){

        this.medicines = new ArrayList<Medicine>();

        this.patientList = new ArrayList<Patient>();
    }

    public static void setMedicines(List<Medicine> medicines) {
        Cardiologist.medicines = medicines;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public static List<Medicine> getMedicines() {
        return medicines;
    }
}
