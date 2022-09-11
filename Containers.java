import java.util.Scanner;

public class Containers {

    public static final int BOX_MAX = 27;
    public static final int CONTAINER_MAX = 12;
    public static final String NEW_LINE = System.lineSeparator();

    public static void main(String[] args) {

        int truck = 0, containers = 0;

        Scanner scanner = new Scanner(System.in);
        //получение количество коробок от пользователя
        int boxes = scanner.nextInt();

        if (boxes != 0 && boxes > 0) {
            truck = 1;
            containers = 1;
            System.out.println("Грузовик: " + truck + NEW_LINE  +
                    "\tКонтейнер: " + containers);
            for (int i = 1; i <= boxes; i++) {
                System.out.println("\t\tЯщик: " + i);
                if (i % (CONTAINER_MAX * BOX_MAX) == 0) {
                    truck++;
                    containers++;
                    System.out.println("Грузовик: " + truck + NEW_LINE  +
                            "\tКонтейнер: " + containers);
                } else if ( boxes == BOX_MAX) {
                    System.out.print("");
                } else if (i % BOX_MAX == 0) {
                    containers++;
                    System.out.println("\tКонтейнер: " + containers);
                }
            }
        } else  {
            if (boxes < 0) {
                System.out.println("Ошибка! Ящиков не может быть меньше 0");
            }
            if (boxes == 0) {
                System.out.println("Необходимо:" + NEW_LINE +
                        "\tгрузовиков - "+ truck + " шт." + NEW_LINE +
                        "\tконтейнеров - "+ containers +" шт.");
            }
        }
        System.out.println("Необходимо:" + NEW_LINE +
                "\tгрузовиков - "+ truck + " шт." + NEW_LINE +
                "\tконтейнеров - "+ containers +" шт.");

    /*
    Грузовик: 1
        Контейнер: 1
            Ящик: 1
            Ящик: 2
    Необходимо:
    грузовиков - 1 шт.
    контейнеров - 1 шт.
    */
    }


}
