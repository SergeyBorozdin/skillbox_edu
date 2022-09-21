import java.util.ArrayList;

public class ArrayListMassive {
    public static void main(String[] args) {

        ArrayList<String> todoList = new ArrayList<>();
        todoList.add("первое дело");
        todoList.add("второе дело");
        todoList.add("третье дело");


        for (String list : todoList) {
            System.out.println(list);
        }

        for (int i = todoList.size() - 1; i >= 0 ; i--) {
            System.out.println(todoList.get(i));
        }
    }
}
