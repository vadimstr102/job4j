package ru.job4j.student;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Student implements Comparable<Student> {
    private String name;
    private int scope;

    public Student(String name, int scope) {
        this.name = name;
        this.scope = scope;
    }

    public String getName() {
        return name;
    }

    public int getScope() {
        return scope;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(o.scope, this.scope);
    }

    @Override
    public String toString() {
        return this.name + " " + this.scope;
    }

    /**
     *
     * @param students - список студентов
     * @param bound - балл аттестата
     * @return - список студентов, у которых балл, больше, чем bound
     */
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream().flatMap(Stream::ofNullable).sorted().
                takeWhile(student -> student.getScope() > bound).collect(Collectors.toList());
    }
}
