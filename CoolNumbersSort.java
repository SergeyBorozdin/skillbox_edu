import com.sun.source.tree.Tree;

import java.text.DecimalFormat;
import java.util.*;

public class CoolNumbersSort {

    public static final String[] ALPHABET_NUMBER = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};


    public static void main(String[] args) {
        List<String> numb = new ArrayList<>(getDataAutoNumbers());
        long start = System.currentTimeMillis();
        System.out.println(getSearchArrayList(numb, numb.get(numb.size()-1)));
        System.out.println("Время getSearchArrayList - " + (System.currentTimeMillis() - start) + "ms");

        List<String> numb1 = new ArrayList<>(getDataAutoNumbers());
        start = System.currentTimeMillis();
        System.out.println(getSearchBinary(numb1, numb1.get(numb1.size()-1)));
        System.out.println("Время getSearchBinaryList - " + (System.currentTimeMillis() - start) + "ms");

        List<String> numb2 = new ArrayList<>(getDataAutoNumbers());
        start = System.currentTimeMillis();
        System.out.println(getSearchHashSet(numb2, numb2.get(numb2.size()-1)));
        System.out.println("Время getSearchHashSet - " + (System.currentTimeMillis() - start) + "ms");

        List<String> numb3 = new ArrayList<>(getDataAutoNumbers());
        start = System.currentTimeMillis();
        System.out.println(getSearchTreeSet(numb3, numb3.get(numb3.size()-1)));
        System.out.println("Время getSearchTreeSet - " + (System.currentTimeMillis() - start) + "ms");
    }

    public static String getSearchTreeSet(List<String> list, String search) {
        TreeSet<String> hashSet = new TreeSet<>(list);
        return hashSet.contains(search) ? "YES" : "NO";
    }

    public static String getSearchHashSet(List<String> list, String search) {
        HashSet<String> hashSet = new HashSet<>(list);
        return hashSet.contains(search) ? "YES" : "NO";
    }

    public static String getSearchBinary(List<String> list, String search) {
        String searchString = "NO";
        for (String str: list) {
            if (search.equals(str)) {
                searchString = "YES";
            }
        }
        return searchString;
    }

    public static String getSearchArrayList (List<String> list, String search) {
        Collections.sort(list);
        int index = Collections.binarySearch(list, search);
        return index >= 0 ? "YES" : "NO";
    }

    public static List<String> getDataAutoNumbers () {
        ArrayList<String> autoNumberList = new ArrayList<>();
        for (int i = 0; i < 2_000_000; i++) {
            String numberAuto = "";
            int index = (int) (Math.random() * 12);
            numberAuto += ALPHABET_NUMBER[index];
            for (int j = 0; j < 3; j++) {
                int digit = (int) (Math.random() * 9);
                numberAuto += digit;
            }
            for (int k = 0; k < 2; k++) {
                index = (int) (Math.random() * 12);
                numberAuto += ALPHABET_NUMBER[index];
            }
            int digit = (int) (1 + (Math.random() * 199));
            String countryNumber = new DecimalFormat("000").format(digit);
            numberAuto += countryNumber;
            autoNumberList.add(numberAuto);
        }
        return autoNumberList;
    }
}
