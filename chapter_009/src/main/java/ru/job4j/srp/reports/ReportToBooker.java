package ru.job4j.srp.reports;

import java.util.function.Predicate;

public class ReportToBooker implements Report {

    private Store store;

    public ReportToBooker(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(" рублей").append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
