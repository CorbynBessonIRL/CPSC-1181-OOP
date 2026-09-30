/**
 * The DynamicIntArray class stores integers using a private array.
 * The array always stores exactly size valid integers.
 */
public class DynamicIntArray {
    private int[] data;
    private int size;

    /**
     * Creates an empty DynamicIntArray.
     *
     * @return no return value
     */
    public DynamicIntArray() {
        data = new int[0];
        size = 0;
    }

    /**
     * Creates a DynamicIntArray containing a deep copy of the values in items.
     *
     * @param items the array of integers to copy; must not be null
     * @return no return value
     */
    public DynamicIntArray(int[] items) {
        if (items == null) {
            data = new int[0];
            size = 0;
        } else {
            size = items.length;
            data = new int[size];

            for (int i = 0; i < size; i++) {
                data[i] = items[i];
            }
        }
    }

    /**
     * Adds all integers from newItems into this dynamic array starting at index.
     *
     * @param index the position where the new items should be inserted;
     *              must be between 0 and size inclusive
     * @param newItems the array of integers to add; must not be null
     * @return no return value
     */
    public void add(int index, int[] newItems) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index. Add operation cancelled.");
            return;
        }

        if (newItems == null) {
            System.out.println("Invalid newItems array. Add operation cancelled.");
            return;
        }

        int[] newData = new int[size + newItems.length];

        for (int i = 0; i < index; i++) {
            newData[i] = data[i];
        }

        for (int i = 0; i < newItems.length; i++) {
            newData[index + i] = newItems[i];
        }

        for (int i = index; i < size; i++) {
            newData[i + newItems.length] = data[i];
        }

        data = newData;
        size = data.length;
    }

    /**
     * Removes all integers from index1 to index2, inclusive.
     *
     * @param index1 the first index to remove; must be at least 0
     * @param index2 the last index to remove; must be at least index1 and less than size
     * @return no return value
     */
    public void remove(int index1, int index2) {
        if (index1 < 0 || index2 < index1 || index2 >= size) {
            System.out.println("Invalid indexes. Remove operation cancelled.");
            return;
        }

        int numberToRemove = index2 - index1 + 1;
        int[] newData = new int[size - numberToRemove];

        for (int i = 0; i < index1; i++) {
            newData[i] = data[i];
        }

        for (int i = index2 + 1; i < size; i++) {
            newData[i - numberToRemove] = data[i];
        }

        data = newData;
        size = data.length;
    }

    /**
     * Sorts the integers from index1 to index2, inclusive, in ascending order.
     * Only the selected part of the array is sorted.
     *
     * @param index1 the first index in the range to sort; must be at least 0
     * @param index2 the last index in the range to sort; must be greater than index1 and less than size
     * @return no return value
     */
    public void sort(int index1, int index2) {
        if (index1 < 0 || index1 >= index2 || index2 >= size) {
            System.out.println("Invalid indexes. Sort operation cancelled.");
            return;
        }

        for (int i = index1; i < index2; i++) {
            int minIndex = i;

            for (int j = i + 1; j <= index2; j++) {
                if (data[j] < data[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp;
        }
    }

    /**
     * Prints all integers in this dynamic array on one line.
     *
     * @return no return value
     */
    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print(data[i]);

            if (i < size - 1) {
                System.out.print(" ");
            }
        }

        System.out.println();
    }
}
