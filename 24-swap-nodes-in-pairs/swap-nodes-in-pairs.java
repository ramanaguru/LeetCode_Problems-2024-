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
        // declare two nodes and assign at 1st and 2nd position (prev and curr)
        // swap values of these 2 nodes
        // update prev = curr.next
        // update curr = prev.next {i.e by 2 positions.} DRY RUN IT WILL MAKE SENSE
        // check curr.next for null pointer expection and exist
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null){
            int temp = prev.val;
            prev.val = curr.val;
            curr.val = temp;

            if(curr.next == null){
                return head;
            }

            prev = curr.next;
            curr = prev.next;
        }

        return head;

    }
}