package Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HorstmannEchoServer {
    public static void main(String[] args) throws IOException {
        // Устанавливаем сокет на сервере
        try (var serverSocket = new ServerSocket(8189)){
            // Ожидание подключения клиента
            try (Socket incoming = serverSocket.accept()){
                InputStream inputStream = incoming.getInputStream();
                OutputStream outputStream = incoming.getOutputStream();

                try (var in = new Scanner(inputStream, StandardCharsets.UTF_8)) {
                    var out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true);
                    out.println("Hello! Enter BYE to exit.");

                    // передать обратно данные, полученные от клиента
                    var done = false;
                    while (!done && in.hasNextLine()) {
                        String line = in.nextLine();
                        out.println("Echo: " + line);
                        if (line.trim().equals("BYE")) {
                            done = true;
                        }
                    }
                }
            }
        }
    }
}
