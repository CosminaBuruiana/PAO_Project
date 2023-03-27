package entity;
public abstract class Person {

    private int idPerson = 0;
    private String name;
    private String last_name;
    private String email;

    private String CNP;

    private String phone_number;

    private String adress;

    public Person(){

    }
    public Person(String name, String last_name, String CNP,String phone_number, String adress, String email) {
        this.name = name;
        this.last_name = last_name;
        this.CNP =CNP;
        this.adress = adress;
        this.email = email;
        this.phone_number = phone_number;
    }


    public String getName() {
        return this.name;
    }

    public String getLast_name() {

        return this.last_name;
    }
    public String getAdress(){

        return this.adress;
    }

    public String getCNP(){

        return this.CNP;
    }

    public String getEmail(){

        return this.email;
    }

    public String getPhone(){

        return this.phone_number;
    }

    public void setId(int idPerson) {
        this.idPerson ++;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setCNP(String CNP) {
        this.CNP = CNP;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }
    public void setPhone(String Phone) {
        this.phone_number = phone_number;
    }

    public abstract void add();

    public abstract void remove();






}
