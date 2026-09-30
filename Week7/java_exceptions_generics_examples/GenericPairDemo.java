public class GenericPairDemo {
    public static void main(String[] args) {
        Pair<String, Integer> studentScore = new Pair<String, Integer>("Mina", 88);
        System.out.println(studentScore);

        Pair<String, String> countryCapital = new Pair<String, String>("Canada", "Ottawa");
        System.out.println(countryCapital);

        printPair(studentScore);
        printPair(countryCapital);
    }

    public static <A, B> void printPair(Pair<A, B> pair) {
        System.out.println("First: " + pair.getFirst());
        System.out.println("Second: " + pair.getSecond());
    }

    public static class Pair<A, B> {
        private A first;
        private B second;

        public Pair() {
            this.first = null;
            this.second = null;
        }

        public Pair(A first, B second) {
            this.first = first;
            this.second = second;
        }

        public A getFirst() {
            return this.first;
        }

        public B getSecond() {
            return this.second;
        }

        public void setFirst(A first) {
            this.first = first;
        }

        public void setSecond(B second) {
            this.second = second;
        }

        public String toString() {
            return "Pair{first=" + this.first + ", second=" + this.second + "}";
        }
    }
}
