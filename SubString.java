import javax.crypto.spec.PSource;
import java.util.StringJoiner;

public class SubString {

    public static void main(String[] args) {

        String name1 = "Petr";
        String name2 = "Ken";
        String name3 = "Barby";

        StringJoiner joiner = new StringJoiner(", ");
        joiner.add(name1);
        joiner.add(name2);
        joiner.add(name3);
        System.out.println(joiner);

        String join = String.join(", ", name1, name2, name3);
        System.out.println(join);

        // ==================

        int year = 45;
        String name = "Jorg";

        String template = "в возрасте %d лет, подозревамый по имени %s встал на путь искупления\n";
        System.out.printf(template, year, name);


        // ==================

        String ending1 = "String-Type; text/html; charset=UTF8;";
        String ending2 = "String-Type; text/html; charset=windows-1251;";
        String ending3 = "String-Type; text/html; charset=usa-encod;";

        String ending4 = "String-Type; text/html; charset=;";
        String ending5 = "String-Type; text/html; charset=";
        String ending6 = "String-Type; text/html";

        System.out.println(getEncodeSubString(ending1));
        System.out.println(getEncodeSubString(ending2));
        System.out.println(getEncodeSubString(ending3));
        System.out.println(getEncodeSubString(ending4));
        System.out.println(getEncodeSubString(ending5));
        System.out.println(getEncodeSubString(ending6));

    }

    public static String getEncodeSubString(String text) {
        String charset = "charset=";
        int start = text.indexOf(charset);
        int end = text.indexOf(";", start);

        if (start < 0 || end < 0) {
            return "";
        }
        String subString = text.substring(start + charset.length(), end);
        return subString;
    }

}
