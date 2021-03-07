package MyParseDate;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class MyParseDate {
    public static void main(String[] args) throws IOException, ParseException {

        String link = "D:\\data.txt";
        BufferedReader reader = new BufferedReader(new FileReader(link));
        String string = reader.readLine();
        System.out.println(string);

        String[] arr = string.split(" ");

        String firstName = arr[1];
        String middleName = arr[2];
        String lastName = arr[0];
        int year = Integer.parseInt(arr[5]);
        int month = Integer.parseInt(arr[4]);
        int day = Integer.parseInt(arr[3]);

        String dateString = day + " " + month + " " + year;
        System.out.println(dateString);

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MM yyyy", Locale.getDefault());
        Date date = dateFormat.parse(dateString);

        System.out.println(date);
    }

}
