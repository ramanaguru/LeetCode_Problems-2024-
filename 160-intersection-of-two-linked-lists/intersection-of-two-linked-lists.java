/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode A, ListNode B) {

        ListNode t1 = A;
        ListNode t2 = B;

        int p1 = 0;
        int p2 = 0;

        while(A != null){
            p1++;
            A = A.next;
        } 

        while(B != null){
            p2++;
            B = B.next;
        }
        

        int size = Math.abs(p1 - p2); // size difference and we can skip the exceed and place the temp1 or temp2 according to it

        if(p1 > p2){
            for(int i = 0; i < size; i++){
                t1 = t1.next;
            }
        }
        else{
            for(int i = 0; i < size; i++){
                t2 = t2.next;
            }
        }

        while(t1 != t2){
            t1 = t1.next;
            t2 = t2.next;
        }
        return t1; // or reutrn t2;
    }
}