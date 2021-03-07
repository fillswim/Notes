package MyWrapper;

class Cat {

    private String name;

    public Cat(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class CatWrapper extends Cat {

    private Cat original;

    public CatWrapper(Cat cat) {
        super(cat.getName());
        this.original = cat;
    }

    public String getName(){
        return original.getName();
    }

    public void setName(String name){
        original.setName(name);
    }
}

public class Solution {
    public static void main(String[] args) {

        Cat cat = new Cat("Васька ");
        Cat catWrapper = new CatWrapper(cat);

        printName(cat);
        printName(catWrapper);

    }
    public static void printName(Cat named){
        System.out.println(named.getName());
    }

}
