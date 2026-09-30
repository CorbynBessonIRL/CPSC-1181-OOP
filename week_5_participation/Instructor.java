package week_5_participation;

public class Instructor extends Person {
    public double salary;

    public Instructor() {
        super();
        salary = 0.0;
    }

    public Instructor(int a, String b, double c) {
        super(a, b);
        salary = c;
    }

    public String toString() {
        String s = super.toString() + ", salary:" + salary;
        return s;
    }
}
