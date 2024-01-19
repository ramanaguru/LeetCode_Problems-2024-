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
    public ListNode deleteDuplicates(ListNode head) {
        //create a dummy and have tarck of prev & head
        
        ListNode dummy = new ListNode(-1);          
        dummy.next = head; // dummy Node looks like {-1 -> 1--> 1--> 2--> 4}

        ListNode prev = dummy ;  //prev = -1

        while(head != null){           
    //first case ==> head == head.next.val  so find where should prev.next  point and head(ex our input: 1--> 1--> 2--> 4)
            if(head.next != null && head.val == head.next.val){
              
                while(head.next != null && head.val == head.next.val){
                  head = head.next; // keep on check whether head is equls to  head.next.val
                }

                //if not update prev.next pointer ()
                prev.next = head.next;
            }

            //Second case ==> head.val != head.next.val (ex: 1--> 2--> 4 -> 4 -> 5)
            //simply update prev pointer
            else{
                prev = prev.next;
            }

            head = head.next;

        }

        return dummy.next;
        

    }
}
