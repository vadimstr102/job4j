package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.hamcrest.core.Is.is;

public class SchoolTest {
    School school = new School();
    List<Student> studentList = List.of(
            new Student(20),
            new Student(30),
            new Student(45),
            new Student(50),
            new Student(55),
            new Student(60),
            new Student(70),
            new Student(80),
            new Student(90),
            new Student(100)
    );
    List<Student> studentList2 = List.of(
            new Student("Timofeev"),
            new Student("Ivanov"),
            new Student("Arsentev"),
            new Student("Petrov"),
            new Student("Cobain")
    );

    @Test
    public void whenClassA() {
        List<Student> result = school.collect(studentList, student -> student.getScore() >= 70 && student.getScore() <= 100);
        List<Student> expected = Arrays.asList(new Student(70), new Student(80), new Student(90), new Student(100));
        Assert.assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void whenClassB() {
        List<Student> result = school.collect(studentList, student -> student.getScore() >= 50 && student.getScore() < 70);
        List<Student> expected = Arrays.asList(new Student(50), new Student(55), new Student(60));
        Assert.assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void whenClassC() {
        List<Student> result = school.collect(studentList, student -> student.getScore() > 0 && student.getScore() < 50);
        List<Student> expected = Arrays.asList(new Student(20), new Student(30), new Student(45));
        Assert.assertThat(result.toString(), is(expected.toString()));
    }

    @Test
    public void whenCollectToMap() {
        Map<String, Student> result = school.collectToMap(studentList2);
        Map<String, Student> expected = Map.of(
                "Arsentev", new Student("Arsentev"),
                "Cobain", new Student("Cobain"),
                "Ivanov", new Student("Ivanov"),
                "Petrov", new Student("Petrov"),
                "Timofeev", new Student("Timofeev")
        );
        Assert.assertThat(result, is(expected));
    }
}
