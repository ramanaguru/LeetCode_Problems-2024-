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
    public ListNode oddEvenList(ListNode head) {

        //Goal --> TC : O(N)    ;  SC : o(1)     so our idea nd approach solves this

        if(head == null || head.next == null) return head; 

        ListNode odd    = head; //odd points to the first node 

        ListNode even   = head.next;   //even points to the second node
        ListNode evenHead = head.next; //evenHead will be used at the end to connect odd and even nodes

        //even is always ahead odd please do dry run u will understand i.e(odd -> even --> odd -> even)

        //       evenHead
        //odd ->   even   --> odd -> even
        // odd -> odd --> even --> even (evenHead helps us in this way please do dry run)

        while(even != null && even.next != null){
        
            odd.next = odd.next.next;   //Connect the current odd node to the next odd node
            odd = odd.next;             //Move the current odd node to the next odd node

            even.next = even.next.next; //Connect the current even node to the next even node
            even = even.next;           //Move the current evn node to the next even node
        }

        odd.next = evenHead;  //Connect the last odd node to the start of the even node(i.e evenHead)


        return head; // head never changed, so return it
        
    }
}