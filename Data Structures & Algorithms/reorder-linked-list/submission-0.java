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
    public void reorderList(ListNode head) {
        if(head == null)
            return;
        ListNode slow = head;
        ListNode fast = head;
        ListNode first = head;
        ListNode dummy = head;
        while(slow!= null && fast != null && fast.next != null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = reverseList(slow.next);
        slow.next = null;
        while(second != null)
        {
            ListNode temp1 = first.next;
            ListNode temp2 = second.next;
            first.next = second;
            second.next = temp1;

            first = temp1;
            second = temp2;
        }
        head = dummy;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null)
            return head;
        ListNode prev = null;
        ListNode curr = null;
        ListNode node = null;

        curr = head;
        while(curr != null)
        {
            node = curr.next;
            curr.next = prev;
            prev = curr;
            curr = node;
        }
        return prev;
    }
}

/*
[2,4,6,8,9,6,7,9,10]
         s   
                  f
[8,6,4,2]

*/