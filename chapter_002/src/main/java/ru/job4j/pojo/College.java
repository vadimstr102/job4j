package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student vadim = new Student();
        vadim.setFirstName("Vadim");
        vadim.setLastName("Timofeev");
        vadim.setMiddleName("Vital'evich");
        vadim.setGroup("\"Java-Trainee\"");
        vadim.setReceiptDate(new Date());
        System.out.println("A student " + vadim.getLastName() + " " + vadim.getFirstName() + " " + vadim.getMiddleName()
        + " went in a group " + vadim.getGroup() + " in " + vadim.getReceiptDate() + ".");
    }
}
