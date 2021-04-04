package Sockets;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class SocketHTTP {
    public static void main(String[] args) throws IOException {
        URLConnection urlConnection = new URL("http://www.google.com").openConnection();
        Scanner scanner = new Scanner(urlConnection.getInputStream());
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
    }
}
