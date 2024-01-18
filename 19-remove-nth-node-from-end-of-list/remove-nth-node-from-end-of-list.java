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
    public ListNode removeNthFromEnd(ListNode head, int n) {
    
        ListNode ans = head;

        int count = 0;

        ListNode temp = head;

        while(temp != null){
            temp = temp.next;
            count++;
        }
        
        if(n >= count ) return head.next;
        
        int len = count - n;

        for(int i = 1; i < len ; i++){
            head = head.next;
        }

        head.next = head.next.next;
        
        return ans;
    }
}