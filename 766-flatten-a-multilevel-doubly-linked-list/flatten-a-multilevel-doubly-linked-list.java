/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
//Refer this => https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/solutions/4517258fast-solution-by-using-recursion
class Solution {
    public Node flatten(Node head) {
        if (head == null) return head;
        recursion(head);

        return head;

    }

    public Node recursion(Node head) {
          if (head == null) return null;

        Node curr = head;

        while (curr != null) {
            Node next = curr.next;
            if (curr.child != null) {
                Node tail = recursion(curr.child);
                if (next == null) {
                    curr.next = curr.child;
                    curr.child.prev = curr;
                    curr.child = null;
                    curr = tail;
                    break;
                } else {
                    next.prev = tail;
                    tail.next = next;
                    curr.next = curr.child;
                    curr.child.prev = curr;
                    curr.child = null;
                }
            }
            if (next == null) break;
            curr = next;
        }
        return curr;
    }
}
