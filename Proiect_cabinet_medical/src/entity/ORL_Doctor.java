package entity;

import cure.Medicine;

import java.util.ArrayList;
import java.util.List;

public class ORL_Doctor extends Doctor{

    private List<Patient> patientList;

    static List<Medicine> medicines;

    public ORL_Doctor(){

        this.medicines = new ArrayList<Medicine>();

        this.patientList = new ArrayList<Patient>();

    }

    public static List<Medicine> getMedicines() {
        return medicines;
    }

    public List<Patient> getPatientList() {
        return patientList;
    }

    public static void setMedicines(List<Medicine> medicines) {
        ORL_Doctor.medicines = medicines;
    }

    public void setPatientList(List<Patient> patientList) {
        this.patientList = patientList;
    }
}
