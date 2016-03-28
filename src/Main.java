import java.util.ArrayList;

/**
 * Created by mbashir on 3/24/2016.
 */

public class Main {

    public static void main(String[] args) {

        String inputString = "   This is a    string.    ";

        System.out.println(reverseStringWordForWord(inputString));

    }

    public static String reverseStringWordForWord(String inputString) {

        StringBuilder reversedString = new StringBuilder("");
        StringBuilder inputStringBuilder = new StringBuilder(removeExtraSpacesFromString(inputString));
        int lastWorkingIndex = inputStringBuilder.length() - 1;

        for (int currentIndex = lastWorkingIndex; currentIndex >= 0; currentIndex--) {

            if (currentIndex != 0) {
                if (inputStringBuilder.charAt(currentIndex) == ' ') {
                    reversedString = reversedString.append(inputStringBuilder.substring(currentIndex + 1, lastWorkingIndex + 1));
                    reversedString = reversedString.append(" ");
                    lastWorkingIndex = currentIndex - 1;
                }
            } else {
                reversedString = reversedString.append(inputStringBuilder.substring(0, lastWorkingIndex + 1));
            }
        }
        return reversedString.toString();
    }

    public static String removeExtraSpacesFromString(String inputString) {

        if (inputString.length() == 0 ||
            inputString.equals(" ")) {

            return "";

        }
        else {

            StringBuilder inputStringBuilder = new StringBuilder(inputString.trim());
            int spaceEncounteredAtIndex;
            ArrayList<Integer> indicesToDelete = new ArrayList<Integer>();

            int index = 0;
            while (index <= inputStringBuilder.length() - 1) {

                if (inputStringBuilder.charAt(index) == ' ') {
                    spaceEncounteredAtIndex = index;

                    while (inputStringBuilder.charAt(spaceEncounteredAtIndex + 1) == ' ') {
                        indicesToDelete.add(spaceEncounteredAtIndex + 1);
                        spaceEncounteredAtIndex++;
                    }
                    index = spaceEncounteredAtIndex + 2;
                } else {
                    index++;
                }
            }
            int indexAdjuster = 0;
            for (Integer indexToDelete : indicesToDelete) {
                inputStringBuilder.deleteCharAt(indexToDelete + indexAdjuster);
                indexAdjuster--;
            }
            return inputStringBuilder.toString();
        }
    }
}