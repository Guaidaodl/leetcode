public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curNode1 = l1;
        ListNode curNode2 = l2;
        ListNode result = new ListNode(0);
        result.next = null;
        ListNode curNode = result;
        int p = 0;

        while (curNode1 != null && curNode2 != null) {
            int sum = (curNode1.val + curNode2.val + p) % 10;
            p = (curNode1.val + curNode2.val + p) / 10;

            curNode.next = new ListNode(sum);
            curNode = curNode.next;
            curNode.next = null;

            curNode1 = curNode1.next;
            curNode2 = curNode2.next;
        }

        while (curNode1 != null) {
            int sum = (curNode1.val + p) % 10;
            p = (curNode1.val + p) / 10;

            curNode.next = new ListNode(sum);
            curNode = curNode.next;
            curNode.next = null;

            curNode1 = curNode1.next;
        }
        while (curNode2 != null) {
            int sum = (curNode2.val + p) % 10;
            p = (curNode2.val + p) / 10;

            curNode.next = new ListNode(sum);
            curNode = curNode.next;
            curNode.next = null;

            curNode2 = curNode2.next;
        }

        if (p == 1) {
            curNode.next = new ListNode(1);
            curNode = curNode.next;
            curNode.next = null;
        }
        return result.next;
    }
}
