package week_5_participation;

public class Person {
    private int byear;
    private String name;

    public Person() {
        byear = 0;
        name = "";
    }

    public Person(int a, String b) {
        byear = a;
        name = b;
    }

    public String toString() {

        String s = "birth year :" + byear + ", name:" + name;
        return s;
    }

}
