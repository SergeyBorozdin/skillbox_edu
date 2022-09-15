public class Concat {
    public static void main(String[] args) {


        Product product = new Product("milk", 96);
        StringBuilder builder = new StringBuilder();
        long start = System.currentTimeMillis();
        for (int i = 0; i < 50_000; i++) {
            builder.append(product).append("\n");
        }
        System.out.println(builder.length());
        System.out.println(System.currentTimeMillis() - start);



//        String name = "Vasia";
//        System.out.println(name.length());
//
//        String empty = "";
//        System.out.println(empty.isEmpty());
//
//        String blank = "   \t   \n   ";
//        System.out.println(blank.isBlank());
    }
}
