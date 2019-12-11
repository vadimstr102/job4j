package ru.job4j.stream;

import java.util.Objects;

public class Student {
    private int score;
    private String secondName;

    public Student(int score) {
        this.score = score;
    }

    public Student(String secondName) {
        this.secondName = secondName;
    }

    public String getSecondName() {
        return secondName;
    }

    public int getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Student student = (Student) o;
        return Objects.equals(secondName, student.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(secondName);
    }

    @Override
    public String toString() {
        return "Student{" + secondName + ", score=" + score + '}';
    }
}
