public class DynamicIntArrayDriver {

    public static void main(String[] args) {

        // 1. Default constructor
        System.out.println("1. Default constructor");
        DynamicIntArray d1 = new DynamicIntArray();
        d1.display();

        // 2. Constructor with array parameter
        System.out.println("\n2. Constructor with array parameter");
        DynamicIntArray d2 = new DynamicIntArray(
                new int[] { 10, 20, 30 });
        d2.display();

        // 3. Add at beginning
        System.out.println("\n3. Add at beginning");
        d2.add(0, new int[] { 1, 2 });
        d2.display();

        // 4. Add in middle
        System.out.println("\n4. Add in middle");
        d2.add(2, new int[] { 99, 88 });
        d2.display();

        // 5. Add at end
        System.out.println("\n5. Add at end");
        d2.add(7, new int[] { 500 });
        d2.display();

        // 6. Add with invalid index
        System.out.println("\n6. Add with invalid index");
        d2.add(20, new int[] { 7 });
        d2.display();

        // 7. Remove one item
        System.out.println("\n7. Remove one item");
        d2.remove(1, 1);
        d2.display();

        // 8. Remove multiple items
        System.out.println("\n8. Remove multiple items");
        d2.remove(2, 4);
        d2.display();

        // 9. Remove with invalid indexes
        System.out.println("\n9. Remove with invalid indexes");
        d2.remove(5, 2);
        d2.display();

        // 10. Sort part of the array
        System.out.println("\n10. Sort part of the array");
        DynamicIntArray d3 = new DynamicIntArray(
                new int[] { 50, 9, 3, 7, 100 });

        d3.display();

        d3.sort(1, 3);

        d3.display();

        // 11. Sort with invalid indexes
        System.out.println("\n11. Sort with invalid indexes");
        d3.sort(4, 1);

        // 12. Display after each major test
        System.out.println("\n12. Final display");
        d3.display();
    }
}