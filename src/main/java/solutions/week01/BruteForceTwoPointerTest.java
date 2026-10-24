
package solutions.week01;

import java.util.Arrays;

public class BruteForceTwoPointerTest {

    public static void main(String[] args) {
        int[] first = {4, 2, 7};
        int[] second = {7, 4, 2};
        int[] third = {7, 4, 4};
        int[] fourth = {4, 2};

        System.out.println(BruteForceTwoPointer.arraysEqualBruteForce(first, second));
        System.out.println(BruteForceTwoPointer.arraysEqualBruteForce(first, third));
        System.out.println(BruteForceTwoPointer.arraysEqualBruteForce(first, fourth));
    }
}
