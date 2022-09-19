import java.util.Scanner;

public class StringSpaceCheck {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(sequentialWordsNumbers(str));

    }

    public static String sequentialWordsNumbers(String text) {
        int countSpace = 1;
        if (!text.isEmpty()) {
        StringBuilder builder = new StringBuilder();
        builder.append("(" + countSpace + ") " );
        for (int i = 0; i < text.length(); i++) {
            char charSymbol = text.charAt(i);
            if (charSymbol == ' ') {
                countSpace++;
                builder.append(" (" + countSpace + ") " );
            }
            builder.append(charSymbol);

        }
        return builder.toString();
        } else {
            return "";
        }
    }

}
// добавить счетчик пробелов и печать его