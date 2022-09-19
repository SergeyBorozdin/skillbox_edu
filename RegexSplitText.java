public class RegexSplitText {

    public static void main(String[] args) {
        String text = "The three little pigs are brothers. They are going into the forest. They want to build three houses. Let’s build our houses here, says the first little pig, Percy. Yes, says the second little pig, Peter. That’s a good idea, says the third little pig, Patrick. The first little pig, Percy, gets some straw and he starts to build a house of straw. He sings, Hum de hum, dum de dum, hee de dum, dee de hum, when he works";

        System.out.println(splitTextIntoWords(text));

    }

    public static String splitTextIntoWords(String text) {
        String regex = "[\s]";
        return text.replaceAll(regex, "\n");
    }

}
