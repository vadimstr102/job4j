package ru.job4j.srp.reports;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReportEngineTest {
    ReportEngine engine = new ReportEngine();
    MemStore store = new MemStore(new ArrayList<>());
    Calendar now = Calendar.getInstance();
    Employee employee1 = new Employee("Ivan", now, now, 100);
    Employee employee2 = new Employee("Petr", now, now, 200);
    Employee employee3 = new Employee("Alex", now, now, 300);

    @Test
    public void whenSimpleReportGenerated() {
        store.add(employee1);
        Report report = new SimpleReport(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(employee1.getName()).append(";")
                .append(employee1.getHired().getTime()).append(";")
                .append(employee1.getFired().getTime()).append(";")
                .append(employee1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generateReport(report, em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportToHRGenerated() {
        store.add(employee1);
        store.add(employee2);
        store.add(employee3);
        Report report = new ReportToHR(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Salary;")
                .append(System.lineSeparator())

                .append(employee3.getName()).append(";")
                .append(employee3.getSalary()).append(";")
                .append(System.lineSeparator())

                .append(employee2.getName()).append(";")
                .append(employee2.getSalary()).append(";")
                .append(System.lineSeparator())

                .append(employee1.getName()).append(";")
                .append(employee1.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generateReport(report, em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportToBookerGenerated() {
        store.add(employee1);
        Report report = new ReportToBooker(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(employee1.getName()).append(";")
                .append(employee1.getHired().getTime()).append(";")
                .append(employee1.getFired().getTime()).append(";")
                .append(employee1.getSalary()).append(" рублей").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generateReport(report, em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportToHTMLGenerated() {
        store.add(employee1);
        Report report = new ReportToHTML(store);
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
                .append(employee1.getName()).append(";")
                .append("</p>")
                .append("<p>")
                .append(employee1.getHired().getTime()).append(";")
                .append("</p>")
                .append("<p>")
                .append(employee1.getFired().getTime()).append(";")
                .append("</p>")
                .append("<p>")
                .append(employee1.getSalary()).append(";")
                .append("</p>")
                .append("</body>")
                .append("</html>");
        assertThat(engine.generateReport(report, em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportToXMLGenerated() {
        store.add(employee1);
        Report report = new ReportToXML(store);
        StringBuilder expect = new StringBuilder()
                .append("<?xml version=\"1.0\" encoding=\"utf-8\"?>")
                .append("<Employee>")
                .append("<Name>")
                .append(employee1.getName())
                .append("</Name>")
                .append("<Hired>")
                .append(employee1.getHired().getTime())
                .append("</Hired>")
                .append("<Fired>")
                .append(employee1.getFired().getTime())
                .append("</Fired>")
                .append("<Salary>")
                .append(employee1.getSalary())
                .append("</Salary>")
                .append("</Employee>");
        assertThat(engine.generateReport(report, em -> true), is(expect.toString()));
    }

    @Test
    public void whenReportToJSONGenerated() {
        store.add(employee1);
        Report report = new ReportToJSON(store);
        StringBuilder expect = new StringBuilder()
                .append("{")
                .append("{")
                .append("\"name\": \"")
                .append(employee1.getName())
                .append("\",")
                .append("\"hired\": \"")
                .append(employee1.getHired().getTime())
                .append("\",")
                .append("\"fired\": \"")
                .append(employee1.getFired().getTime())
                .append("\",")
                .append("\"salary\": ")
                .append(employee1.getSalary())
                .append("}")
                .append("}");
        assertThat(engine.generateReport(report, em -> true), is(expect.toString()));
    }
}
