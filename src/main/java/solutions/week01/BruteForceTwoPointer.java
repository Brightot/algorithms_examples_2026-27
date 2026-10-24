
package solutions.week01;

public class BruteForceTwoPointer {


    /**
     * Checks whether two integer arrays contain the same values,
     * including duplicates, regardless of their order.
     *
     * Simplifications:
     * - Both arrays are assumed to be non-null.
     * - n represents the length of each array when lengths are equal.
     *
     * Time complexity: O(n^2) in the worst case.
     * Auxiliary space complexity: O(n) for the matched array.
     *
     * Contraindications:
     * - This approach is inefficient for large arrays because it uses
     *   nested loops.
     *
     * @param first the first array
     * @param second the second array
     * @return true if both arrays contain the same values, false otherwise
     */

    public static boolean arraysEqualBruteForce(int[] first, int[] second) {
        if (first.length != second.length) {
            return false;
        }

        boolean[] matched = new boolean[second.length];

        for (int i = 0; i < first.length; i++) {
            boolean found = false;

            for (int j = 0; j < second.length; j++) {
                if (!matched[j] && first[i] == second[j]) {
                    matched[j] = true;
                    found = true;
                    break;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }


    /**
     * Checks whether two integer arrays contain the same values,
     * including duplicates, regardless of their order.
     * The method sorts copies so the original arrays are not changed.
     *
     * Simplifications:
     * - Both arrays are assumed to be non-null.
     * - n represents the length of each array when lengths are equal.
     *
     * Time complexity: O(n log n) in the worst case.
     * Auxiliary space complexity: O(n) for the copied arrays.
     *
     * Contraindications:
     * - Sorting adds overhead for very small arrays.
     * - This method needs extra memory to copy both arrays.
     *
     * @param first the first array
     * @param second the second array
     * @return true if both arrays contain the same values, false otherwise
     */

    public static boolean arraysEqualTwoPointer(int[] first, int[] second) {
        if (first.length != second.length) {
            return false;
        }

        int[] firstCopy = java.util.Arrays.copyOf(first, first.length);
        int[] secondCopy = java.util.Arrays.copyOf(second, second.length);

        java.util.Arrays.sort(firstCopy);
        java.util.Arrays.sort(secondCopy);

        int left = 0;
        int right = 0;

        while (left < firstCopy.length && right < secondCopy.length) {
            if (firstCopy[left] != secondCopy[right]) {
                return false;
            }

            left++;
            right++;
        }

        return true;
    }

    /**
     * Checks whether a string is a palindrome, ignoring case,
     * spaces and punctuation.
     *
     * Simplifications:
     * - The input string is assumed to be non-null.
     * - Only letters and digits are compared.
     *
     * Time complexity: O(n) time.
     * Auxiliary space complexity: O(n) for the cleaned string.
     *
     * Contraindications:
     * - Creates an extra string, which uses additional memory.
     *
     * @param text the string to check
     * @return true if the string is a palindrome, false otherwise
     */

    public static boolean isPalindromeBruteForce(String text) {
        String cleaned = "";

        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);

            if (Character.isLetterOrDigit(ch)) {
                cleaned = cleaned + Character.toLowerCase(ch);
            }
        }

        for (int i = 0; i < cleaned.length() / 2; i++) {
            if (cleaned.charAt(i) != cleaned.charAt(cleaned.length() - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Checks whether a string is a palindrome using two pointers,
     * ignoring case, spaces and punctuation.
     *
     * Simplifications:
     * - The input string is assumed to be non-null.
     * - Only letters and digits are compared.
     *
     * Time complexity: O(n).
     * Auxiliary space complexity: O(1).
     *
     * Contraindications:
     * - The method does not create a cleaned copy of the input.
     * - It is unsuitable if a cleaned version of the string is also required.
     *
     * @param text the string to check
     * @return true if the string is a palindrome, false otherwise
     */
    public static boolean isPalindromeTwoPointer(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(text.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(text.charAt(right))) {
                right--;
            }

            if (Character.toLowerCase(text.charAt(left))
                    != Character.toLowerCase(text.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

}
