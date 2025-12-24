import java.util.*;

/*
Longest Substring Without Repeating Characters

Brute Force:
Check all substrings and verify uniqueness
Time Complexity: O(n^3)

Optimized:
Sliding Window + HashSet
Time Complexity: O(n)
*/

public class LongestSubstring {

    // Brute Force
    public static int lengthOfLongestSubstringBrute(String s) {
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            Set<Character> set = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                if (set.contains(s.charAt(j))) break;
                set.add(s.charAt(j));
                max = Math.max(max, j - i + 1);
            }
        }
        return max;
    }

    // Optimized Sliding Window
    public static int lengthOfLongestSubstringOptimized(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for (int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(i));
            max = Math.max(max, i - left + 1);
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println("Brute: " + lengthOfLongestSubstringBrute("zxyzxyz"));
        System.out.println("Optimized: " + lengthOfLongestSubstringOptimized("zxyzxyz"));
    }
}
