package ru.job4j.student;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;

public class StudentTest {
    Student student0 = null;
    Student student1 = new Student("Vadim", 105);
    Student student2 = new Student("Petr", 110);
    Student student3 = null;
    Student student4 = new Student("Ivan", 90);
    Student student5 = new Student("Oleg", 120);
    Student student6 = new Student("Aleksey", 50);
    Student student7 = null;
    List<Student> studentList = new ArrayList<>();

    @Before
    public void start() {
        studentList.add(student0);
        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);
        studentList.add(student5);
        studentList.add(student6);
        studentList.add(student7);
    }

    @Test
    public void whenLevelOf() {
        List<Student> result = Student.levelOf(studentList, 100);
        List<Student> expected = List.of(student5, student2, student1);
        Assert.assertThat(result, is(expected));
    }
}
