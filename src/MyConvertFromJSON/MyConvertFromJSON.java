package MyConvertFromJSON;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.FileReader;
import java.io.IOException;

public class MyConvertFromJSON {
    public static <T> T convertFromJsonToNormal(String fileName, Class<T> clazz) throws IOException {

        FileReader fileReader = new FileReader(fileName);

        ObjectMapper mapper = new ObjectMapper();
        T obj = mapper.readValue(fileReader, clazz);

        return obj;
    }

    public static void main(String[] args) throws IOException {
        String fileName = "D:\\123\\data.txt";
        Cat cat = convertFromJsonToNormal(fileName, Cat.class);
        System.out.println(cat.name);
    }
}

@JsonAutoDetect
class Cat{
    public String name;
    public int age;
    public int weight;
}
