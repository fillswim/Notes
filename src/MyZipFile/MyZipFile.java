package MyZipFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyZipFile {

    public static void main(String[] args) throws IOException {

        // создаем архив
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\123\\archive.zip");
        ZipOutputStream zipOutputStream = new ZipOutputStream(fileOutputStream);

        // кладем в него ZipEntry - архивный объект
        zipOutputStream.putNextEntry(new ZipEntry("document.txt"));

        // копируем файл "document-for-archive.txt" в архив под именем "document.txt"
        File file = new File("d:\\document-for-archive.txt");
        Files.copy(file.toPath(), zipOutputStream);

        // закрываем архив
        zipOutputStream.close();

    }

}
