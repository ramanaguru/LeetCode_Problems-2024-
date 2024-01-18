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
    public ListNode reverseBetween(ListNode A, int B, int C) {
        //Given LinkedList A , reverse from B(left) to C(right)
        ListNode temp = A;
        
        ListNode first  = null;
        ListNode  last  = null;
        ListNode  from  = null;
        ListNode    to  = null;

        int count = 0;

        while(temp != null){
            count++;
            if(count < B){
                first = temp;
            }
            if(count == B){
                from = temp;
            }
            if(count == C){
                to = temp;
                last= to.next;
            }
            temp = temp.next;
        }

        to.next = null;
        reverse(from);

        if(first != null){
            first.next = to;
        }
        else{
            A= to;
        }

        from.next = last;
        return A;

    }
    public ListNode reverse(ListNode head){
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