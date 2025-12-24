/*
Add Two Numbers

Brute Force:
Convert linked lists to numbers, add and rebuild list
Time Complexity: O(n)

Optimized:
Digit-wise addition with carry
Time Complexity: O(n)
Space: O(n)
*/

class ListNode {
    int val;
    ListNode next;
    ListNode(int val) { this.val = val; }
}

public class AddTwoNumbers {

    // Optimized
    public static ListNode addTwoNumbersOptimized(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0), temp = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            if (l1 != null) { sum += l1.val; l1 = l1.next; }
            if (l2 != null) { sum += l2.val; l2 = l2.next; }

            carry = sum / 10;
            temp.next = new ListNode(sum % 10);
            temp = temp.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("Optimized running...");
    }
}
