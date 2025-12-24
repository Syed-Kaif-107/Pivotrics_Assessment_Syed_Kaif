import java.util.*;

/*
Sort Characters by Frequency

Brute Force:
Count frequency manually for each character using repeated scanning.
Time Complexity: O(n^2)

Optimized:
Use HashMap + Sorting frequency
Time Complexity: O(n log n)
*/

public class SortCharactersByFrequency {

    // Brute
    public static String frequencySortBrute(String s) {
        boolean[] visited = new boolean[256];
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (visited[s.charAt(i)]) continue;

            int count = 0;
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) count++;
            }

            visited[s.charAt(i)] = true;

            for (int k = 0; k < count; k++) {
                result.append(s.charAt(i));
            }
        }
        return result.toString();
    }

    // Optimized
    public static String frequencySortOptimized(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> list = new ArrayList<>(map.keySet());
        list.sort((a, b) -> map.get(b) - map.get(a));

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            for (int k = 0; k < map.get(c); k++) {
                sb.append(c);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println("Brute: " + frequencySortBrute("tree"));
        System.out.println("Optimized: " + frequencySortOptimized("tree"));
    }
}
