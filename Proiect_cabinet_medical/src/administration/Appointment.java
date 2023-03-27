package administration;
import java.util.Calendar;

import entity.Doctor;
import entity.Patient;

public class Appointment {

    private Integer idAppointment = 0;
    private Calendar data;
    private Patient patient;
    private Doctor doctor;
    private Double price;

    public Appointment(){

    }

    public Appointment(int idAppointment, Calendar data, Patient patient, Doctor doctor, Double price){

        this.idAppointment = idAppointment;
        this.data = data;
        this.patient = patient;
        this.doctor = doctor;
        this.price = price;

    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return price;
    }
    public void setData(Calendar data) {
        this.data = data;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
    public void setIdAppointment(Integer idAppointment){
        this.idAppointment = idAppointment;
    }

    public Patient getPatient() {
        return patient;
    }

    public Calendar getData() {
        return data;
    }

    public Integer getIdAppointment() {
        return idAppointment;
    }

    public Doctor getDoctor() {
        return doctor;
    }
}
