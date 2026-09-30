
public class DynamicIntArray {
    private int[] data;
    private int size;

    /**
     * Default constructor that initializes the fields data and size
     * 
     * @return return an object of type DynamicIntArray
     */
    public DynamicIntArray() {
        data = null;
        size = 0;
    }

    /**
     * Creates a dynamic array using values from items.
     * A deep copy is created.
     *
     * @param items the array of integers to copy
     */
    public DynamicIntArray(int[] items) {
        size = items.length;

        int[] copy = new int[size];

        for (int i = 0; i < size; i++) {
            copy[i] = items[i];
        }

        data = copy;
    }

    /**
     * Adds all integers from newItems into this dynamic array
     * starting at index.
     *
     * @param index    the position where the new items should be inserted
     * @param newItems the array of integers to add
     */
    public void add(int index, int[] newItems) {

        if (0 <= index && index <= size) {

            int[] newArray = new int[size + newItems.length];

            for (int i = 0; i < index; i++) {
                newArray[i] = data[i];
            }

            for (int i = 0; i < newItems.length; i++) {
                newArray[index + i] = newItems[i];
            }

            for (int i = index; i < size; i++) {
                newArray[newItems.length + i] = data[i];
            }

            data = newArray;
            size = newArray.length;

        } else {
            System.out.println("invalid index");
        }
    }

    /**
     * Removes all integers from index1 to index2 inclusive.
     *
     * @param index1 the starting index to remove
     * @param index2 the ending index to remove
     */

    public void remove(int index1, int index2) {

        if (0 <= index1 && index1 <= index2 && index2 < size) {

            int removeCount = index2 - index1 + 1;

            int[] newArray = new int[size - removeCount];

            int curr = 0;

            for (int i = 0; i < size; i++) {

                if (i < index1 || i > index2) {
                    newArray[curr] = data[i];
                    curr++;
                }
            }

            data = newArray;
            size = newArray.length;

        } else {
            System.out.println("invalid indexes");
        }
    }

    /**
     * Sorts the integers from index1 to index2 inclusive
     * in ascending order.
     *
     * @param index1 the starting index of the section to sort
     * @param index2 the ending index of the section to sort
     */

    public void sort(int index1, int index2) {

        if (0 <= index1 && index1 < index2 && index2 < size) {

            for (int i = index1; i <= index2; i++) {

                int sml = i;

                for (int j = i + 1; j <= index2; j++) {

                    if (data[j] < data[sml]) {
                        sml = j;
                    }
                }

                int tmp = data[sml];
                data[sml] = data[i];
                data[i] = tmp;
            }

        } else {
            System.out.println("invalid indexes");
        }
    }

    /**
     * Displays all integers in the dynamic array on one line.
     */

    public void display() {

        if (size == 0) {

            System.out.println("Array is empty. Nothing to display");

        } else {

            for (int i = 0; i < size; i++) {
                System.out.print(data[i] + " ");
            }

            System.out.println();
        }
    }
}