/**
 * Driver program for testing the DynamicIntArray class.
 */
public class DynamicIntArrayDriver {
    public static void main(String[] args) {
        System.out.println("Test 1: Default constructor");
        DynamicIntArray empty = new DynamicIntArray();
        empty.display();

        System.out.println("\nTest 2: Constructor with array parameter");
        int[] original = {10, 20, 30, 40};
        DynamicIntArray nums = new DynamicIntArray(original);
        nums.display();

        System.out.println("\nTest 3: Deep copy test");
        original[0] = 999;
        System.out.println("Original array changed, DynamicIntArray should not change:");
        nums.display();

        System.out.println("\nTest 4: Add at beginning");
        nums.add(0, new int[]{1, 2});
        nums.display();

        System.out.println("\nTest 5: Add in middle");
        nums.add(3, new int[]{77, 88});
        nums.display();

        System.out.println("\nTest 6: Add at end");
        nums.add(8, new int[]{500, 600});
        nums.display();

        System.out.println("\nTest 7: Add with invalid index");
        nums.add(100, new int[]{7, 8});
        nums.display();

        System.out.println("\nTest 8: Remove one item");
        nums.remove(0, 0);
        nums.display();

        System.out.println("\nTest 9: Remove multiple items");
        nums.remove(2, 4);
        nums.display();

        System.out.println("\nTest 10: Remove with invalid indexes");
        nums.remove(4, 2);
        nums.display();

        System.out.println("\nTest 11: Sort part of the array");
        DynamicIntArray sortTest = new DynamicIntArray(new int[]{50, 9, 3, 7, 100});
        sortTest.display();
        sortTest.sort(1, 3);
        sortTest.display();

        System.out.println("\nTest 12: Sort with invalid indexes");
        sortTest.sort(3, 1);
        sortTest.display();
    }
}
