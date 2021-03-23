package ru.job4j.srp.reports;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReportToDevelopersTest {

    @Test
    public void whenGenerated() {
        MemStore store = new MemStore(new ArrayList<>());
        Calendar now = Calendar.getInstance();
        Employee employee = new Employee("Ivan", now, now, 100);
        store.add(employee);
        Report engine = new ReportToDevelopers(store);
        StringBuilder expect = new StringBuilder()
                .append("<!DOCTYPE html>")
                .append("<html>")
                    .append("<head>")
                        .append("<meta charset=\"UTF-8\"/>")
                        .append("<title>Отчёт</title>")
                    .append("</head>")
                    .append("<body>")
                        .append("<p>")
                        .append("Name; Hired; Fired; Salary;")
                        .append("</p>")
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
                        .append("</p>")
                    .append("</body>")
                .append("</html>");
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
