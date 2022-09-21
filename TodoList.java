import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Main {

    private static TodoList todoList = new TodoList();

    public static void main(String[] args) {
        // TODO: написать консольное приложение для работы со списком дел todoList

        String regexCommand = "^[ADLISTE]{3,6}\\s?[0-9]*";

        String regexAdd = "^ADD\\s";
        String regexAddAndIndex = "^ADD[\\s]{1}[0-9]+";
        String regexEdit = "^EDIT[\\s][0-9]+";
        String regexDelete = "^DELETE[\\s]{1}[0-9]+";
        String regexList = "^LIST";

        while (true) {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();

            Pattern pattern = Pattern.compile(regexCommand);
            Matcher matcher = pattern.matcher(input);
            int end = 0;
            while (matcher.find()) {
                end = matcher.end();
            }
            String commandClear = input.substring(0, end);

            if (!commandClear.matches(regexList) &&
                    !commandClear.matches(regexEdit) &&
                    !commandClear.matches(regexDelete) &&
                    !commandClear.matches(regexAddAndIndex) &&
                    !commandClear.matches(regexAdd)) {
                System.out.println("Ошибка ввода команды");
            } else {

                //ADD
                if (commandClear.matches(regexAdd)) {
                    String textClear = input.substring(end);
                    System.out.println("Добавлено дело " + textClear);
                    todoList.add(textClear);
                }

                //ADD + INDEX
                if (commandClear.matches(regexAddAndIndex)) {
                    String textClear = input.substring(end + 1);
                    int startNumb = commandClear.indexOf(" ");
                    int stopNumb = commandClear.length();
                    String indexNumb = input.substring(startNumb + 1, stopNumb);
                    int index = Integer.parseInt(indexNumb);

                    if (index > todoList.getTodos().size()) {
                        System.out.println("Дело не было добавлено - индекс больше списка дел");
                    } else {
                        System.out.println("Добавлено дело " + textClear);
                        todoList.add(index, textClear);
                    }
                }

                //DELETE
                if (commandClear.matches(regexDelete)) {
                    int startNumb = commandClear.indexOf(" ");
                    int stopNumb = commandClear.length();
                    String indexNumb = input.substring(startNumb + 1, stopNumb);
                    int index = Integer.parseInt(indexNumb);

                    if (index > todoList.getTodos().size()) {
                        System.out.println("Дело с таким номером не существует");
                    } else {
                        System.out.println("Дело " + todoList.getTodos().get(index) + " удалено");
                        todoList.delete(index);
                    }
                }

                //EDIT
                if (commandClear.matches(regexEdit)) {
                    String textClear = input.substring(end + 1);
                    int startNumb = commandClear.indexOf(" ");
                    int stopNumb = commandClear.length();
                    String indexNumb = input.substring(startNumb + 1, stopNumb);
                    int index = Integer.parseInt(indexNumb);

                    if (index > todoList.getTodos().size()) {
                        System.out.println("Дело с таким номером не существует");
                    } else {
                        System.out.println("Дело " + todoList.getTodos().get(index) + " заменено " + textClear);
                        todoList.edit(index, textClear);
                    }

                }

                //LIST
                if (commandClear.matches(regexList)) {
                    if (todoList.listTodo.size() == 0) {
                        System.out.println("Список дел пуст");
                    } else {
                        for (int i = 0; i < todoList.listTodo.size(); i++) {
                            System.out.println(i + " - " + todoList.getTodos().get(i));
                        }
                    }
                }
            }
        }
    }
}


public class TodoList {

    ArrayList<String> listTodo = new ArrayList<>();

    public void add(String todo) {
        // TODO: добавьте переданное дело в конец списка
        listTodo.add(todo);
    }

    public void add(int index, String todo) {
        // TODO: добавьте дело на указаный индекс,
        //  проверьте возможность добавления
        if (index >= 0 && index <= listTodo.size() - 1) {
            listTodo.add(index, todo);
        }
    }

    public void edit(int index, String todo) {
        // TODO: заменить дело на index переданным todo индекс,
        //  проверьте возможность изменения
        if (index >= 0 && index <= listTodo.size() - 1) {
            listTodo.set(index, todo);
        }
    }

    public void delete(int index) {
        // TODO: удалить дело находящееся по переданному индексу,
        //  проверьте возможность удаления дела
        if (index >= 0 && index <= listTodo.size() - 1) {
            listTodo.remove(index);
        }
    }

    public ArrayList<String> getTodos() {
        // TODO: вернуть список дел
        return listTodo;
    }

}
