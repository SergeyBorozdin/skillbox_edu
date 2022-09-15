public class Main {

    public static void main(String[] args) {

        Product product = new Product("Soap", 56);
        StringBuilder strings = new StringBuilder();
        long start = System.currentTimeMillis();

        for (int i = 0; i < 100_000; i++) {
            strings.append(product).append(System.lineSeparator());
        }
        System.out.println(System.currentTimeMillis() - start);
        System.out.println(strings.length());
    }
}
