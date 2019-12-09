package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Group {

    public static Map<String, Set<String>> sections(List<Student> students) {
        List<Pair> pairs = new ArrayList<>();
        for (Student student : students) {
            for (String unit : student.getUnits()) {
                pairs.add(new Pair(student.getName(), unit));
            }
        }
        Map<String, Set<String>> result = pairs.stream().collect(
                Collectors.groupingBy(Pair::getUnit, Collectors.mapping(Pair::getName, Collectors.toSet())));
        return result;
    }
}
