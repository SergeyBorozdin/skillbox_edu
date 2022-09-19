import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TotalEarningsCalculator {

    public static void main(String[] args) {

        String text = "Вася заработал 5000 рублей, Петя - 7563 рубля, а Маша - 30000 рублей";
        //TODO: напишите ваш код, результат вывести в консоль

        System.out.println(getPaymentFriends(text));
        System.out.println(getSumFriendsRegex(text));

    }

    public static String getSumFriendsRegex (String text) {
        String regex = "[\\d]+";
        int sum = 0;
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            sum += Integer.parseInt(text.substring(start, end));
        }
        return String.valueOf(sum);
    }

    public static String getPayOneFriend(String text, int start, int end) {

        for (int i = end; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (Character.isDigit(symbol)) {
                start = i;
                break;
            }
        }
        end = text.indexOf(' ', start);
        String sum1 = text.substring(start, end);
        return sum1;
    }

    public static String getPaymentFriends (String text) {
        int start = 0, end = 0;
        String sum1 = getPayOneFriend(text, start, end);
        start = text.indexOf(sum1);
        end = text.indexOf(' ', start);
        String sum2 = getPayOneFriend(text, start, end);;
        start = text.indexOf(sum2);
        end = text.indexOf(' ', start);
        String sum3 = getPayOneFriend(text, start, end);

        int allSum = Integer.parseInt(sum1) + Integer.parseInt(sum2) + Integer.parseInt(sum3);
        return Integer.toString(allSum);
    }

}
