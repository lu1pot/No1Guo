package offer06;

import java.util.List;

class Solution {

    public int[] reversePrint(ListNode head) {
        ListNode node = head;
        int length = 0;
        while (node != null){
            node = node.next;
            length ++;
        }
        int[] nums = new int[length];
        node = head;

        for (int i = length - 1; i >=0 ; i--) {
            nums[i] = node.val;
            node = node.next;
        }
        return nums;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);

        head.next = node1;
        head.next.next = node2;


        ListNode node = head;
        int length = 0;
        while (node != null){
            node = node.next;
            length ++;
        }

        System.out.println(length);
    }
}
