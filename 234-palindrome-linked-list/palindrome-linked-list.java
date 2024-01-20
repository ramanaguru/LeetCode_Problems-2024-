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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = getReverse(slow.next);

        slow = slow.next;

        while(slow != null){
            if(head.val != slow.val){
                return false;
            }
            slow = slow.next;
            head = head.next; 
        }

        return true;
    }


    public ListNode getReverse(ListNode head){
        ListNode h1 = head;
        ListNode h2 = null;

        while(h1 != null){
            ListNode temp = h1;
            h1 = h1.next;
            temp.next = h2;
            h2 = temp;
        }

        return h2;
    }

}