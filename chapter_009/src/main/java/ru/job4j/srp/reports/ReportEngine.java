package ru.job4j.srp.reports;

import java.util.function.Predicate;

public class ReportEngine {

    public String generateReport(Report report, Predicate<Employee> filter) {
        return report.generate(filter);
    }
}
