package MyJSONConvert;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;

public class MyJSONConvert {

    public static void main(String[] args) throws IOException {

        Cat cat = new Cat();
        cat.name = "Barsik";
        cat.id = 1;

        Dog dog = new Dog();
        dog.name = "Sharik";
        dog.id = 2;

        String catJSON = myConvertFromObjectToJSONString(cat);
        System.out.println(catJSON);

        Cat catNew = myConvertFromJSONStringToObject(catJSON, Cat.class);
        String newCatName = catNew.name;
        System.out.println(newCatName);

    }

    public static String myConvertFromObjectToJSONString(Object object) throws IOException {
        StringWriter stringWriter = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(stringWriter, object);

        String result = stringWriter.toString();
        return result;
    }

    public static <T> T myConvertFromJSONStringToObject(String stringInput, Class<T> cls) throws IOException {
        StringReader reader = new StringReader(stringInput);
        ObjectMapper mapper = new ObjectMapper();

        T object = mapper.readValue(reader, cls);
        return object;
    }

    @JsonAutoDetect
    public static class Cat{
        public String name;
        public int id;
    }

    @JsonAutoDetect
    public static class Dog{
        public String name;
        public int id;
    }

}
