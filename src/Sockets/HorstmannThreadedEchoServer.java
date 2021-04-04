package Sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class HorstmannThreadedEchoServer {
    public static void main(String[] args) throws IOException {
        try (var serverSocket = new ServerSocket(8189)) {
            int i = 1;

            while (true) {
                Socket incoming = serverSocket.accept();
                System.out.println("Spawning " + i);
                Runnable runnable = new ThreadedEchoHandler(incoming);
                var thread = new Thread(runnable);
                thread.start();
                i++;
            }
        }
    }
}

class ThreadedEchoHandler implements Runnable {
    private Socket incoming;

    public ThreadedEchoHandler(Socket incoming) {
        this.incoming = incoming;
    }

    @Override
    public void run() {
        try (InputStream inputStream = incoming.getInputStream();
             OutputStream outputStream = incoming.getOutputStream();
             var in = new Scanner(inputStream, StandardCharsets.UTF_8);
             var out = new PrintWriter(new OutputStreamWriter(outputStream, StandardCharsets.UTF_8), true))
        {
            out.println("Hello! Enter BYE to exit");

            // передать обратно данные, полученные от клиента
            var done = false;
            while (!done && in.hasNextLine()) {
                String line = in.nextLine();
                out.println("Echo: " + line);
                if (line.trim().equals("BYE")) {
                    done = true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
