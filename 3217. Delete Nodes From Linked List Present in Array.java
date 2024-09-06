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
    public ListNode modifiedList(int[] nums, ListNode head) {
        //finding max
        int max = 0;
        for (int n : nums) {
            if (n > max) {
                max = n;
            }
        }
        //building "set"
        boolean[] set = new boolean[max + 1];
        for (int n : nums) {
            set[n] = true;
        }
        //removing leading nodes until one is not contained in set
        //don't need to check null since always one value that doesn't fit
        while (head.val <= max && set[head.val]) { 
            head = head.next;
        }
        //removing rest of offending nodes
        //remember, allocate your variables before loops to save space
        ListNode prev = head, curr;
        while(prev != null && prev.next != null) {
            curr = prev.next;
            if(curr.val <= max && set[curr.val]) {
                prev.next = curr.next;
                continue;
            }
            prev = curr;
        }
        return head;
    }
}
