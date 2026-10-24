
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
     * Time complexity: O(n^2) in the worst case due to string concatenation.
     * Auxiliary space complexity: O(n) for the cleaned string.
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

    /**
     * Finds the shortest contiguous subarray with a sum greater than
     * or equal to the target using brute force.
     *
     * Simplifications:
     * - The array contains positive integers.
     * - The array is assumed to be non-null.
     * - Start and end positions are zero-based indices.
     *
     * Time complexity: O(n^2) in the worst case.
     * Auxiliary space complexity: O(1).
     *
     * Contraindications:
     * - This approach can be slow for large arrays because it checks
     *   many possible subarrays.
     *
     * @param numbers the array of positive integers
     * @param target the required minimum sum
     * @return an array containing the start and end indices, or {0}
     *         if no valid subarray exists
     */
    public static int[] shortestSubarrayBruteForce(int[] numbers, int target) {
        int shortestLength = numbers.length + 1;
        int bestStart = -1;
        int bestEnd = -1;

        for (int start = 0; start < numbers.length; start++) {
            int sum = 0;

            for (int end = start; end < numbers.length; end++) {
                sum += numbers[end];

                if (sum >= target) {
                    int length = end - start + 1;

                    if (length < shortestLength) {
                        shortestLength = length;
                        bestStart = start;
                        bestEnd = end;
                    }

                    break;
                }
            }
        }

        if (bestStart == -1) {
            return new int[]{0};
        }

        return new int[]{bestStart, bestEnd};
    }

    /**
     * Finds the shortest contiguous subarray whose sum is at least
     * the target, using a sliding window.
     *
     * Simplifications:
     * - All array elements are positive integers.
     * - The array is assumed to be non-null.
     * - Start and end positions are zero-based indices.
     *
     * Time complexity: O(n).
     * Auxiliary space complexity: O(1).
     *
     * Contraindications:
     * - The sliding-window approach is not generally suitable for
     *   arrays containing negative numbers.
     *
     * @param numbers the array of positive integers
     * @param target the required minimum sum
     * @return an array containing the start and end indices, or {0}
     *         if no valid subarray exists
     */
    public static int[] shortestSubarrayTwoPointer(int[] numbers, int target) {
        int left = 0;
        int sum = 0;
        int shortestLength = numbers.length + 1;
        int bestStart = -1;
        int bestEnd = -1;

        for (int right = 0; right < numbers.length; right++) {
            sum += numbers[right];

            while (sum >= target && left <= right) {
                int length = right - left + 1;

                if (length < shortestLength) {
                    shortestLength = length;
                    bestStart = left;
                    bestEnd = right;
                }

                sum -= numbers[left];
                left++;
            }
        }

        if (bestStart == -1) {
            return new int[]{0};
        }

        return new int[]{bestStart, bestEnd};
    }

    /**
     * Reverses the vowels in a string using a brute-force approach.
     *
     * Simplifications:
     * - The input string is assumed to be non-null.
     * - Vowels are a, e, i, o and u, ignoring case.
     *
     * Time complexity: O(n).
     * Auxiliary space complexity: O(n).
     *
     * Contraindications:
     * - Creates an additional character array and a vowel array.
     *
     * @param text the original string
     * @return a string with its vowels reversed
     */
    public static String reverseVowelsBruteForce(String text) {
        char[] characters = text.toCharArray();
        char[] vowels = new char[characters.length];
        int count = 0;

        for (int i = 0; i < characters.length; i++) {
            char ch = Character.toLowerCase(characters[i]);

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                vowels[count] = characters[i];
                count++;
            }
        }

        for (int i = 0; i < characters.length; i++) {
            char ch = Character.toLowerCase(characters[i]);

            if (ch == 'a' || ch == 'e' || ch == 'i'
                    || ch == 'o' || ch == 'u') {
                count--;
                characters[i] = vowels[count];
            }
        }

        return new String(characters);
    }

    /**
     * Reverses the vowels in a string using two pointers.
     *
     * Simplifications:
     * - The input string is assumed to be non-null.
     * - Vowels are a, e, i, o and u, ignoring case.
     *
     * Time complexity: O(n).
     * Auxiliary space complexity: O(n) for the character array.
     *
     * Contraindications:
     * - Creates a character array because Java strings are immutable.
     *
     * @param text the original string
     * @return a string with its vowels reversed
     */
    public static String reverseVowelsTwoPointer(String text) {
        char[] characters = text.toCharArray();
        int left = 0;
        int right = characters.length - 1;

        while (left < right) {
            while (left < right && !isVowel(characters[left])) {
                left++;
            }

            while (left < right && !isVowel(characters[right])) {
                right--;
            }

            if (left < right) {
                char temp = characters[left];
                characters[left] = characters[right];
                characters[right] = temp;

                left++;
                right--;
            }
        }

        return new String(characters);
    }

    private static boolean isVowel(char ch) {
        ch = Character.toLowerCase(ch);

        return ch == 'a' || ch == 'e' || ch == 'i'
                || ch == 'o' || ch == 'u';
    }


}
