package ru.job4j.srp.reports;

import java.util.function.Predicate;

public class ReportToDevelopers implements Report {

    private Store store;

    public ReportToDevelopers(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder()
                .append("<!DOCTYPE html>")
                .append("<html>")
                    .append("<head>")
                        .append("<meta charset=\"UTF-8\"/>")
                        .append("<title>Отчёт</title>")
                    .append("</head>")
                    .append("<body>")
                        .append("<p>")
                            .append("Name; Hired; Fired; Salary;")
                        .append("</p>");
        for (Employee employee : store.findBy(filter)) {
            text
                    .append("<p>")
                        .append(employee.getName()).append(";")
                    .append("</p>")
                    .append("<p>")
                        .append(employee.getHired()).append(";")
                    .append("</p>")
                    .append("<p>")
                        .append(employee.getFired()).append(";")
                    .append("</p>")
                    .append("<p>")
                        .append(employee.getSalary()).append(";")
                    .append("</p>");
        }
        text
                    .append("</body>")
                .append("</html>");
        return text.toString();
    }
}
