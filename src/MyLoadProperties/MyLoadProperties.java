package MyLoadProperties;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class MyLoadProperties {

    public static void main(String[] args) throws IOException {

        File propertiesFile = new File("d:\\123\\data.properties");

        Properties properties = new Properties();
        properties.load(new FileReader(propertiesFile));

        for (String key: properties.stringPropertyNames()){
            System.out.println(key + " = " + properties.get(key));
        }

    }

}
