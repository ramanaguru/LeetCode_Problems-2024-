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
    public ListNode swapPairs(ListNode A) {
       // declare two nodes and assign at 1st and 2nd position (prev and curr)
        // swap values of these 2 nodes
        // update prev = curr.next
        // update curr = prev.next -->  i.e by 2 positions.
        // check curr.next for null pointer expection

        if(A == null) return null;
        if(A.next == null ) return A;

        ListNode prev = A;
        ListNode curr = A.next;

        while(curr !=null){
            int tempVal = prev.val;
            prev.val = curr.val;
            curr.val = tempVal;
            if(curr.next == null){
                return A;
            }
            prev = curr.next;
            curr = prev.next; 
        }
        return A;

    }
}