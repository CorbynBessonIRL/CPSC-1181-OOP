public class GenericArray<T extends Comparable<T>> implements Cloneable {
    private T[] data;
    private int size;

    public GenericArray() {
        data = null;
        size = 0;
    }

    public GenericArray(T[] items) {
        if (items == null) {
            data = null;
            size = 0;
        } else {
            size = items.length;
            data = (T[]) new Comparable[size];

            for (int i = 0; i < size; i++) {
                data[i] = items[i];
            }
        }
    }

    public void add(int index, T[] newItems) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index for add.");
        }

        if (newItems == null) {
            throw new IllegalArgumentException("Array cannot be null.");
        }

        T[] temp = (T[]) new Comparable[size + newItems.length];

        for (int i = 0; i < index; i++) {
            temp[i] = data[i];
        }

        for (int i = 0; i < newItems.length; i++) {
            temp[index + i] = newItems[i];
        }

        for (int i = index; i < size; i++) {
            temp[i + newItems.length] = data[i];
        }

        data = temp;
        size += newItems.length;
    }

    public void remove(int index1, int index2) {
        if (index1 < 0 || index2 >= size || index1 > index2) {
            throw new IndexOutOfBoundsException("Invalid indexes for remove.");
        }

        int removeCount = index2 - index1 + 1;

        T[] temp = (T[]) new Comparable[size - removeCount];

        int pos = 0;

        for (int i = 0; i < size; i++) {
            if (i < index1 || i > index2) {
                temp[pos++] = data[i];
            }
        }

        data = temp;
        size -= removeCount;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index for get.");
        }

        return data[index];
    }

    public void sort(int index1, int index2) {
        if (index1 < 0 || index2 >= size || index1 >= index2) {
            throw new IndexOutOfBoundsException("Invalid indexes for sort.");
        }

        for (int i = index1; i < index2; i++) {
            int min = i;

            for (int j = i + 1; j <= index2; j++) {
                if (data[j].compareTo(data[min]) < 0) {
                    min = j;
                }
            }

            T temp = data[i];
            data[i] = data[min];
            data[min] = temp;
        }
    }

    @Override
    public GenericArray<T> clone() {
        return new GenericArray<T>(data);
    }

    public void display() {
        if (size == 0) {
            System.out.println("(empty)");
            return;
        }

        for (int i = 0; i < size; i++) {
            System.out.print(data[i] + " ");
        }

        System.out.println();
    }
}