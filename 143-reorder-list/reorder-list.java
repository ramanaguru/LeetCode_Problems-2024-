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



public class Solution {
    public ListNode reorderList(ListNode A) {
        //A = 1, 2, 3, 4, 5

        //base case
        if(A==null|| A.next == null){
            return A;
        }

        //find middle Node

        ListNode mid = findMid(A);// middle Node is 2
        

        ListNode afterMid = mid.next;// 3 -> 4 -> 5

        mid.next = null;// 3 -> 4 -> 5 -> null

        ListNode  afterMid_reverse = reverse(afterMid);//this function calls to reverse the after mid Nodes

        ListNode start = A;

        while(start.next != null){

            ListNode t1 = start.next;
            ListNode t2 = afterMid_reverse.next;
            start.next = afterMid_reverse;
            start = t1;
            afterMid_reverse.next = start;
            afterMid_reverse = t2;

        }
        
        if(afterMid_reverse != null){
            start.next = afterMid_reverse;
        }

        return A;




    }
    public ListNode findMid(ListNode A){
        if(A == null){
            return null;
        }

        ListNode slow = A;
        ListNode fast = A;

        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
            
        }

        return slow;
        
    }

     public ListNode reverse(ListNode A){
        if(A == null){
            return null;
        }

       ListNode h1 = A;
       ListNode h2 = null;
       //3 -> 4 -> 5

       //5 -> 4 -> 3

            while(h1 != null){
                ListNode temp = h1; 
                h1 = h1.next; 
                temp.next = h2; 
                h2 = temp;
            }

            return h2;
    }
}


// A = [1, 2, 3, 4, 5] 
// mid --> 2

//mid = 3 4 5

//orgA   = 1  2  -> null
//revMid = 5  4  3 --> null


//(merge of orgA and revMid)--> 1 5 2 4 3
