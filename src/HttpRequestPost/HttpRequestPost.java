package HttpRequestPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class HttpRequestPost {
    public static void main(String[] args) {

        String urlAddress = "http://httpbin.org/post";
        URL url;
        HttpURLConnection httpURLConnection;

        OutputStream outputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        StringBuilder stringBuilder = new StringBuilder();

        try {
            // Создаем сообщение
            Map<String, String> postargs = new HashMap<>();
            postargs.put("user", "Bob");
            postargs.put("pass", "123");

            byte[] out = postargs.toString().getBytes(StandardCharsets.UTF_8);

            // Установка соединения
            url = new URL(urlAddress);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("POST");
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            // Настройка параметров соединения
            httpURLConnection.addRequestProperty("User-Agent", "Mozilla/5.0");
            httpURLConnection.addRequestProperty("Content-Type", "application/x-www-form-urlencoded");

            // Настройка время ожидания
            httpURLConnection.setConnectTimeout(200);
            httpURLConnection.setReadTimeout(200);

            httpURLConnection.connect();

            try {
                // Отправка сообщения
                outputStream = httpURLConnection.getOutputStream();
                outputStream.write(out);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Принимает ответ сервера
            if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);

                String line;

                // Занесение ответа в StringBuilder
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            }

            // Печать ответа
            System.out.println(stringBuilder);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStreamReader != null) {
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }
}
