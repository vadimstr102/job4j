import java.io.*;

public class Analyze {
    public void unavailable(String source, String target) throws FileNotFoundException {
        PrintWriter out = new PrintWriter(new FileOutputStream(target));
        String log;
        String number;
        String time1;
        String time2;
        try (BufferedReader read = new BufferedReader(new FileReader(source))) {
            while (read.ready()) {
                log = read.readLine();
                number = log.split(" ")[0];
                if (number.equals("400") || number.equals("500")) {
                    time1 = log.split(" ")[1];
                    while (read.ready()) {
                        log = read.readLine();
                        number = log.split(" ")[0];
                        if (number.equals("200") || number.equals("300")) {
                            time2 = log.split(" ")[1];
                            out.println(time1 + ";" + time2);
                            break;
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        out.close();
    }
}
