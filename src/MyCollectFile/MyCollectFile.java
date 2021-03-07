package MyCollectFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Collections;
import java.util.zip.ZipInputStream;

public class MyCollectFile {

    public static void main(String[] args) throws IOException {

        // Заносим аргументы командной строки и сортируем их
        ArrayList<String> fileNameParts = new ArrayList<String>();
        for (int i = 1; i < args.length; i++){
            String fileNamePart = args[i];
            fileNameParts.add(fileNamePart);
        }
        Collections.sort(fileNameParts);

        // Создаем файл для сборки
        String fileNameFinal = fileNameParts.get(0).split(".001")[0];
        File resultFile = new File(fileNameFinal);
        if (!resultFile.exists()){
            resultFile.createNewFile();
        }

        // Поток для записи в файл для сборки zip-архива
        FileOutputStream fileOutputStream = new FileOutputStream(fileNameFinal, true);

        for (String fileNamePart: fileNameParts){
            // Потоки для чтения каждой из части файла
            FileInputStream inputStream = new FileInputStream(fileNamePart);

            // Буффер по размеру каждой части
            byte[] buffer = new byte[inputStream.available()];

            // Заполняем буффер из файла
            inputStream.read(buffer);

            // Записываем буффер в результирующий zip-файл
            fileOutputStream.write(buffer);

            inputStream.close();
        }
        fileOutputStream.close();

    }

}
