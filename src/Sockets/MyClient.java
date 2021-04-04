package Sockets;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MyClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket()){
            // Связываемся с сервером (локальным, localhost - 127.0.0.1)
            socket.connect(new InetSocketAddress("localhost", 8189), 2000);
            Scanner scanner = new Scanner(socket.getInputStream());

            // Обрабатываем полученные с сервера данные
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
