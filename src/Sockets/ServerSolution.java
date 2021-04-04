package Sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerSolution {
    public static void main(String[] args) {
        // Создаем серверный сокет
        try(ServerSocket serverSocket = new ServerSocket(8189)) {
            // Бесконечно принимаем запросы
            while (true) {
                Socket socket = serverSocket.accept();
                // Создаем новый поток и запускаем его
                new Thread(new MyServer(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class MyServer implements Runnable {
    Socket socket;

    public MyServer(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(// Входящий поток данных
            InputStream inputStream = socket.getInputStream();
            Scanner scanner = new Scanner(inputStream);

            // Исходящий поток данных
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter printWriter = new PrintWriter(outputStream, true)) {

            while (scanner.hasNextLine()) {
                String str = scanner.nextLine();
                printWriter.println("you've send: " + str);
                System.out.println(str);
                if (str.equals("exit")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
