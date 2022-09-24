import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMapGoodsToCount {

    public static void main(String[] args) {

        HashMap<String, Integer> goods2count = new HashMap<>();

        Scanner scanner = new Scanner(System.in);
        for (;;) {
            String input = scanner.nextLine();
            if (input.equals("LIST")) {
                getGoods2counts(goods2count);
                continue;
            }
            int count = 1;
            if (goods2count.containsKey(input)) {
                count = goods2count.get(input) + count;
            }
            goods2count.put(input, count);
        }

    }

    public static void getGoods2counts (Map<String, Integer> map) {
        for (String key : map.keySet()) {
            System.out.println(key + " ==> " + map.get(key));
        }
    }
}
