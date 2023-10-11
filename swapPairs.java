/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode current = head;
        ListNode newHead = head.next;

        while (current != null && current.next != null) {
            ListNode tmp = current.next;
            current.next = current.next.next;
            tmp.next = current;
            current = current.next;
            if (current != null && current.next != null) {
                tmp.next.next = current.next;
            }
        }

        return newHead;
    }
}
