package ru.job4j.lambda;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Group {

    public static Map<String, Set<String>> sections(List<Student> students) {
        List<Pair> pairs = students.stream().
                flatMap(student -> student.getUnits().stream().map(u -> new Pair(student.getName(), u))).
                collect(Collectors.toList());
        Map<String, Set<String>> result = pairs.stream().collect(
                Collectors.groupingBy(Pair::getUnit, Collectors.mapping(Pair::getName, Collectors.toSet())));
        return result;
    }
}
