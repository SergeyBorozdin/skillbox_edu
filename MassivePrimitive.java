public class MassivePrimitive {

    public static void main(String[] args) {

        String text = "каждый охотник знает, где сидит фазан";
        String[] words = text.split("[,]?[\\s]+");
        for (String word : words) {
            System.out.println(word);
        }


        // ==============

        String[] colors = {"Красный", "Оранжевый", "Желтый"};
        for (String color : colors) {
            System.out.println(color);
        }
        // =============

        int roomCount[] = {2, 4, 6, 7};

        // ==================
        int[] countRooms = new int[5];
        countRooms[0] = 2;
        countRooms[1] = 5;
        countRooms[2] = 4;
        for (int i = 0; i < countRooms.length; i++) {
            System.out.println(countRooms[i]);
        }
    }
}
