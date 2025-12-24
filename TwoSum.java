import java.util.*;

/*
Two Sum

Brute Force:
Check all pairs using nested loops.
Time Complexity: O(n^2)
Space: O(1)

Optimized Approach:
Use HashMap to store visited values and check complement.
Time Complexity: O(n)
Space: O(n)
*/

public class TwoSum {

    // Brute Force
    public static int[] twoSumBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }

    // Optimized using HashMap
    public static int[] twoSumOptimized(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            if (map.containsKey(diff)) {
                return new int[]{map.get(diff), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6};
        int target = 7;

        System.out.println("Brute: " + Arrays.toString(twoSumBrute(arr, target)));
        System.out.println("Optimized: " + Arrays.toString(twoSumOptimized(arr, target)));
    }
}
