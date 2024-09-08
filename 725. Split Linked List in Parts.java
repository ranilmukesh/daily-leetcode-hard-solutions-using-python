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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode arr[]=new ListNode[k];
        int length=0;
        ListNode temp=head;
        while(temp!=null){
            length++;
            temp=temp.next;
        }
        int quo=length/k;
        int rem=length%k;
        temp=head;
        for(int i=0;i<k;i++){
            ListNode partHead=temp;
            ListNode partTail=null;
            int current=quo+(i<rem?1:0);
        for(int j=0;j<current;j++){
            partTail=temp;
            if(temp!=null)
            temp=temp.next;
        }
        if(partTail!=null)
        partTail.next=null;
        arr[i]=partHead;
        }
        return arr;
}
}
