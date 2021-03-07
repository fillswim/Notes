package MyStreams;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MyFileReader {
    public static void main(String[] args) throws IOException {

        String fileNameInput = "d:\\123\\data.txt";
        String fileNameOutput = "d:\\123\\result.txt";

        FileReader fileReader = new FileReader(fileNameInput);
        FileWriter fileWriter = new FileWriter(fileNameOutput);

        while (fileReader.ready()){
            int data = fileReader.read(); // читаем один символ (char будет расширен до int)
            fileWriter.write(data); // пишем один символ (int будет обрезан до char)
        }

        fileReader.close();
        fileWriter.close();

    }
}
