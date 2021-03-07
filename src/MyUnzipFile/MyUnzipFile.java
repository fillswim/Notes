package MyUnzipFile;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class MyUnzipFile {

    public static void main(String[] args) throws IOException {

        // Поток для чтения из архива
        String fileName = "D:\\123\\archive.zip";
        ZipInputStream zipInputStream = new ZipInputStream(new FileInputStream(fileName));

        // Создание разархивированного файла
        File file = new File("D:\\123\\document-from-archive.txt");
        if (!file.exists()){
            file.createNewFile();
        }

        // Получение объекта Entry из архива
        zipInputStream.getNextEntry();

        // Копирование из Entry в результирующий файл
        Files.copy(zipInputStream, file.toPath(), StandardCopyOption.REPLACE_EXISTING);

        zipInputStream.close();

    }

}
