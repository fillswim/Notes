package MyStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;

/*
* ByteArrayOutputStream пишет байты в массив байт
* */

public class MyArrayInputStream {
    public static void main(String[] args) throws IOException {

        String test = "Hi!\\n My name is Richard\\n I'm a photographer\\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(test.getBytes(StandardCharsets.UTF_8));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);

        while (bufferedInputStream.available() > 0){
            int data = bufferedInputStream.read();
            outputStream.write(data);
        }

        String result = new String(outputStream.toByteArray());
        System.out.println(result);

    }
}
