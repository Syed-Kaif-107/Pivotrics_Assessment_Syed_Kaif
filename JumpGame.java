/*
Jump Game (Minimum Jumps)

Brute Force:
Try all jump combinations (Backtracking)
Time Complexity: O(2^n)

Optimized:
Greedy expansion of reachable index
Time Complexity: O(n)
*/

public class JumpGame {

    // Optimized Greedy (Brute not practical for n<=1000)
    public static int jumpOptimized(int[] nums) {
        int jumps = 0, far = 0, end = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            far = Math.max(far, i + nums[i]);
            if (i == end) {
                jumps++;
                end = far;
            }
        }
        return jumps;
    }

    public static void main(String[] args) {
        System.out.println("Optimized: " + jumpOptimized(new int[]{2,4,1,1,1,1})); // 2
    }
}
