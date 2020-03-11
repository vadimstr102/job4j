package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArgsTest {
    @Test
    public void whenTestingArgsIsTrue() {
        String[] s = {"-d", "c:/projects/job4j", "-e", "*.exe.txt.java", "-o", "project.zip"};
        Args args = new Args(s);
        assertThat(args.directory(), is("c:/projects/job4j"));
        assertThat(args.exclude(), is(".java"));
        assertThat(args.output(), is("project.zip"));
    }
}
