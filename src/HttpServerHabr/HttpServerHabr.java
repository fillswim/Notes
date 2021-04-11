package HttpServerHabr;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

public class HttpServerHabr {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            System.err.println("Client accepted");
            new Thread(new SocketProcessor(socket)).start();
        }
    }

    private static class SocketProcessor implements Runnable {

        private Socket socket;
        private InputStream inputStream;
        private OutputStream outputStream;

        public SocketProcessor(Socket socket) throws IOException {
            this.socket = socket;
            this.inputStream = socket.getInputStream();
            this.outputStream = socket.getOutputStream();
        }

        @Override
        public void run() {
            try {
                readInputHeaders();
                writeResponse("<html><body><h1>Hello from article Habrahabr</h1></body></html>");
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            System.err.println("Client processing finished");
        }

        private void writeResponse(String s) throws IOException {
            String responce = "HTTP/1.1 200 OK\r\n" +
                    "Server: YarServer/2009-09-09\r\n" +
                    "Content-Type: text/html\r\n" +
                    "Content-Length: " + s.length() + "\r\n" +
                    "Connection: close\r\n\r\n";

            String result = responce + s;
            outputStream.write(result.getBytes(StandardCharsets.UTF_8));
            outputStream.flush();
        }

        private void readInputHeaders() throws IOException {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            while (true) {
                String string = bufferedReader.readLine();
                if (string == null || string.trim().length() == 0) {
                    break;
                }
            }
        }
    }

}
