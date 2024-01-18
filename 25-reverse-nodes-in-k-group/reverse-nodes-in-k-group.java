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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1); // -1
        dummy.next = head;                 // -1 -> 1  -> 2 -> 3 -> 4 -> 5

        ListNode prev = dummy;
        ListNode curr = dummy.next; // dummy.next which is our head(ListNode curr = head; is also crct)
        ListNode nxt = dummy;

        int len = 0;

        while(curr != null){
            curr = curr.next;
            len++; // count the nodes
        }

        while(len >= k){
            curr = prev.next;
            nxt = curr.next;
            for(int i = 1 ; i < k ; i++){
                curr.next = nxt.next;
                nxt.next = prev.next;
                prev.next = nxt;
                nxt = curr.next;
            }

            prev = curr;
            len -= k;
        }


        return dummy.next;


    }
}

/*
        P      C     N
Dummy : -1 --> 1--> 2 --> 3 ; k= 2

        step -1 :  len count =2
                1   ->  3    
                2   ->  1 
                -1  ->  2
                2   ->  2
                
                     p     C     N
                -1 -> 2 -> 1 - > 3


                outside for loop belo
    Step -1:(prev = curr)          
                      P
                      C     N
                -1 -> 2 -> 1 - > 3
                
                len = 2 -2 = 0;

                so return

*/