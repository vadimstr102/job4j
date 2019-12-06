package ru.job4j.stream;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;

public class SchoolTest {
    School school = new School();
    List<Student> studentList = new ArrayList<>();
    List<Student> studentList2 = new ArrayList<>();

    @Before
    public void start() {
        studentList.add(new Student(20));
        studentList.add(new Student(30));
        studentList.add(new Student(45));
        studentList.add(new Student(50));
        studentList.add(new Student(55));
        studentList.add(new Student(60));
        studentList.add(new Student(70));
        studentList.add(new Student(80));
        studentList.add(new Student(90));
        studentList.add(new Student(100));

        studentList2.add(new Student("Timofeev"));
        studentList2.add(new Student("Ivanov"));
        studentList2.add(new Student("Arsentev"));
        studentList2.add(new Student("Petrov"));
        studentList2.add(new Student("Cobain"));
    }

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
        Map<String, Student> expected = new HashMap<>();
        expected.put("Arsentev", new Student("Arsentev"));
        expected.put("Cobain", new Student("Cobain"));
        expected.put("Ivanov", new Student("Ivanov"));
        expected.put("Petrov", new Student("Petrov"));
        expected.put("Timofeev", new Student("Timofeev"));
        Assert.assertThat(result, is(expected));
    }
}
