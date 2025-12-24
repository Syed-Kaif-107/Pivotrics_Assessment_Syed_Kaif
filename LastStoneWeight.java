
import java.util.*;

/*
Last Stone Weight

Brute Force:
Repeatedly sort array and smash two largest stones.
Time Complexity: O(n^2 log n)
Space: O(1)

Optimized:
Use Max Heap (PriorityQueue with reverse order)
Time Complexity: O(n log n)
Space: O(n)
*/

public class LastStoneWeight {

    // Brute Force
    public static int lastStoneWeightBrute(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int s : stones) list.add(s);

        while (list.size() > 1) {
            Collections.sort(list);
            int y = list.remove(list.size() - 1);
            int x = list.remove(list.size() - 1);

            if (x != y) list.add(y - x);
        }
        return list.isEmpty() ? 0 : list.get((int)0);
    }

    // Optimized: Max Heap
    public static int lastStoneWeightOptimized(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int s : stones) pq.add(s);

        while (pq.size() > 1) {
            int y = pq.poll();
            int x = pq.poll();
            if (x != y) pq.add(y - x);
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }

    public static void main(String[] args) {
        int[] stones = {2, 3, 6, 2, 4};

        System.out.println("Brute: " + lastStoneWeightBrute(stones));
        System.out.println("Optimized: " + lastStoneWeightOptimized(stones));
    }
}
