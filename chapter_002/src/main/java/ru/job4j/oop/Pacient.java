package ru.job4j.oop;

public class Pacient {
    private String name;
    private String surname;
    private String birthday;
    private Diagnose diagnose;

    public Pacient(String name, String surname, String birthday, Diagnose diagnose) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.diagnose = diagnose;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public Diagnose getDiagnose() {
        return diagnose;
    }
}
