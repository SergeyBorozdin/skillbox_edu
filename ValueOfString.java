public class ValueOfString {

    public static void main(String[] args) {

        String name = "Anna";
        int age = 36;
        Integer age2 = 65;
        String chislo = "123457";


        System.out.println(Integer.valueOf(age));
        String value = age2.toString();
        System.out.println(value);
        int valueOtChislo = Integer.valueOf(chislo);
        System.out.println(valueOtChislo);
    }
}