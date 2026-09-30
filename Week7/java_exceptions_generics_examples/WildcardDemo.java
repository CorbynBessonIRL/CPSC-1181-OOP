import java.util.ArrayList;

public class WildcardDemo {
    public static void main(String[] args) {
        ArrayList<Integer> integers = new ArrayList<Integer>();
        integers.add(10);
        integers.add(20);
        integers.add(30);

        ArrayList<Double> doubles = new ArrayList<Double>();
        doubles.add(1.5);
        doubles.add(2.5);

        printNumbers(integers);
        printNumbers(doubles);

        ArrayList<Number> numbers = new ArrayList<Number>();
        addSomeIntegers(numbers);
        System.out.println(numbers);
    }

    // ? extends Number means this method can read from a list of Number or a subtype of Number.
    // We should not add values to this list, because we do not know the exact subtype.
    public static void printNumbers(ArrayList<? extends Number> list) {
        for (Number number : list) {
            System.out.println(number);
        }
    }

    // ? super Integer means this method can add Integer values to a list of Integer,
    // Number, or Object.
    public static void addSomeIntegers(ArrayList<? super Integer> list) {
        list.add(100);
        list.add(200);
    }
}
