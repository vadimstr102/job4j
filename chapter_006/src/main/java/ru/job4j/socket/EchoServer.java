package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (true) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    String answer = "";
                    if (str != null && str.contains("msg=")) {
                        if (str.contains("msg=Hello")) {
                            answer = "Hello";
                        } else if (!str.contains("msg=Exit")) {
                            answer = str.substring(str.indexOf("msg=") + 4, str.lastIndexOf(" HTTP"));
                        } else {
                            break;
                        }
                    }
                    while (str != null && !str.isEmpty()) {
                        System.out.println(str);
                        str = in.readLine();
                    }
                    out.write(("HTTP/1.1 200 OK" + System.lineSeparator() + System.lineSeparator()).getBytes());
                    out.write((answer + System.lineSeparator()).getBytes());
                }
            }
        }
    }
}
