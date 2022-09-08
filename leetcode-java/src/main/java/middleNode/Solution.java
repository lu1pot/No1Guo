package middleNode;

public class Solution {
    public ListNode middleNode(ListNode head) {
        int len = 0;
        ListNode p = head;
        while(p != null){
            len ++;
            p = p.next;
        }
        len = len >>> 1;
        p = head;
        for (int i = 0; i < len; i++) {
            p = p.next;
        }
        return p;
    }

    public ListNode middleNode0(ListNode head) {
        ListNode slow,fast;
        slow = fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
