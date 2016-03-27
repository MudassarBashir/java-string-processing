import java.util.*;

public class StringProcessor {

    public static void main(String[] args) {

        String original;
        Scanner in = new Scanner(System.in);

        System.out.println("Please enter a string to reverse: ");
        original = in.nextLine();

        System.out.println(reverseWordsInString(original));
    }

    public static String reverseWordsInString(String str) {

        StringBuilder revStr = new StringBuilder("");
        int end = str.length();
        int counter = end - 1;

        for (int i = counter; i >= 0; i--) {
            if (str.charAt(i) == ' ' || i == 0) {
                if (i != 0) {
                    revStr.append(str.substring(i + 1, end));
                    revStr.append(" ");
                } else {
                    revStr.append(str.substring(i, end));
                }
                end = counter;
            }
            counter--;
        }

        return revStr.toString();
    }
}