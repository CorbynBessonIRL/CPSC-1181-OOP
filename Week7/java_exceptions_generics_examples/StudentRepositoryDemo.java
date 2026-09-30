import java.util.ArrayList;

public class StudentRepositoryDemo {
    public static void main(String[] args) {
        StudentRepository<Student> students = new StudentRepository<Student>();

        students.add(new Student("S100", "Mina"));
        students.add(new Student("S200", "Ada"));

        System.out.println(students);

        try {
            Student found = students.findById("S200");
            System.out.println("Found: " + found);

            Student missing = students.findById("S999");
            System.out.println("Found: " + missing);
        }
        catch (StudentNotFoundException exception) {
            System.out.println(exception.getMessage());
        }
    }

    public static class Student {
        private String id;
        private String name;

        public Student() {
            this.id = "UNKNOWN";
            this.name = "Unknown";
        }

        public Student(String id, String name) {
            if (id == null || id.length() == 0) {
                throw new IllegalArgumentException("Student id cannot be empty.");
            }

            if (name == null || name.length() == 0) {
                throw new IllegalArgumentException("Student name cannot be empty.");
            }

            this.id = id;
            this.name = name;
        }

        public String getId() {
            return this.id;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return "Student{id='" + this.id + "', name='" + this.name + "'}";
        }
    }

    public static class StudentRepository<T extends Student> {
        private ArrayList<T> items;

        public StudentRepository() {
            this.items = new ArrayList<T>();
        }

        public void add(T item) {
            if (item == null) {
                throw new IllegalArgumentException("Student cannot be null.");
            }

            this.items.add(item);
        }

        public T findById(String id) {
            for (int i = 0; i < this.items.size(); i++) {
                T current = this.items.get(i);

                if (current.getId().equals(id)) {
                    return current;
                }
            }

            throw new StudentNotFoundException("No student found with id " + id + ".");
        }

        public String toString() {
            return this.items.toString();
        }
    }

    public static class StudentNotFoundException extends RuntimeException {
        public StudentNotFoundException(String message) {
            super(message);
        }
    }
}
