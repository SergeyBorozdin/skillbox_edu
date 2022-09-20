public class ForeachMassive {

    public static void main(String[] args) {


        // =============

        String text = "каждый охотник знает, где сидит фазан";
        String[] words = text.split("[,]?[\\s]+");
        for (String word : words) {
            System.out.println(word);
        }

        // ================
        String wordsText = "Арбуз Безвозмездно дарован дарован звонкоголосым Работникам шахтыт";
        String[] words2 = wordsText.split("[,]?[\\s]+");
        for (int i = 0; i < words2.length; i++) {
            if (i > 0 && words2[i].equals(words2[i - 1])) {
                continue;
            }
            System.out.println(words2[i]);
        }

        // ===============

        int[] ticketNumbers = new int[1000];
        int[] winTicket = new int[10];

        for (int i = 0; i < ticketNumbers.length; i++) {
            int value = 1_000_000 + (int)Math.round(1_000_000 * Math.random());
            ticketNumbers[i] = value;
            if (i % 100 == 0) {
                winTicket[i / 100] = value;
            }
        }

        for (int ticket : winTicket) {
            System.out.println(ticket);
        }
    }
}
