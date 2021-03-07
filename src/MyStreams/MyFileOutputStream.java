package MyStreams;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
* Если объект реализует интерфейс OutputStream, значит,
* он поддерживает последовательную запись в него байт (byte).
* */

public class MyFileOutputStream {
    public static void main(String[] args) throws IOException {

        String fileNameInput = "d:\\123\\data.txt";
        FileInputStream fileInputStream = new FileInputStream(fileNameInput);

        String fileNameOutput = "d:\\123\\result.txt";
        FileOutputStream fileOutputStream = new FileOutputStream(fileNameOutput);

        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            fileOutputStream.write(data);
        }

        fileInputStream.close();
        fileOutputStream.close();
    }
}
