package MyProperties;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class MyProperties {
    public static void main(String[] args) throws IOException {

        Properties defaultProperties = new Properties();
        defaultProperties.setProperty("bla", "my default");

        Properties properties = new Properties(defaultProperties);

        // Создание properties
//        properties.setProperty("one", "1");
//        System.out.println(properties.getProperty("one"));

        // Сохранение файла properties
//        FileOutputStream fileOutputStream = new FileOutputStream("my.properties");
//        properties.store(fileOutputStream, "my comments");

        FileInputStream fileInputStream = new FileInputStream("my.properties");
        properties.load(fileInputStream);

        System.out.println(properties.getProperty("max"));
        System.out.println(properties.getProperty("bla"));


    }
}
