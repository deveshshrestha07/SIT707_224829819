package sit707_week6;

public class LoopCoverage{

    /**
     * Function 1: Simple conditional loop.
     * Sums all integers from 1 to n.
     *
     * @param n upper limit
     * @return sum of numbers from 1 to n
     */
    public static int sumUpToN(int n) {
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        return sum;
    }

    /**
     * Function 2: Loop with conditional statement inside.
     * Counts even numbers in an array.
     *
     * @param arr input integer array
     * @return number of even integers
     */
    public static int countEvenNumbers(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        return count;
    }
}
