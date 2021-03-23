package ru.job4j.srp.reports;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store {
    private final List<Employee> employees;

    public MemStore(List<Employee> list) {
        employees = list;
    }

    public void add(Employee employee) {
        employees.add(employee);
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }
}
