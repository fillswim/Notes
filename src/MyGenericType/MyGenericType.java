package MyGenericType;

import java.util.ArrayList;
import java.util.List;

public class MyGenericType {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("Hello!");
        list.add(String.valueOf(123));

        for (String str: list){
            System.out.println(str);
        }

    }
}
