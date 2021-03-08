package UrlConnectionTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class UrlConnectionTest {
    public static void main(String[] args){
        String urlAddress = "https://query1.finance.yahoo.com/v7/finance/download/GC=F?period1=1614902400&period2=1615161600&interval=1d&events=history&includeAdjustedClose=true";
        HttpURLConnection httpURLConnection;
        URL url;

        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;

        try {
            url = new URL(urlAddress);
            httpURLConnection = (HttpURLConnection) url.openConnection();
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.setConnectTimeout(200);
            httpURLConnection.setReadTimeout(200);
            httpURLConnection.connect();

            if (HttpURLConnection.HTTP_OK == httpURLConnection.getResponseCode()) {
                inputStreamReader = new InputStreamReader(httpURLConnection.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);

                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    System.out.println(line);
                }
            } else {
                System.out.printf("Fail %s", httpURLConnection.getResponseCode());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            if (inputStreamReader != null){
                try {
                    inputStreamReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader != null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
