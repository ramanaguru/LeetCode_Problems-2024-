IDEA

/*
        step - 1 : slow and fast will at starting fo the head

        step - 2 :

              slow      fast
        1 --->  2  ---> 2  ---> 1
               Mid

        Step - 3:

             reverse(slow.next); ===>  that will be ( 1 ---> 2)

             move the slow pointer one place ahead

             head           slow
             1 --->  2  ---> 1  ---> 2

        Step - 4 : check A.val and slow.val if equals return true else false
*/


CODE

class Solution {
    public boolean isPalindrome(ListNode head) {


        ListNode slow = head;
        ListNode fast = head;

        //Find the middle
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        slow.next = getReverse(slow.next);

        slow = slow.next;

        while(slow != null){
            if(head.val != slow.val){
                return false;
            }
            slow = slow.next;
            head = head.next;
        }

        return true;
    }


    public ListNode getReverse(ListNode head){
        ListNode h1 = head;
        ListNode h2 = null;

        while(h1 != null){
            ListNode temp = h1;
            h1 = h1.next;
            temp.next = h2;
            h2 = temp;
        }

        return h2;
    }

}
