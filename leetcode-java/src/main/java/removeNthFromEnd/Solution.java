package removeNthFromEnd;

import likouUtils.ListNode;

public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode pre = new ListNode(0,head);
        ListNode slow = pre;
        while(n>0 &&  fast !=null){
            fast = fast.next;
            n--;
        }
        while(fast!=null){
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;

        return pre.next;
    }
}
