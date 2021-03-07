package MyMaxMap;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class MyMaxMap {
    public static void main(String[] args) throws Exception {

        //Читаем имя файла
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String link = "D:\\data.txt";
        //String link = reader.readLine();

        //Создаем поток ввода
        FileInputStream inputStream = new FileInputStream(link);

        //Создаем список для принятых значений
        ArrayList<Integer> list = new ArrayList<>();

        //Читаем данные в список
        while (inputStream.available() > 0){
            int data = inputStream.read();
            list.add(data);
        }

        //Закрываем поток чтения из файла
        inputStream.close();

        //Создаем словарь для сортировки
        HashSet<Integer> set = new HashSet<>();

        //Создаем множество для сортировки
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //Заполняем множество
        for (int i : list){
            set.add(i);
        }
        //Заполняем словарь
        for (int i : set){
            map.put(i, 0);
        }

        //Подсчитываем количество повторений в списке
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            for (int i : list){
                if (entry.getKey() == i){
                    entry.setValue(entry.getValue() + 1);
                }
            }
        }

        //Создаем список для значений словаря
        ArrayList<Integer> listValues = new ArrayList<>();
        //Заполняем словарь
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            listValues.add(entry.getValue());
        }

        //Находим мксимальный элемент списка
        int max = Collections.max(listValues);

        //Создаем список для ключей словаря, встречающихся максимальное количество раз
        ArrayList<Integer> listResult = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry: map.entrySet()){
            if (entry.getValue() == max){
                listResult.add(entry.getKey());
            }
        }

        //Выводим наиболее часто встречающиеся элементы
        for (int i : listResult){
            System.out.print(i + " ");
        }

        reader.close();

    }

}
