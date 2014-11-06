/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        int i = 1;
        while (slowPtr != null && fastPtr != null){
            if (i % 2 == 0)
                slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
            if (fastPtr == slowPtr)
                return true;
            i = (i + 1) % 2;
        }

        return false;
    }
}
