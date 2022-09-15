import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static String getRegexCheckNumber (String number) {
        String regex = "[^0-9]";
        return number.replaceAll(regex, "");
    }

    public static void main(String[] args) {
        String number1 = "8(989)-324- 6677";
        String number2 = "+7-988-665-3232";
        String number3 = "+7 903 665 34 38";
        String number4 = "8(915)9955051";

        System.out.println(getRegexCheckNumber(number1));

        // ============================

        String email = "vasilievmm@yandex.ru";
        String regex = "^[a-z]*[@][a-z]*[.][a-z]+$";
        System.out.println(email.matches(regex));

        // ============================

        String textSplit = "Шла Саша  по шоссе и сосала   сушку";
        String []words = textSplit.split("\\s+");
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }

        // ============================


        String text = "Добрый день!\nНапралвялю ссылку для работы с регулярными выражениями https://regex101.com/\nПросьба ознакомится с матералами перед началом работ и освоить навыки поиска строки через регулярные выражения. https://javarush.ru/groups/posts/regulyarnye-vyrazheniya-v-java";

        String regexMather = "https:\\/\\/[^,\\s]+";
        Pattern pattern = Pattern.compile(regexMather);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            System.out.println(text.substring(start, end));
        }
    }
}
