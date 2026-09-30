public class GenericMaxDemo {
    public static void main(String[] args) {
        Integer[] marks = {80, 92, 75, 99, 88};
        String[] names = {"Mina", "Ada", "Grace", "Linus"};

        System.out.println("Highest mark: " + max(marks));
        System.out.println("Alphabetically largest name: " + max(names));

        Student[] students = {
            new Student("Mina", 88),
            new Student("Ada", 95),
            new Student("Grace", 91)
        };

        System.out.println("Best student: " + max(students));
    }

    public static <T extends Comparable<T>> T max(T[] items) {
        if (items == null || items.length == 0) {
            throw new IllegalArgumentException("Array cannot be null or empty.");
        }

        T largest = items[0];

        for (int i = 1; i < items.length; i++) {
            if (items[i].compareTo(largest) > 0) {
                largest = items[i];
            }
        }

        return largest;
    }

    public static class Student implements Comparable<Student> {
        private String name;
        private int mark;

        public Student() {
            this.name = "Unknown";
            this.mark = 0;
        }

        public Student(String name, int mark) {
            this.name = name;
            this.mark = mark;
        }

        public String getName() {
            return this.name;
        }

        public int getMark() {
            return this.mark;
        }

        public int compareTo(Student other) {
            return this.mark - other.mark;
        }

        public String toString() {
            return this.name + "(" + this.mark + ")";
        }
    }
}
