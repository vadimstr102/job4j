package ru.job4j.srp.reports;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReportToHRTest {

    @Test
    public void whenGenerated() {
        MemStore store = new MemStore(new ArrayList<>());
        Calendar now = Calendar.getInstance();
        Employee employee1 = new Employee("Ivan", now, now, 100);
        Employee employee2 = new Employee("Petr", now, now, 200);
        Employee employee3 = new Employee("Alex", now, now, 300);
        store.add(employee1);
        store.add(employee2);
        store.add(employee3);
        Report engine = new ReportToHR(store);
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
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
