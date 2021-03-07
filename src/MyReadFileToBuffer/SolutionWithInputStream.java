package MyReadFileToBuffer;

import java.io.*;

public class SolutionWithInputStream {
    public static void main(String[] args) {

        //Читаем путь к файлу
        String link = "D:\\source.txt";

        try {
            //Создаем поток на чтение файла
            InputStream inputStream = new FileInputStream(link);

            //Читаем из файла символы по порядку
            while (inputStream.available() > 0){
                int s = inputStream.read();
                System.out.print((char) s);
            }

            //Закрываем поток чтения из файла
            inputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
