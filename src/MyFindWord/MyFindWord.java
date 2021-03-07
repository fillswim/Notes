package MyFindWord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyFindWord {
    public static void main(String[] args) throws IOException {

        String link = "D:\\data.txt";
        BufferedReader bufferedReader = new BufferedReader(new FileReader(link));

        String stringFind = "world";
        int countAll = 0;

        // \p{P} "Любой знак препинания"
        // \p{Z} "Любой пробельный символ"
        // \s    "Символ пробела"

        // Поиск через разбиение строки
        while (bufferedReader.ready()){
            String string = bufferedReader.readLine();
            String stringNew = string.replaceAll("\\p{P}", " ").replaceAll("\\s", " ");

            String[] strings = stringNew.split(" ");
            for (String str : strings){
                if (str.equals(stringFind)){
                    countAll++;
                }
            }
        }


        // Поиск через регулярные выражения
/*
        while (bufferedReader.ready()){
            String string = bufferedReader.readLine();

            Pattern pattern = Pattern.compile(stringFind);
            Matcher matcher = pattern.matcher(string);

            while (matcher.find()){
                countAll++;
            }
        }
*/

        System.out.println(countAll);
        bufferedReader.close();
    }
}
