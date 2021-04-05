package ru.job4j.srp.reports;

import java.util.function.Predicate;

public class ReportToXML implements Report {
    private Store store;

    public ReportToXML(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
        for (Employee employee : store.findBy(filter)) {
            text
                    .append("<Employee>")
                    .append("<Name>")
                    .append(employee.getName())
                    .append("</Name>")
                    .append("<Hired>")
                    .append(employee.getHired().getTime())
                    .append("</Hired>")
                    .append("<Fired>")
                    .append(employee.getFired().getTime())
                    .append("</Fired>")
                    .append("<Salary>")
                    .append(employee.getSalary())
                    .append("</Salary>")
                    .append("</Employee>");
        }
        return text.toString();
    }
}
