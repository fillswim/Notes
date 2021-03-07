package MyReadFileToBuffer;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SolutionWithFileReader {
    public static void main(String[] args) {

        //Читаем путь к файлу
        String link = "D:\\source.txt";

        try {
            //Создаем поток на чтение файла
            BufferedReader readerFile = new BufferedReader(new FileReader(link));

            //Читаем из файла по строкам
            while (readerFile.ready()){
                String str = readerFile.readLine();
                System.out.println(str);
            }

            //Закрываем поток чтения из файла
            readerFile.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
