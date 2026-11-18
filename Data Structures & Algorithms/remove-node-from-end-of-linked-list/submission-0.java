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
        if(head == null)
            return head;
        int length = 0;
        ListNode current = head;
        while(current != null)
        {
            length++;
            current = current.next;
        }

        int indexToRemove = length - n;
        current = head;
        int index = 0;
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        //remove the node at indexToRemove
        while(current != null)
        {
            System.out.println("index is " + index);
            
            if(index == indexToRemove)
            {
                ListNode temp = current.next;
                
                current = null;
                prev.next = temp;
                continue;
            }
            index++;
            prev = current;
            current = current.next;
        }
        
        return dummy.next;
    }
}
