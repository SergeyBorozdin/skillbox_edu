import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HashSetEmailList {

    HashSet<String> emailList = new HashSet<>();

    public void add(String email) {
        // TODO: валидный формат email добавляется, email это строка, она быть может любой
        // принять решение добавлять аргумент email или нет должен этот метод
        String lowCaseEmail = email.toLowerCase();
        emailList.add(lowCaseEmail);
    }

    public List<String> getSortedEmails() {
        // TODO: возвращается сортированный список электронных адресов в алфавитном порядке
        TreeSet<String> sortEmail = new TreeSet<>(emailList);
        ArrayList<String> finalListEmail = new ArrayList<>(sortEmail);

        return finalListEmail;
    }

}

class MainDouble {
    public static final String WRONG_EMAIL_ANSWER = "Неверный формат email";
    public static HashSetEmailList emailList = new HashSetEmailList();

    /* TODO:
        Пример вывода списка Email, после ввода команды LIST в консоль:
        test@test.com
        hello@mail.ru
        - каждый адрес с новой строки
        - список должен быть отсортирован по алфавиту
        - email в разных регистрах считается одинаковыми
           hello@skillbox.ru == HeLLO@SKILLbox.RU
        - вывод на печать должен быть в нижнем регистре
           hello@skillbox.ru
        Пример вывода сообщения об ошибке при неверном формате Email:
        "Неверный формат email"
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String regexAddEmail = "^ADD\\s[A-z]*@[A-z]*.[A-z]*$";
        String regexAdd = "^ADD\\s";
        String regexList = "^LIST$";

        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                break;
            }
            //TODO: write code here
            if (input.matches(regexList) || input.matches(regexAddEmail)) {
                if (input.matches(regexList)) {
                    for (String email : emailList.getSortedEmails()) {
                        System.out.println(email);
                    }
                }

                if (input.matches(regexAddEmail)) {
                    Pattern pattern = Pattern.compile(regexAdd);
                    Matcher matcher = pattern.matcher(input);
                    int end = 0;
                    while (matcher.find()) {
                        end = matcher.end();
                    }
                    String email = input.substring(end);
                    emailList.add(email);
                }
            } else {
                System.out.println(WRONG_EMAIL_ANSWER);
            }
        }
    }
}





