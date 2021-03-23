package ru.job4j.srp.reports;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Calendar;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ReportToBookerTest {

    @Test
    public void whenGenerated() {
        MemStore store = new MemStore(new ArrayList<>());
        Calendar now = Calendar.getInstance();
        Employee employee = new Employee("Ivan", now, now, 100);
        store.add(employee);
        Report engine = new ReportToBooker(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(employee.getName()).append(";")
                .append(employee.getHired()).append(";")
                .append(employee.getFired()).append(";")
                .append(employee.getSalary()).append(" рублей").append(";")
                .append(System.lineSeparator());
        assertThat(engine.generate(em -> true), is(expect.toString()));
    }
}
