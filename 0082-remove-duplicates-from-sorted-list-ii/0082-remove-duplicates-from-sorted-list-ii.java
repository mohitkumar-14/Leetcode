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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy =new ListNode(0);
        dummy.next=head;
        ListNode slow=dummy,fast=head;
        while(fast!=null && fast.next!=null)
        {
            if(fast.val==fast.next.val)
            {
                int x=fast.val;
                while(fast!=null && fast.val == x)
                {
                    fast=fast.next;
                }
                slow.next=fast;
            }
            else{  
                fast=fast.next;
                slow=slow.next;
            }
        }
        return dummy.next;
    }
}