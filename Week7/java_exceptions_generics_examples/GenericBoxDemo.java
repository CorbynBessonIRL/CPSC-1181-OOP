public class GenericBoxDemo {
    public static void main(String[] args) {
        Box<String> nameBox = new Box<String>("Ada");
        String name = nameBox.getItem();
        System.out.println("Name: " + name);

        Box<Integer> scoreBox = new Box<Integer>(95);
        Integer score = scoreBox.getItem();
        System.out.println("Score: " + score);

        // This line would not compile, which is good:
        // Integer wrong = nameBox.getItem();
    }

    public static class Box<T> {
        private T item;

        public Box() {
            this.item = null;
        }

        public Box(T item) {
            this.item = item;
        }

        public T getItem() {
            return this.item;
        }

        public void setItem(T item) {
            this.item = item;
        }

        public String toString() {
            return "Box{item=" + this.item + "}";
        }
    }
}
