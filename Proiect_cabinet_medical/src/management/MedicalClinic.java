package management;
import java.util.ArrayList;
import java.util.List;
import entity.Doctor;

public class MedicalClinic {

    private String name;

    private String adress;

    private List<Doctor> Doctors;

    public MedicalClinic(String name,String adress) {

        this.adress = adress;
        this.name = name;
        Doctors = new ArrayList<Doctor>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public void setDoctors(List<Doctor> doctors) {
        Doctors = doctors;
    }

    public List<Doctor> getDoctors() {

        return Doctors;
    }


}
