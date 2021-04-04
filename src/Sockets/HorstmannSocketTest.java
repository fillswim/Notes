package Sockets;

import java.io.IOException;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HorstmannSocketTest {
    public static void main(String[] args) throws IOException {
        try (
                var socket = new Socket("time-a.nist.gov", 13);
                var scanner = new Scanner(socket.getInputStream(), StandardCharsets.UTF_8)
        ){
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                System.out.println(line);
            }
        }
    }
}
