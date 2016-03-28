import java.util.ArrayList;

/**
 * Created by mbashir on 3/24/2016.
 */

public class Main {

    public static void main(String[] args) {

        String inputString = "This    is a      string.";

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
            inputString.equals(' ') ||
            containsOnlySpaces(inputString)) {

            return "";
        }
        else
        {
            inputString = removeLeadingSpacesFromString(inputString);
            inputString = removeFollowingSpacesFromString(inputString);

            StringBuilder inputStringBuilder = new StringBuilder(inputString);
            int spaceEncounteredAtIndex;
            ArrayList<Integer> indicesToDelete = new ArrayList<Integer>();

            int index = 0;
            while (index <= inputString.length() - 1) {

                if (inputString.charAt(index) == ' ') {
                    spaceEncounteredAtIndex = index;

                    while (inputString.charAt(spaceEncounteredAtIndex + 1) == ' ') {
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

    public static boolean containsOnlySpaces(String inputString) {

        for (int counter = 0; counter <= inputString.length() - 1; counter++) {

            if (inputString.charAt(counter) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static String removeLeadingSpacesFromString(String inputString) {

        if (inputString.length() == 0 || inputString.charAt(0) != ' ') {

            return inputString;
        }
        else if (inputString.equals(" ")) {

            return "";
        }
        else {
            StringBuilder stringBuilder = new StringBuilder(inputString);
            int index = 0;
            while (stringBuilder.charAt(index) == ' ') {
                stringBuilder.deleteCharAt(index);
            }
            return stringBuilder.toString();
        }
    }

    public static String removeFollowingSpacesFromString(String inputString) {

        if (inputString.length() == 0 ||
            inputString.charAt(inputString.length()-1) != ' ') {

            return inputString;

        }
        else if (inputString.equals(" ")) {

            return "";

        }
        else {
            StringBuilder stringBuilder = new StringBuilder(inputString);
            int index = inputString.length()-1;
            while (stringBuilder.charAt(index) == ' ') {
                stringBuilder.deleteCharAt(index);
                index--;
            }
            return stringBuilder.toString();
        }
    }
}