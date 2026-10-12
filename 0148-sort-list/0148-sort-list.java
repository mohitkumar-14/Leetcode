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
    public ListNode mergesort(ListNode l1,ListNode l2)
    {
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        dummy.next=null;
        while(l1!=null && l2!=null)
        {
            if(l1.val < l2.val)
            {
               temp.next=l1;
               temp=l1;
               l1=l1.next;
            }
            else{
                temp.next=l2;
                temp=l2;
                l2=l2.next;
            }
        }
        while(l1!=null)
        {
           temp.next=l1;
           temp=l1;
           l1=l1.next;
        }
        while(l2!=null)
        {
           temp.next=l2;
           temp=l2;
           l2=l2.next;
        }
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode prev=null,slow=head,fast=head;
        while(fast!=null && fast.next!=null)
        {
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;

        ListNode L1=sortList(head);
        ListNode L2=sortList(slow);

        return mergesort(L1,L2);
    }
}