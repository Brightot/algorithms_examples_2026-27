
package solutions.week01;

public class BruteForceTwoPointer {

    /**
     * Checks whether two integer arrays contain the same values,
     * including duplicates, regardless of their order.
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
}
