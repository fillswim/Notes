package MySocketClient;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class MySocketClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket()){
            socket.connect(new InetSocketAddress("india.colorado.edu", 13), 2000);
            Scanner scanner = new Scanner(socket.getInputStream());
            while (scanner.hasNextLine()) {
                System.out.println(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
