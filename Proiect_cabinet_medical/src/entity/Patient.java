package entity;
import cure.Cure;

public class Patient extends Person {

    private String status;
    private String disease;
    private String bloodType;
    private String medical_insurance;
    private Cure cure;
    public Patient(){

    }

    public Patient(String disease, String bloodType, Cure cure, String status, String medical_insurance){

        this.disease = disease;
        this.bloodType = bloodType;
        this.cure = cure;
        this.status =status;
        this.medical_insurance = medical_insurance;

    }
    public String getDisease(){
        return this.disease;
    }

    public Cure getCure() {
        return cure;
    }

    public String getMedical_insurance() {
        return medical_insurance;
    }

    public void setMedical_insurance(String medical_insurance) {
        this.medical_insurance = medical_insurance;
    }

    public void setCure(Cure cure) {
        this.cure = cure;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public String getBloodType() {
        return bloodType;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }
    @Override
    public void add() {

    }

    @Override
    public void remove() {

    }


}
