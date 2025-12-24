import java.util.Arrays;

/*
Product of Array Except Self

Brute Force:
Multiply all elements except current index using nested loops.
Time Complexity: O(n^2), Space: O(1)

Optimized:
Use Prefix and Suffix arrays to store left and right products.
Time Complexity: O(n), Space: O(n)
*/

public class ProductOfArrayExceptSelf {

    // Brute Force Solution
    public static int[] productExceptSelfBrute(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        for (int i = 0; i < n; i++) {
            int product = 1;
            for (int j = 0; j < n; j++) {
                if (i != j) product *= nums[j];
            }
            result[i] = product;
        }
        return result;
    }

    // Optimized Solution (Prefix + Suffix)
    public static int[] productExceptSelfOptimized(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] output = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++)
            left[i] = left[i - 1] * nums[i - 1];

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            right[i] = right[i + 1] * nums[i + 1];

        for (int i = 0; i < n; i++)
            output[i] = left[i] * right[i];

        return output;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 4, 6};

        System.out.println("Brute: " + Arrays.toString(productExceptSelfBrute(nums)));
        System.out.println("Optimized: " + Arrays.toString(productExceptSelfOptimized(nums)));
    }
}
