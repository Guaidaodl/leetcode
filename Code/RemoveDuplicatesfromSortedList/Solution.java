/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null)
            return head;
        ListNode curNode = head;
        ListNode preNode = head;
        while(curNode.next != null) {
            curNode = curNode.next;
            if (curNode.val == preNode.val) {
                preNode.next = curNode.next;
            } else {
                preNode = curNode;
            }
        }
        
        return head;
    }
}