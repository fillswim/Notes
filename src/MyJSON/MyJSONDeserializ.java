package MyJSON;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;

public class MyJSONDeserializ {

    public static void main(String[] args) throws IOException {

        // десериализация
        String jsonString = "{\"name\":\"Mursik\",\"age\":5,\"weight\":4}";
        StringReader reader = new StringReader(jsonString);

        ObjectMapper mapper2 = new ObjectMapper();
        Cat cat1 = mapper2.readValue(reader, Cat.class);
        System.out.println(cat1.name);

    }

}
