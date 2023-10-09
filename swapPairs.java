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
        ListNode tmp = new ListNode();
        tmp.next = head;
        ListNode result = tmp;

        while (tmp != null) {
            if (tmp.next == null || tmp.next.next == null) {
                break;
            }
           
            ListNode nextHead = tmp.next;
            tmp.next = tmp.next.next;
            if (nextHead.next.next == null) nextHead.next = null;
            else {
                nextHead.next = nextHead.next.next;
            }
            tmp.next.next = nextHead;

            tmp = tmp.next.next;
        }

        return result.next;
    }
}
