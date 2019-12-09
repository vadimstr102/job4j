package ru.job4j.lambda;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.core.Is.is;

public class GroupTest {
    Student student1 = new Student("Vadim", Set.of(
            "Programming",
            "Football"
    ));
    Student student2 = new Student("Petr", Set.of(
            "Football",
            "Biology"
    ));
    Student student3 = new Student("Ivan", Set.of(
            "Biology",
            "Basketball"
    ));
    Student student4 = new Student("Nick", Set.of(
            "Basketball",
            "Finance"
    ));
    Student student5 = new Student("Sam", Set.of(
            "Finance",
            "Programming"
    ));
    List<Student> list = List.of(student1, student2, student3, student4, student5);

    @Test
    public void whenGroupBySections() {
        Map<String, Set<String>> result = Group.sections(list);
        Map<String, Set<String>> expected = Map.of(
                "Finance", Set.of("Nick", "Sam"),
                "Programming", Set.of("Vadim", "Sam"),
                "Biology", Set.of("Petr", "Ivan"),
                "Basketball", Set.of("Nick", "Ivan"),
                "Football", Set.of("Vadim", "Petr")

        );
        Assert.assertThat(result, is(expected));
    }
}
