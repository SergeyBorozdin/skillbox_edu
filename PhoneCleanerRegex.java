import java.util.Scanner;

public class PhoneCleanerRegex {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String regexCleanNumber = "[^\\d]";
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("0")) {
                scanner.close();
                break;
            }
            if (!input.isEmpty()) {
                String cleanNumber = input.replaceAll(regexCleanNumber, "");
                char charat = cleanNumber.charAt(0);

                if ((charat != '8' && charat != '7' && cleanNumber.length() == 11) || (cleanNumber.length() < 10 || cleanNumber.length() > 11)) {
                    System.out.println("Неверный формат номера");
                } else {
                    if (cleanNumber.length() == 10 && charat == '9') {
                        String temp = "7";
                        for (int i = 0; i < cleanNumber.length(); i++) {
                            char symbol = cleanNumber.charAt(i);
                            temp += symbol;
                        }
                        cleanNumber = temp;
                        charat = cleanNumber.charAt(0);
                    }

                    if (charat == '8' && cleanNumber.length() == 11) {
                        System.out.print("7");
                        for (int i = 1; i < cleanNumber.length(); i++) {
                            char symbol = cleanNumber.charAt(i);
                            System.out.print(symbol);
                            System.out.println();
                        }
                        continue;
                    }

                    if (charat == '7' && cleanNumber.length() == 11) {
                        System.out.println(cleanNumber);
                        continue;
                    }
                }
            } else {
                System.out.println("Вы ввели пустую строку");
            }
        }
    }
}

