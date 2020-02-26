import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalyzeTest {
    @Test
    public void whenUseAnalyze() throws IOException {
        Analyze analyze = new Analyze();
        analyze.unavailable("./data/server.log", "./data/unavailable.csv");
        BufferedReader read = new BufferedReader(new FileReader("./data/unavailable.csv"));
        assertThat(
                read.readLine(),
                is("10:57:01;10:59:01")
        );
        assertThat(
                read.readLine(),
                is("11:01:02;11:02:02")
        );
    }
}
