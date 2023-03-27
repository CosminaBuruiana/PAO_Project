package entity;

import cure.Medicine;

import java.util.ArrayList;
import java.util.List;

public class Ophthalmologist extends Doctor{

    public List<Patient> patientList;
    static List<Medicine> medicines;

    public Ophthalmologist(){


        this.medicines = new ArrayList<Medicine>();

        this.patientList = new ArrayList<Patient>();
    }


}
