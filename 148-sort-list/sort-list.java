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
    public ListNode sortList(ListNode head) {

    // GOAL IS TO SOLVE IN O(N logN). so what comes in mind YES, YOU ARE RIGHT (MERGE SORT) :)
        if(head == null) return null;

        return mergeSort(head); // just call the mergeSort()

    }

    public ListNode mergeSort(ListNode head){
        //merge while thinking we should know that we should need middle
        if(head == null || head.next == null) return head;
        
        ListNode mid    = getMid(head);
        ListNode firsthalf  = head;  //before and till mid
        ListNode secondhalf = mid.next; //after mid
        mid.next            = null;

        firsthalf   = mergeSort(firsthalf);
        secondhalf  = mergeSort(secondhalf);

        return merge2lists(firsthalf , secondhalf);
    }

    public ListNode getMid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode merge2lists(ListNode A, ListNode B){
        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        while(A != null && B != null){
            if(A.val < B.val){
                temp.next = A;
                temp = A;
                A= A.next;
            }
            else{
                temp.next = B;
                temp = B;
                B = B.next;
            }
        }

        if(A  == null){
            temp.next = B;
        }
        if(B == null){
            temp.next = A;
        }

        return ans.next;
    }

}