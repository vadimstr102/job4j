package ru.job4j.oop;

public class Profession {
    private String name;
    private String surname;
    private String education;
    private String birthday;

    public Profession(String name, String surname, String education, String birthday) {
        this.name = name;
        this.surname = surname;
        this.education = education;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEducation() {
        return education;
    }

    public String getBirthday() {
        return birthday;
    }

    public static void main(String[] args) {
        /*Diagnose prostuda = new Diagnose("Prostuda");
        Pacient vadim = new Pacient("Vadim", "Timofeev", "30.11.89", prostuda);
        Doctor doctor = new Doctor();
        System.out.println(doctor.heal(vadim).getDiagnose());*/
    }
}
