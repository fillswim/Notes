package MyJSON;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.LinkedList;

public class MyJSON {
    public static void main(String[] args) throws IOException {

        // создание объекта для сериализации в JSON
        Cat cat = new Cat();
        cat.name = "Mursik";
        cat.age = 5;
        cat.weight = 4;

        // писать результаты сериализации будем во Writer(StringWriter)
        StringWriter writer = new StringWriter();

        // это объект JSON, который выполняет сериализацию
        ObjectMapper mapper = new ObjectMapper();

        // сама сриализация (кудаб что)
        mapper.writeValue(writer, cat);

        String result = writer.toString();
        System.out.println(result);

    }
}

@JsonAutoDetect
class Cat{
    @JsonProperty("nameNew")    // Задает другое имя полю при сериализации
    public String name;
    public int age;
    @JsonIgnore
    public int weight;         // Свойство игнорируется при сериализации

    // Указывается конкретная реализация интерфейча для десериализации
    //@JsonDeserialize(as = LinkedList.class)

    Cat(){}
}
