import java.util.Scanner;

public class PhoneCleanerRegex2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }
            System.out.println(getCleanerNumber(input));
        }
    }

    public static String getCleanerNumber (String number) {
        String regexCleanNumber = "[^\\d]";
        String regex = "[8]?[7]?[9][0-9]{9}";
        StringBuilder result = new StringBuilder();

        String cleanNumb = number.replaceAll(regexCleanNumber, "");
        if (cleanNumb.matches(regex)) {
            if (cleanNumb.length() == 10 && cleanNumb.charAt(0) == '9') {
                result.append("7".concat(cleanNumb));
            }
            if (cleanNumb.length() == 11 && cleanNumb.charAt(0) == '8'){
                result.append("7");
                for (int i = 1; i < cleanNumb.length(); i++) {
                    char symbol = cleanNumb.charAt(i);
                    result.append(symbol);
                }
            }
            if (cleanNumb.length() == 11 && cleanNumb.charAt(0) == '7') {
                result.append(cleanNumb);
            }
        } else {
            System.out.println("Неверный формат номера");
        }
        return result.toString();
    }
}
