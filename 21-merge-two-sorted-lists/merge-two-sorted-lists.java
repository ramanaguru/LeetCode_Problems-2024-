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
    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while(A != null && B != null){
            if(A.val < B.val){
                temp.next   = A;
                temp        = A;
                A           = A.next;
            }
            else{
                temp.next   = B;
                temp        = B;
                B           = B.next;
            }
        }
        //Edge case 
        if(A == null){
            temp.next = B;
        }
        if(B == null){
            temp.next = A;
        }

        return ans.next;
    }
}