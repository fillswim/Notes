package MyGenericMethod;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyGenericMethod {
    public static void main(String[] args) {
        List list = Arrays.asList("Author", "Book", 1);

        for (Object object: list){
            // Выводит тип объекта
            System.out.println(getValue(object).getClass());
        }
        System.out.println();

        voidMethod(list.get(0));

    }

    // generic void method
    public static <T> void voidMethod(T t){
        System.out.println("void Method");
    }

    // Возвращает принимаемый объект как есть
    public static <T> T getValue(Object object){
        return (T) object;
    }
}
