import java.util.*;

public class PhoneBookTreeMap {

    public static TreeMap <String, String> phoneBook = new TreeMap<>();
    public static final String regexName = "^[А-я]+$";
    public static final String regexPhone = "^7[\\d]{10}$";
    public static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        String regexName = "^[А-я]+$";
        String regexPhone = "^7[\\d]{10}$";


        while (true) {
            System.out.println("Введите номер, имя или команду: ");
            String input = scanner.nextLine();

            if (!input.matches(regexName) && !input.matches(regexPhone) && !input.equals("LIST")) {
                System.out.println("Неверный формат ввода");
            } else {
                startPhoneBook(input);
            }
        }
    }

    public static void startPhoneBook (String input) {
        if (input.matches(regexName)) {
            if (getContactByName(input).isEmpty()) {
                System.out.println("Такого имени в телефонной книге нет." + System.lineSeparator() +
                        "Введите номер телефона для абонента \"" + input + "\":");
                String numberPhone = scanner.nextLine();
                addContact(numberPhone, input);
                System.out.println("Контакт сохранен!");
            } else {
                for (String phone : getContactByName(input)) {
                    System.out.println(phone);
                }
            }
        }

        if (input.matches(regexPhone)) {
            if (getContactByPhone(input).isEmpty()) {
                System.out.println("Такого номера нет в телефонной книге." + System.lineSeparator() +
                        "Введите имя абонента для номера \"" + input + "\":");
                String name = scanner.nextLine();
                addContact(input, name);
                System.out.println("Контакт сохранен!");
            } else {
                System.out.println(getContactByPhone(input));
            }
        }
        if (input.equals("LIST")) {
            getAllContacts();
        }
    }

    public static void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (phoneBook.size() > 0) {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (name.equals(phoneBook.get(entry.getKey()))) {
                    phoneBook.put(entry.getKey() + ", " + phone, name);
                    phoneBook.remove(entry.getKey());
                }
            }
        } else {
        phoneBook.put(phone, name);
        }
    }

    public static String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String getPhone = "";
        for (String key : phoneBook.keySet()) {
            if (phone.contains(key) || key.contains(phone)) {
                getPhone += phoneBook.get(key) + " - " + key;
            }
        }
        return getPhone;
    }

    public static Set<String> getContactByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet <String> getContacts = new TreeSet<>();
        for (String key : phoneBook.keySet()) {
            if (name.equals(phoneBook.get(key))) {
                getContacts.add(phoneBook.get(key) + " - " + key);
            }
        }
        return getContacts;
    }

    public static Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        for (String phone : phoneBook.keySet()) {
            System.out.println(phoneBook.get(phone) + " - " + phone);
        }
        return new TreeSet<>();
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */

}
