package MyStreams;


/*
* В отличие от FileReader и FileWriter, StringReader и StringWriter работают
* не с данными в файле на диске, а со строкой (String) находящейся в памяти
* Java-машины.
* */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class MyStringReader {
    public static void main(String[] args) throws IOException {

        String test = "Hi!\nMy name is Richard\nI'm a photographer\n";
        System.out.println(test);

        StringReader stringReader = new StringReader(test);
        StringWriter stringWriter = new StringWriter();

        BufferedReader bufferedReader = new BufferedReader(stringReader);

        String line;
        while ((line = bufferedReader.readLine()) != null){
            StringBuilder stringBuilder = new StringBuilder(line);
            String newLine = stringBuilder.reverse().toString();

            stringWriter.write(newLine + '\n');
        }

        System.out.println(stringWriter.toString());
    }
}
