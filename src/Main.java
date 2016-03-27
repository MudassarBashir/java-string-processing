import java.util.ArrayList;

/**
 * Created by mbashir on 3/24/2016.
 */

public class Main {

    public static void main(String[] args) {

        StringBuilder inputString = new StringBuilder("This is a string.");

        System.out.println(removeLeadingSpacesFromString(inputString.toString()));

    }

    public static String reverseStringWordForWord(StringBuilder inputString) {

        StringBuilder reversedString = new StringBuilder("");
        inputString = new StringBuilder(removeExtraSpacesFromString(inputString.toString()));
        int lastWorkingIndex = inputString.length() - 1;

        for (int currentIndex = lastWorkingIndex; currentIndex >= 0; currentIndex--) {

            if (currentIndex != 0) {
                if (inputString.charAt(currentIndex) == ' ') {
                    reversedString = reversedString.append(inputString.substring(currentIndex+1, lastWorkingIndex+1));
                    reversedString = reversedString.append(" ");
                    lastWorkingIndex = currentIndex-1;
                }
            }
            else {
                reversedString = reversedString.append(inputString.substring(0, lastWorkingIndex+1));
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
        else {
            inputString = removeLeadingSpacesFromStringRecursive(inputString.toString());
            inputString = removeFollowingSpacesFromStringRecursive(inputString.toString());
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
                }
                else {
                    index++;
                }
            }
            System.out.println(indicesToDelete.toString());
            int indexAdjuster = 0;
            for (Integer indexToDelete : indicesToDelete) {
                inputStringBuilder.deleteCharAt(indexToDelete+indexAdjuster);
                indexAdjuster--;
            }
            return inputStringBuilder.toString();
        }
    }

    public static boolean containsOnlySpaces(String inputString) {

        for (int counter=0; counter<=inputString.length()-1; counter++) {

            if (inputString.charAt(counter) != ' ') {
                return false;
            }
        }
        return true;
    }

    public static String removeLeadingSpacesFromStringRecursive(String inputString) {

        if (inputString.length() == 0 ||
                inputString.equals(' ')) {
            return "";
        }
        else if (inputString.charAt(0) != ' ') {
            return inputString;
        }
        else {
            return removeLeadingSpacesFromStringRecursive(
                    inputString.substring(1, inputString.length())
            );
        }
    }

    public static String removeLeadingSpacesFromString(String inputString) {

        if (inputString.length() == 0 || inputString.charAt(0) != ' ') {
            return inputString;
        }
        else if (inputString.equals(" ")) {
            return "";
        }
        else
        {
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
                inputString.equals(' ')) {
            return "";
        }
        else if (inputString.charAt(0) != ' ') {
            return inputString;
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

    public static String removeFollowingSpacesFromStringRecursive(String inputString) {

        if (inputString.length() == 0 ||
                inputString.equals(' ')) {
            return "";
        }
        else if (inputString.charAt(inputString.length()-1) != ' ') {
            return inputString;
        }
        else {
            return removeFollowingSpacesFromStringRecursive(
                    inputString.substring(0, inputString.length() - 1)
            );
        }
    }
}
