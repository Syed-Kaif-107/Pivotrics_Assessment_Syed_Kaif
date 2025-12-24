
/*
Search in Rotated Sorted Array

Brute Force:
Linearly search entire array.
Time Complexity: O(n)
Space: O(1)

Optimized:
Binary Search with pivot detection
Time Complexity: O(log n)
Space: O(1)
*/

public class SearchRotatedSortedArray {

    // Brute Force
    public static int searchBrute(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    // Optimized Binary Search
    public static int searchOptimized(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) return mid;

            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) right = mid - 1;
                else left = mid + 1;
            } else {
                if (target > nums[mid] && target <= nums[right]) left = mid + 1;
                else right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("Brute: " + searchBrute(new int[]{3,4,5,6,1,2}, 1));
        System.out.println("Optimized: " + searchOptimized(new int[]{3,4,5,6,1,2}, 1));
    }
}
