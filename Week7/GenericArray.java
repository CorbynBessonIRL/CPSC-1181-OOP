import java.util.*;
public class GenericArray<T extends Comparable<T>> implements Cloneable {
    private T[] data;
    private int size;

    public GenericArray() {
        data = null;
        size = 0;
    }

    public GenericArray(T[] items) {
        size = items.size();
        data = (T[]) new Comparable[size];
        for (int i = 0; i < size; i++) {
            data[i] = items[i];
        }

    }

    public void add(int index, T[] newItems) {
        if (index < 0 || size + 1 < index) {
            throw new IndexOutOfBoundsException();
        }
        size += 1;
        T[] tmp = (T[]) new Comparable[size];

        for (int i = 0; i < index; i++) {
            tmp[i] = data[i];
        }
        tmp[index] = newItems;
        for (int i = index; i < size; i++) {
            tmp[i] = data[i];
        }
    }
    //T[] x = (T[]) new Object[5];
    //T[] x = (T[]) new Comparable[5];
}
