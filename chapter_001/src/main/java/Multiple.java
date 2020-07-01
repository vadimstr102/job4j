import java.io.FileOutputStream;
import java.io.IOException;

public class Multiple {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("result.txt")) {
            String s;
            for (int i = 1; i <= 10; i++) {
                s = "1 * " + i + " = " + i + "\r\n";
                out.write(s.getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
