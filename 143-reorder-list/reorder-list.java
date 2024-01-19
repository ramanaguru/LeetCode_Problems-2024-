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
    public ListNode reorderList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }

        ListNode mid = getMid(head);

        ListNode afterMid = mid.next;
        mid.next = null;

        ListNode afterMidReverse = reverse(afterMid);  //not the best name afterMidReverse

        ListNode start = head;

        while(start.next != null){
            ListNode t1 = start.next;
            ListNode t2 = afterMidReverse.next;
            start.next = afterMidReverse;
            start = t1;
            afterMidReverse.next = start;
            afterMidReverse = t2;
        }

        if(afterMidReverse != null){
            start.next = afterMidReverse;
        }

        return head;


    }
    public ListNode getMid(ListNode A){
        ListNode slow = A;
        ListNode fast = A;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }

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