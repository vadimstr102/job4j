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
        analyze.unavailable("./src/test/resources/server.log", "./src/test/resources/unavailable.csv");
        BufferedReader read = new BufferedReader(new FileReader("./src/test/resources/unavailable.csv"));
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
