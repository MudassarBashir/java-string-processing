/**
 * Created by mbashir on 3/24/2016.
 */

public class Main {

    public static void main(String[] args) {

        String inputString = "   This   is a      string.   ";

        System.out.println(reverseStringWordForWord(inputString));

    }

    public static String reverseStringWordForWord(String inputString) {

        // Remove all leading, trailing, and intermediate extra spaces.
        StringBuilder inputStringBuilder = new StringBuilder(inputString.replaceAll("\\s+", " ").trim());

        // If removing extra spaces results in an empty string. Meaning the original string was either empty
        // or white spaces only.
        if (inputStringBuilder.equals("")) {

            return "";
        }

        // This will hold the result as it is being built.
        StringBuilder reversedString = new StringBuilder("");
        int lastWorkingIndex = inputStringBuilder.length() - 1;

        // Iterate backwards through the original string.
        for (int currentIndex = lastWorkingIndex; currentIndex >= 0; currentIndex--) {

            if (currentIndex != 0) {
                if (inputStringBuilder.charAt(currentIndex) == ' ') {
                    // append the last encountered word.
                    reversedString = reversedString.append(inputStringBuilder.substring(currentIndex + 1, lastWorkingIndex + 1));
                    reversedString = reversedString.append(" ");
                    lastWorkingIndex = currentIndex - 1;
                }
            } else {
                // We've reached the begining of the string so just append the last word 'seen'.
                reversedString = reversedString.append(inputStringBuilder.substring(0, lastWorkingIndex + 1));
            }
        }
        return reversedString.toString();
    }
}