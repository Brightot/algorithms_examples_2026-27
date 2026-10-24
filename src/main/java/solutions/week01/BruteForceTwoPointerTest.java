
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
        System.out.println(BruteForceTwoPointer.arraysEqualTwoPointer(first, second));
        System.out.println(BruteForceTwoPointer.arraysEqualTwoPointer(first, third));
        System.out.println(BruteForceTwoPointer.arraysEqualTwoPointer(first, fourth));

        int[] empty1 = {};
        int[] empty2 = {};
        int[] duplicates1 = {2, 2, 5};
        int[] duplicates2 = {5, 2, 2};

        System.out.println(BruteForceTwoPointer.arraysEqualBruteForce(empty1, empty2));
        System.out.println(BruteForceTwoPointer.arraysEqualTwoPointer(empty1, empty2));

        System.out.println(BruteForceTwoPointer.arraysEqualBruteForce(duplicates1, duplicates2));
        System.out.println(BruteForceTwoPointer.arraysEqualTwoPointer(duplicates1, duplicates2));


        System.out.println(BruteForceTwoPointer.isPalindromeBruteForce("madam"));
        System.out.println(BruteForceTwoPointer.isPalindromeBruteForce("RaceCar"));
        System.out.println(BruteForceTwoPointer.isPalindromeBruteForce("A man, a plan, a canal: Panama!"));
        System.out.println(BruteForceTwoPointer.isPalindromeBruteForce("hello"));


        System.out.println(BruteForceTwoPointer.isPalindromeTwoPointer("madam"));
        System.out.println(BruteForceTwoPointer.isPalindromeTwoPointer("RaceCar"));
        System.out.println(BruteForceTwoPointer.isPalindromeTwoPointer("A man, a plan, a canal: Panama!"));
        System.out.println(BruteForceTwoPointer.isPalindromeTwoPointer("hello"));


        int[] numbers = {2, 3, 1, 2, 4, 3};

        int[] result1 = BruteForceTwoPointer.shortestSubarrayBruteForce(numbers, 7);
        System.out.println(java.util.Arrays.toString(result1));

        int[] result2 = BruteForceTwoPointer.shortestSubarrayBruteForce(numbers, 20);
        System.out.println(java.util.Arrays.toString(result2));

        int[] result3 = BruteForceTwoPointer.shortestSubarrayBruteForce(new int[]{5}, 5);
        System.out.println(java.util.Arrays.toString(result3));


        int[] result4 = BruteForceTwoPointer.shortestSubarrayTwoPointer(numbers, 7);
        System.out.println(java.util.Arrays.toString(result4));

        int[] result5 = BruteForceTwoPointer.shortestSubarrayTwoPointer(numbers, 20);
        System.out.println(java.util.Arrays.toString(result5));

        int[] result6 = BruteForceTwoPointer.shortestSubarrayTwoPointer(new int[]{5}, 5);
        System.out.println(java.util.Arrays.toString(result6));

    }

}
