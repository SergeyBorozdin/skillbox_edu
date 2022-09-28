import java.util.ArrayList;
import java.util.Collections;

public class Sort {

    public static void main(String[] args) {

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("223");
        arrayList.add("333");
        arrayList.add("123");

        for (String str : arrayList) {
            System.out.println(str);
        }

        Collections.sort(arrayList);

        for (String str : arrayList) {
            System.out.println(str);
        }

        int index = Collections.binarySearch(arrayList, "223");
        System.out.println(index);


    }
}
