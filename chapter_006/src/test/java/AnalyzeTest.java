import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class AnalyzeTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void whenUseAnalyze() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (BufferedReader reader = new BufferedReader(new FileReader("./src/test/resources/server.log"));
             PrintWriter writer = new PrintWriter(source)) {
            reader.lines()
                    .filter(line -> !line.equals(""))
                    .forEach(writer::println);
        }
        Analyze analyze = new Analyze();
        analyze.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        try (BufferedReader read = new BufferedReader(new FileReader(target))) {
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
}
