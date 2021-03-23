package ru.job4j.srp.reports;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ReportToHR implements Report {

    private Store store;

    public ReportToHR(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> employees = store
                .findBy(filter)
                .stream()
                .sorted((o1, o2) -> Double.compare(o2.getSalary(), o1.getSalary()))
                .collect(Collectors.toList());
        StringBuilder text = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : employees) {
            text
                    .append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
