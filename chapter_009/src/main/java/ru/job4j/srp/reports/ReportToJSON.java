package ru.job4j.srp.reports;

import java.util.function.Predicate;

public class ReportToJSON implements Report {

    private Store store;

    public ReportToJSON(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder()
                .append("{");
        for (Employee employee : store.findBy(filter)) {
            text
                    .append("{")
                        .append("\"name\": \"")
                        .append(employee.getName())
                        .append("\",")
                        .append("\"hired\": \"")
                        .append(employee.getHired().getTime())
                        .append("\",")
                        .append("\"fired\": \"")
                        .append(employee.getFired().getTime())
                        .append("\",")
                        .append("\"salary\": ")
                        .append(employee.getSalary())
                    .append("}");
        }
        text.append("}");
        return text.toString();
    }
}
