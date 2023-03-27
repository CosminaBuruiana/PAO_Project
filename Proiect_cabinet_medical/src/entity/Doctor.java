package entity;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import administration.Appointment;
import cure.Medicine;

public class Doctor extends Person {

    private Calendar hire_date;
    private int experience;
    private Double salary;
    private List<Appointment> appointmentList;
    public Doctor(){

    }
    public Doctor(String CNP, String name, String last_name, Double salary, String adress, String email, String phone_number,
                  Calendar hire_date, int experience) {
        super(name, last_name, CNP, phone_number, adress, email);
        this.salary = salary;
        this.hire_date = hire_date;
        this.experience = experience;
        this.appointmentList=new ArrayList<Appointment>();
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }

    public Double getSalary() {
        return salary;
    }

    public void setAppointmentList(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }

    public void setHire_date(Calendar hire_date) {
        this.hire_date = hire_date;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public void setRatings(List<Appointment> appointmentList) {
        this.appointmentList = appointmentList;
    }



    public Calendar getHire_date()
    {
        return this.hire_date;
    }

    public void setHire_date(){
        this.hire_date = hire_date;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getExperience()
    {
        return this.experience;
    }

    public void addAppointment(Appointment appointment){

        this.appointmentList.add(appointment);
    }

    @Override
    public void add() {

        System.out.println("Doctorul cu id-ul: " + this.getIdPerson() + " a fost angajat");
    }

    @Override
    public void remove() {

    }
}
