public class GenericArrayDriver {
    public static void main(String[] args) {
        System.out.println("integer test");

        GenericArray<Integer> nums = new GenericArray<Integer>(new Integer[] { 10, 20, 30, 40, 50 });

        System.out.print("Original: ");
        nums.display();

        nums.add(0, new Integer[] { 1, 2 });
        System.out.print("Add at beginning: ");
        nums.display();

        nums.add(3, new Integer[] { 99 });
        System.out.print("Add in middle: ");
        nums.display();

        nums.add(8, new Integer[] { 100 });
        System.out.print("Add at end: ");
        nums.display();

        nums.remove(3, 3);
        System.out.print("Remove one item: ");
        nums.display();

        nums.remove(1, 2);
        System.out.print("Remove multiple items: ");
        nums.display();

        System.out.println("Element at index 2: " + nums.get(2));

        GenericArray<Integer> nums2 = new GenericArray<Integer>(new Integer[] { 50, 20, 40, 10, 30 });

        System.out.print("Before sort: ");
        nums2.display();

        nums2.sort(0, 4);

        System.out.print("After sort: ");
        nums2.display();

        GenericArray<Integer> copy = nums2.clone();

        System.out.print("Clone: ");
        copy.display();

        copy.add(0, new Integer[] { 999 });

        System.out.print("Modified clone: ");
        copy.display();

        System.out.print("Original still same: ");
        nums2.display();

        System.out.println("string test");

        GenericArray<String> words = new GenericArray<String>(
                new String[] { "dog", "cat", "bird", "zebra" });

        System.out.print("Original strings: ");
        words.display();

        words.sort(0, 2);

        System.out.print("Partial sort: ");
        words.display();

        GenericArray<String> wordsCopy = words.clone();

        System.out.print("Cloned strings: ");
        wordsCopy.display();

        System.out.println("exception test");

        try {
            nums.add(-1, new Integer[] { 1, 2 });
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Add error: "
                    + ex.getMessage());
        }

        try {
            nums.remove(5, 20);
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Remove error: " + ex.getMessage());
        }

        try {
            System.out.println(nums.get(100));
        } catch (IndexOutOfBoundsException ex) {
            System.out.println("Get error: " + ex.getMessage());
        }

        try {
            nums.add(0, null);
        } catch (IllegalArgumentException ex) {
            System.out.println("Null array error: " + ex.getMessage());
        }
    }
}
