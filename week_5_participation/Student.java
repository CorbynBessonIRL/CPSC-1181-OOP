package week_5_participation;

public class Student extends Person {
    private String major;

    public Student() {
        super();
        major = "unknown";
    }

    public Student(int a, String b, String c) {
        super(a, b);
        major = c;
    }

    @Override
    public String toString() {
        String s = super.toString() + ", major:" + major;
        return s;
    }
}
