package MyGenericClass;

public class MyGenericClass {
    public static void main(String[] args) {
        Cell<String> stringCell = new Cell<String>();
        stringCell.setT("Hello!");
        String s = stringCell.getT();

        System.out.println(s);
    }
}

class Cell<T>{
    T t;

    public void setT(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }
}
