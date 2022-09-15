import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class SymbolAndEncoding {

    public static void main(String[] args) {

        String line = "123456747";
        char symbol = line.charAt(0);
        System.out.println(Character.isDigit(symbol));

        // =====================

        String text = "Вася любит ходить босиком по траве весной";
        int spaceCount = 0;
        for (int i = 0; i < text.length(); i++) {
            char symbol2 = text.charAt(i);
            if (symbol2 == ' ') {
                spaceCount++;
            }
        }
        System.out.println(spaceCount);

        // =====================

        String name = " Anna \t";
        System.out.println(name.trim());

        // =====================

        String charSet = Charset.defaultCharset().displayName();
        System.out.println(charSet);

        String text2 = "some coding таблица аски";
        String encodingText = null;
        try {
            encodingText = new String(text2.getBytes(), "windows-1251");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(encodingText);

    }
}
