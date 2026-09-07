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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp=head;
        int count=0;
        while(temp!=null && count < k)
        {
            temp=temp.next;
            count++;
        }
        if(count < k)
        {
            return head;
        }
        ListNode p=head,q=null,cur=null;
        for(int i=0;i<k;i++){
            q=p.next;
            p.next=cur;
            cur=p;
            p=q;
        }

        head.next=reverseKGroup(p,k);

        return cur;
    }
}