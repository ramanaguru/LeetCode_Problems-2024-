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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k ==0 ) return head;

        ListNode temp = head;
        int count = 1;

        while(temp.next != null){
            count++;
            temp= temp.next;
        }
        

        k = k % count;

        temp.next = head;
        int size = count - k;

        while(size > 0){
          temp = temp.next;
          size--;
        }

        head = temp.next;
        temp.next = null;

        return head;
    }
}