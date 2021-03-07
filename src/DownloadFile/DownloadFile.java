package DownloadFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class DownloadFile {
    public static void main(String[] args) throws IOException {
        // 1) Для начала надо задать правильный URL нужного тебе сервера.
        String googleUrl = "https://www.google.com.ua/images/srpr/logo11w.png";
        URL url = new URL(googleUrl);

        // 2) Затем нужно установить соединение с сервером, с помощью этого URL.
        URLConnection connection = url.openConnection();

        // 3) Затем передать тело запроса, если это POST-запрос. Или пропустить этот шаг, если это GET-запрос.


        // 4) И наконец, прочитать ответ сервера.
        InputStream inputStream = connection.getInputStream();
        // Для GET-запросов
//        InputStream inputStream = url.openStream();

        String filePath = "D:/123/google.png";
        Files.copy(inputStream, new File(filePath).toPath(), StandardCopyOption.REPLACE_EXISTING);
    }
}
