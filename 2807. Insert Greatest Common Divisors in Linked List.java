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
    public int gcd(int a, int b)
    {
        while(b!=0)
             {
                int temp=b;
                b=a%b;
                a=temp;
             }
        return a;
    }
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode prev=head,curr=head.next;
        int val;
        while(curr!=null)
        {
            val=gcd(prev.val,curr.val);
            prev.next=new ListNode(val);
            prev.next.next=curr;
            prev=curr;
            curr=curr.next;
        }
        return head;
    }
}
