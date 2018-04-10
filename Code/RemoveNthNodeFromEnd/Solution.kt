class Solution {
    fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
        var f: ListNode = head ?: return head
        for (i in 1 until n) {
            f = f.next!!
        }

        var pre: ListNode? = null
        var c: ListNode = head
        while (f.next != null) {
            f = f.next!!
            pre = c
            c = c.next!!
        }

        return if (pre == null) {
            val t = head.next
            head.next = null
            t
        } else {
            pre.next = c.next
            c.next = null
            
            head
        }
        
        
    }
}