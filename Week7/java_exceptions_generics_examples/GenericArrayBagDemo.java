public class GenericArrayBagDemo {
    public static void main(String[] args) {
        ArrayBag<String> names = new ArrayBag<String>(3);
        names.add("Ada");
        names.add("Grace");
        names.add("Linus");

        System.out.println("Names bag: " + names);
        System.out.println("Size: " + names.size());
        System.out.println("First item: " + names.get(0));
        System.out.println("Contains Grace? " + names.contains("Grace"));

        try {
            names.add("Extra");
        }
        catch (IllegalStateException exception) {
            System.out.println("Could not add item: " + exception.getMessage());
        }

        ArrayBag<Integer> marks = new ArrayBag<Integer>(4);
        marks.add(75);
        marks.add(80);
        marks.add(95);
        System.out.println("Marks bag: " + marks);
    }

    public static class ArrayBag<T> {
        private Object[] data;
        private int size;

        public ArrayBag() {
            this.data = new Object[10];
            this.size = 0;
        }

        public ArrayBag(int capacity) {
            if (capacity < 0) {
                throw new IllegalArgumentException("Capacity cannot be negative.");
            }

            this.data = new Object[capacity];
            this.size = 0;
        }

        public int size() {
            return this.size;
        }

        public int capacity() {
            return this.data.length;
        }

        public void add(T item) {
            if (this.size == this.data.length) {
                throw new IllegalStateException("Bag is full.");
            }

            this.data[this.size] = item;
            this.size = this.size + 1;
        }

        @SuppressWarnings("unchecked")
        public T get(int index) {
            if (index < 0 || index >= this.size) {
                throw new IndexOutOfBoundsException("Index must be between 0 and " + (this.size - 1) + ".");
            }

            return (T) this.data[index];
        }

        public boolean contains(T item) {
            for (int i = 0; i < this.size; i++) {
                if (item == null && this.data[i] == null) {
                    return true;
                }

                if (item != null && item.equals(this.data[i])) {
                    return true;
                }
            }

            return false;
        }

        public String toString() {
            String result = "[";

            for (int i = 0; i < this.size; i++) {
                result = result + this.data[i];

                if (i < this.size - 1) {
                    result = result + ", ";
                }
            }

            result = result + "]";
            return result;
        }
    }
}
