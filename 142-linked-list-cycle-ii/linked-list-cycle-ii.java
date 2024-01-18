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
    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(slow != null){
            if(fast == null || fast.next == null)return null; // no cycle

            //move slow +1 and fast+2
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                break;
            }      
        }

        slow = head;

        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}