import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FullNameFormatter {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }

            //TODO:напишите ваш код тут, результат вывести в консоль.
            //При невалидном ФИО вывести в консоль: Введенная строка не является ФИО
            System.out.println(getFullName(input));
            System.out.println(getFullNameRegex(input));

        }
    }

    public static String getMather(String regex, String text) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        String result = "";
        while (matcher.find()) {
            int start = matcher.start();
            int end = matcher.end();
            result += text.substring(start, end);
        }
        return result;
    }

    public static String getFullNameRegex (String text) {
        String messageError = "Введенная строка не является ФИО";
        String regexSoname = "^[А-Я]{1}[а-я]+[-]{0,1}[А-Я]{0,1}[а-я]+";
        String regexName = "[\\s]{1}[А-Я]{1}[а-я][А-Я]{0,1}[а-я]+[\\s]{1}";
        String regexFatherName = "[\\s]{1}[А-Я]{1}[а-я][А-Я]{0,1}[а-я]+$";
        String regexSpaceCheck = "[\\s]";

        int spaceCount = 0;
        String soname, name, fatherName;
        String template = "Фамилия: %s\nИмя: %s\nОтчество: %s";
        String fullName;

        Pattern pattern = Pattern.compile(regexSpaceCheck);
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            spaceCount++;
        }
        if (spaceCount != 2) {
            return messageError;
        } else {
            name = getMather(regexName, text);
            soname = getMather(regexSoname, text);
            fatherName = getMather(regexFatherName, text);

            if (fatherName.matches(regexFatherName) && name.matches(regexName) && soname.matches(regexSoname)) {
                fullName = String.format(template, soname, name.trim(), fatherName.trim());
            } else {
                fullName = messageError;
            }
        }
        return fullName;
    }


    public static String getFullName (String text) {

        int spaceCount = 0;
        String soname, name, fatherName;

        for (int i = 0; i < text.length(); i++) {
            char symbol = text.charAt(i);
            if (symbol == ' ') {
                spaceCount++;
            }
        }

        if (!text.isEmpty() && spaceCount == 2) {

            int end = text.indexOf(' ', 0);
            soname = text.substring(0, end);
            int secondSpace = text.indexOf(" ", end + 1);
            name = text.substring(end + 1, secondSpace);
            fatherName = text.substring(secondSpace + 1);

        } else {
            return "Введенная строка не является ФИО";
        }

        String template = "Фамилия: %s\nИмя: %s\nОтчество: %s";
        String fullName;
        if (Character.isUpperCase(soname.charAt(0)) &&
                Character.isUpperCase(name.charAt(0)) &&
                Character.isUpperCase(fatherName.charAt(0))) {
            fullName = String.format(template, soname, name, fatherName);
        } else {
            fullName = "Введенная строка не является ФИО";
        }

        return fullName;
    }

}
