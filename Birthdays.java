import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class Birthdays {

    public static final String NEW_LINE = System.lineSeparator();

    public static void main(String[] args) {

        int day = 10;
        int month = 11;
        int year = 1985;
        System.out.println(collectBirthdays(year, month, day));

        LocalDate now = LocalDate.now();
        LocalDate dataJ = LocalDate.of(1995,5, 23);
        System.out.println(getPeriodFromBirthday(dataJ, now));

    }

    public static String getPeriodFromBirthday(LocalDate firstDate, LocalDate secondDate) {
        long years = firstDate.until(secondDate, ChronoUnit.YEARS);
        long month = firstDate.plusYears(years).until(secondDate, ChronoUnit.MONTHS);
        long days = firstDate.plusMonths(month + (years * 12)).until(secondDate, ChronoUnit.DAYS);
        return "Years - " + years + NEW_LINE + "Months - " + month + NEW_LINE + "Days - " + days;
    }


    public static String collectBirthdays(int year, int month, int day) {
        String result = "";
        LocalDate now = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy - EEE").localizedBy(new Locale("en"));
        LocalDate bir = LocalDate.of(year, month, day);

        int difference = now.compareTo(bir);
        for (int i = 0; i <= difference; i++) {
            result = result + i + " - " + formatter.format(bir.plusYears(i)) + NEW_LINE;
        }
        //TODO реализуйте метод для построения строки в следующем виде
        //0 - 31.12.1990 - Mon
        //1 - 31.12.1991 - Tue
        return result;
    }
}
